package com.ecommerce.controller;

import com.ecommerce.model.User;
import com.ecommerce.service.CartService;
import com.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final UserService userService;

    @GetMapping
    public String viewCart(Model model, Authentication auth) {
        User user = userService.getLoggedInUser(auth);
        var items = cartService.getCartItems(user);
        model.addAttribute("cartItems", items);
        model.addAttribute("cartTotal", cartService.getCartTotal(user));
        model.addAttribute("cartCount", items.size());
        return "cart/cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam Long productId,
                            @RequestParam(defaultValue = "1") int quantity,
                            Authentication auth,
                            RedirectAttributes redirectAttributes) {
        User user = userService.getLoggedInUser(auth);
        cartService.addToCart(user, productId, quantity);
        redirectAttributes.addFlashAttribute("success", "Item added to cart!");
        return "redirect:/products/" + productId;
    }

    @PostMapping("/update/{id}")
    public String updateQuantity(@PathVariable Long id,
                                 @RequestParam int quantity,
                                 Authentication auth) {
        User user = userService.getLoggedInUser(auth);
        cartService.updateQuantity(user, id, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/remove/{id}")
    public String removeItem(@PathVariable Long id, Authentication auth) {
        User user = userService.getLoggedInUser(auth);
        cartService.removeFromCart(user, id);
        return "redirect:/cart";
    }
}
