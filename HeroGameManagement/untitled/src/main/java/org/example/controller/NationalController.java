package org.example.controller;

import org.example.model.National;
import org.example.service.NationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Đánh dấu đây là một REST Controller
@RequestMapping("/api/nationals") // Base URL cho các API liên quan đến quốc gia
public class NationalController {

    @Autowired
    private NationalService nationalService;

    // GET: Lấy tất cả quốc gia
    @GetMapping
    public List<National> getAllNationals() {
        return nationalService.getAllNationals();
    }

    // GET: Lấy quốc gia theo ID
    @GetMapping("/{id}")
    public ResponseEntity<National> getNationalById(@PathVariable Integer id) {
        Optional<National> national = nationalService.getNationalById(id);
        return national.map(ResponseEntity::ok) // Nếu tìm thấy, trả về 200 OK và đối tượng
                .orElseGet(() -> ResponseEntity.notFound().build()); // Không tìm thấy, trả về 404 Not Found
    }

    // POST: Thêm quốc gia mới
    @PostMapping
    public ResponseEntity<National> addNational(@RequestBody National national) {
        National savedNational = nationalService.addNational(national);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedNational); // Trả về 201 Created
    }

    // DELETE: Xóa quốc gia theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNational(@PathVariable Integer id) {
        try {
            nationalService.deleteNational(id);
            return ResponseEntity.noContent().build(); // Trả về 204 No Content
        } catch (Exception e) {
            // Xử lý lỗi nếu có ràng buộc khóa ngoại (ví dụ: có người chơi thuộc quốc gia này)
            return ResponseEntity.status(HttpStatus.CONFLICT) // 409 Conflict
                    .body(null); // Không trả về nội dung
        }
    }
}