package com.ecommerce.config;

import com.ecommerce.model.Product;
import com.ecommerce.model.User;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        seedUsers();
        seedProducts();
    }

    private void seedUsers() {
        if (userRepository.count() > 0) return;

        userRepository.saveAll(List.of(
            User.builder()
                .name("Admin User")
                .email("admin@shopease.com")
                .password(passwordEncoder.encode("admin123"))
                .role("ROLE_ADMIN")
                .enabled(true)
                .build(),
            User.builder()
                .name("John Doe")
                .email("john@example.com")
                .password(passwordEncoder.encode("user123"))
                .role("ROLE_USER")
                .enabled(true)
                .build()
        ));
        System.out.println("✅ Sample users seeded");
    }

    private void seedProducts() {
//        if (productRepository.count() > 0) return;

        productRepository.saveAll(List.of(
            Product.builder().name("Wireless Noise-Cancelling Headphones")
                .description("Premium over-ear headphones with 30hr battery life and deep bass sound.")
                .price(3499.0).stock(50).category("Electronics")
                .imageUrl("https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=400&h=300&fit=crop")
                .available(true).build(),

            Product.builder().name("Mechanical Keyboard RGB")
                .description("Tactile switches with customizable RGB backlighting. Perfect for gaming and typing.")
                .price(2999.0).stock(30).category("Electronics")
                .imageUrl("https://images.unsplash.com/photo-1587829741301-dc798b83add3?w=400&h=300&fit=crop")
                .available(true).build(),

            Product.builder().name("Running Shoes Pro")
                .description("Lightweight and breathable running shoes with cushioned soles for all terrains.")
                .price(1899.0).stock(100).category("Footwear")
                .imageUrl("https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=400&h=300&fit=crop")
                .available(true).build(),

            Product.builder().name("Men's Casual T-Shirt")
                .description("100% cotton premium t-shirt. Available in multiple colors. Comfortable all-day wear.")
                .price(499.0).stock(200).category("Clothing")
                .imageUrl("https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?w=400&h=300&fit=crop")
                .available(true).build(),

            Product.builder().name("Stainless Steel Water Bottle")
                .description("Double-walled insulated bottle keeps drinks cold 24hrs, hot 12hrs. 750ml capacity.")
                .price(799.0).stock(75).category("Kitchen")
                .imageUrl("https://images.unsplash.com/photo-1602143407151-7111542de6e8?w=400&h=300&fit=crop")
                .available(true).build(),

            Product.builder().name("Yoga Mat Premium")
                .description("Extra thick non-slip yoga mat with carrying strap. 6mm thickness for joint support.")
                .price(1299.0).stock(60).category("Sports")
                .imageUrl("https://images.unsplash.com/photo-1571019613454-1cb2f99b2d8b?w=400&h=300&fit=crop")
                .available(true).build(),

            Product.builder().name("Portable Bluetooth Speaker")
                .description("360° surround sound, IPX5 waterproof, 12hr playtime. Perfect for outdoor adventures.")
                .price(2499.0).stock(40).category("Electronics")
                .imageUrl("https://images.unsplash.com/photo-1608043152269-423dbba4e7e1?w=400&h=300&fit=crop")
                .available(true).build(),

            Product.builder().name("Leather Wallet Slim")
                .description("Genuine leather minimalist wallet with RFID blocking. Fits 8 cards and cash.")
                .price(699.0).stock(120).category("Accessories")
                .imageUrl("https://images.unsplash.com/photo-1627123424574-724758594e93?w=400&h=300&fit=crop")
                .available(true).build(),
                
                Product.builder()
                .name("Gaming Laptop")
                .description("High performance gaming laptop with RTX graphics")
                .price(75000.0)
                .stock(15)
                .category("Electronics")
                .imageUrl("https://images.unsplash.com/photo-1517336714731-489689fd1ca8?w=400")
                .available(true)
                .build(),

            Product.builder()
                .name("Smartphone Pro Max")
                .description("Latest smartphone with powerful camera")
                .price(59999.0)
                .stock(25)
                .category("Electronics")
                .imageUrl("https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?w=400")
                .available(true)
                .build(),
                
                Product.builder()
                .name("Smart LED TV 43 inch")
                .description("Full HD Smart TV with Android OS, Dolby Audio, and built-in apps like Netflix & YouTube.")
                .price(27999.0)
                .stock(20)
                .category("Electronics")
                .imageUrl("https://images.unsplash.com/photo-1593784991095-a205069470b6?w=400")
                .available(true)
                .build(),

            Product.builder()
                .name("Office Ergonomic Chair")
                .description("Comfortable office chair with lumbar support, adjustable height, and breathable mesh back.")
                .price(5999.0)
                .stock(35)
                .category("Furniture")
                .imageUrl("https://images.unsplash.com/photo-1580480055273-228ff5388ef8?w=400")
                .available(true)
                .build()
                
        ));
        System.out.println("✅ Sample products seeded");
    }
}
