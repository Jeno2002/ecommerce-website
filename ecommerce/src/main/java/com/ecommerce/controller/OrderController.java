package com.ecommerce.controller;

import com.ecommerce.model.Order;
import com.ecommerce.model.User;
import com.ecommerce.service.CartService;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final CartService cartService;
    private final UserService userService;

    @GetMapping
    public String myOrders(Model model, Authentication auth) {
        User user = userService.getLoggedInUser(auth);
        model.addAttribute("orders", orderService.getUserOrders(user));
        model.addAttribute("cartCount", cartService.getCartCount(user));
        return "order/orders";
    }

    @GetMapping("/checkout")
    public String checkoutPage(Model model, Authentication auth) {
        User user = userService.getLoggedInUser(auth);
        var items = cartService.getCartItems(user);
        if (items.isEmpty()) return "redirect:/cart";
        model.addAttribute("cartItems", items);
        model.addAttribute("cartTotal", cartService.getCartTotal(user));
        model.addAttribute("cartCount", items.size());
        model.addAttribute("user", user);
        return "order/checkout";
    }

    @PostMapping("/place")
    public String placeOrder(@RequestParam String shippingAddress,
                             Authentication auth,
                             RedirectAttributes redirectAttributes) {
        User user = userService.getLoggedInUser(auth);
        try {
            Order order = orderService.placeOrder(user, shippingAddress);
            redirectAttributes.addFlashAttribute("success",
                    "Order #" + order.getId() + " placed successfully!");
            return "redirect:/orders";
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/cart";
        }
    }

    @GetMapping("/{id}")
    public String orderDetail(@PathVariable Long id, Model model, Authentication auth) {
        User user = userService.getLoggedInUser(auth);
        Order order = orderService.getOrderById(id);
        if (!order.getUser().getId().equals(user.getId())
                && !user.getRole().equals("ROLE_ADMIN")) {
            return "redirect:/orders";
        }
        model.addAttribute("order", order);
        model.addAttribute("cartCount", cartService.getCartCount(user));
        return "order/detail";
    }
}
