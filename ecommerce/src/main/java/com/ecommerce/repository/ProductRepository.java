package com.ecommerce.repository;

import com.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByAvailableTrue();
    List<Product> findByCategoryAndAvailableTrue(String category);
    List<Product> findByNameContainingIgnoreCaseAndAvailableTrue(String name);

    @Query("SELECT DISTINCT p.category FROM Product p WHERE p.available = true")
    List<String> findDistinctCategories();
}
