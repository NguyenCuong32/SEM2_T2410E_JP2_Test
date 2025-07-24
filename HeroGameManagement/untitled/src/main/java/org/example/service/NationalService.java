package org.example.service;

import org.example.model.National;
import org.example.repository.NationalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Đánh dấu đây là một Spring Service component
public class NationalService {

    @Autowired // Tự động inject NationalRepository
    private NationalRepository nationalRepository;

    public List<National> getAllNationals() {
        return nationalRepository.findAll();
    }

    public Optional<National> getNationalById(Integer id) {
        return nationalRepository.findById(id);
    }

    public National addNational(National national) {
        return nationalRepository.save(national); // Sử dụng phương thức save của JpaRepository
    }

    public void deleteNational(Integer id) {
        nationalRepository.deleteById(id); // Sử dụng phương thức deleteById của JpaRepository
    }
}
