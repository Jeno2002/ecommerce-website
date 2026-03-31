# 🛒 ShopEase - Java Full Stack E-Commerce App

A complete e-commerce web application built with **Spring Boot 3**, **Thymeleaf**, **Spring Security**, **Spring Data JPA**, and **MySQL**.

---

## 🚀 Tech Stack

| Layer       | Technology                        |
|-------------|-----------------------------------|
| Backend     | Spring Boot 3.2, Java 17          |
| Frontend    | Thymeleaf + Bootstrap 5           |
| Security    | Spring Security 6 (BCrypt)        |
| Database    | MySQL 8+                          |
| ORM         | Spring Data JPA / Hibernate       |
| Build Tool  | Maven                             |

---

## 📁 Project Structure

```
src/main/java/com/ecommerce/
├── EcommerceApplication.java       # Main entry point
├── config/
│   ├── SecurityConfig.java         # Spring Security config
│   ├── WebConfig.java              # Static resource handler
│   └── DataSeeder.java             # Sample data on startup
├── controller/
│   ├── AuthController.java         # Login, Register
│   ├── ProductController.java      # Product list & detail
│   ├── CartController.java         # Cart CRUD
│   ├── OrderController.java        # Checkout & order history
│   └── AdminController.java        # Admin dashboard
├── model/
│   ├── User.java
│   ├── Product.java
│   ├── CartItem.java
│   ├── Order.java
│   └── OrderItem.java
├── repository/                     # Spring Data JPA repos
├── service/
│   ├── CustomUserDetailsService.java
│   ├── UserService.java
│   ├── ProductService.java
│   ├── CartService.java
│   └── OrderService.java
src/main/resources/
├── templates/
│   ├── auth/       login.html, register.html
│   ├── product/    list.html, detail.html
│   ├── cart/       cart.html
│   ├── order/      checkout.html, orders.html, detail.html
│   ├── admin/      dashboard.html, product-form.html
│   └── error/      access-denied.html
└── application.properties
```

---

## ⚙️ Setup Instructions

### 1. Prerequisites
- Java 17+
- Maven 3.8+
- MySQL 8+

### 2. Create Database
```sql
CREATE DATABASE ecommerce_db;
```

### 3. Configure application.properties
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

### 4. Run the App
```bash
mvn spring-boot:run
```

Visit: **http://localhost:8080**

---

## 👤 Default Credentials (seeded on first run)

| Role  | Email                  | Password   |
|-------|------------------------|------------|
| Admin | admin@shopease.com     | admin123   |
| User  | john@example.com       | user123    |

---

## ✨ Features

### Customer
- ✅ Register & Login (Spring Security)
- ✅ Browse products with search & category filter
- ✅ Product detail page
- ✅ Add to cart / update quantity / remove
- ✅ Checkout with shipping address
- ✅ Order history & detail view

### Admin (login as admin)
- ✅ Dashboard with stats (products, orders, revenue)
- ✅ Add / Edit / Delete products with image upload
- ✅ View all orders
- ✅ Update order status (PENDING → CONFIRMED → SHIPPED → DELIVERED)

---

## 🔗 URL Map

| URL                         | Access    | Description            |
|-----------------------------|-----------|------------------------|
| /                           | Public    | Product listing        |
| /products                   | Public    | Product listing        |
| /products/{id}              | Public    | Product detail         |
| /register                   | Public    | Register               |
| /login                      | Public    | Login                  |
| /cart                       | User      | Shopping cart          |
| /cart/add                   | User      | Add to cart            |
| /orders/checkout            | User      | Checkout page          |
| /orders/place               | User      | Place order            |
| /orders                     | User      | Order history          |
| /orders/{id}                | User      | Order detail           |
| /admin                      | Admin     | Admin dashboard        |
| /admin/products/new         | Admin     | Add product            |
| /admin/products/edit/{id}   | Admin     | Edit product           |
| /admin/orders/{id}/status   | Admin     | Update order status    |
