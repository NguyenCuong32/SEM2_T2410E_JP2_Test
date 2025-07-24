package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication là một annotation tiện lợi gộp 3 annotation sau:
// @Configuration: Đánh dấu lớp này là một lớp cấu hình cho Spring context.
// @EnableAutoConfiguration: Tự động cấu hình Spring Boot dựa trên các dependency có trong classpath.
// @ComponentScan: Quét các component (như @Controller, @Service, @Repository) từ package hiện tại và các package con.
@SpringBootApplication
public class Main { // Đảm bảo tên class này khớp với tên file của bạn (Main.java)

    public static void main(String[] args) {
        // Đây là phương thức chính khởi chạy ứng dụng Spring Boot.
        // Nó sẽ khởi tạo Spring Application Context, cấu hình Tomcat (hoặc server khác),
        // và triển khai các Controller, Service, Repository.
        SpringApplication.run(Main.class, args);
    }
}