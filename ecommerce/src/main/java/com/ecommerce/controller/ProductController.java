package com.ecommerce.controller;

import com.ecommerce.service.CartService;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CartService cartService;
    private final UserService userService;

    @GetMapping({"/", "/products"})
    public String listProducts(@RequestParam(required = false) String search,
                               @RequestParam(required = false) String category,
                               Model model, Authentication auth) {
        if (search != null && !search.isBlank()) {
            model.addAttribute("products", productService.searchProducts(search));
            model.addAttribute("search", search);
        } else if (category != null && !category.isBlank()) {
            model.addAttribute("products", productService.getProductsByCategory(category));
            model.addAttribute("selectedCategory", category);
        } else {
            model.addAttribute("products", productService.getAllAvailableProducts());
        }

        model.addAttribute("categories", productService.getAllCategories());

        if (auth != null) {
            var user = userService.getLoggedInUser(auth);
            model.addAttribute("cartCount", cartService.getCartCount(user));
        }
        return "product/list";
    }

    @GetMapping("/products/{id}")
    public String productDetail(@PathVariable Long id, Model model, Authentication auth) {
        model.addAttribute("product", productService.getProductById(id));
        if (auth != null) {
            var user = userService.getLoggedInUser(auth);
            model.addAttribute("cartCount", cartService.getCartCount(user));
        }
        return "product/detail";
    }
}
