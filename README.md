# 🛒 E-Commerce Web Application (Spring Boot)

## 📌 Overview

This is a full-stack **E-Commerce Web Application** developed using **Java Spring Boot, Thymeleaf, and MySQL**.
The application allows users to browse products, manage carts, place orders, and perform authentication securely.

---

## 🚀 Features

* 🔐 User Authentication (Login & Register using Spring Security)
* 🛍️ Product Listing & Product Details
* 🛒 Add to Cart / Remove from Cart
* 📦 Order Placement & Order History
* 👨‍💼 Admin Panel for Product Management
* 🔄 Dynamic UI using Thymeleaf

---

## 🏗️ Project Structure

* `controller/` → Handles HTTP requests
* `service/` → Business logic (Cart, Order, Product, User)
* `model/` → Entity classes (User, Product, Order, CartItem)
* `repository/` → Database interaction (JPA)
* `config/` → Security & App configuration

---

## 🛠️ Tech Stack

* **Backend:** Java, Spring Boot
* **Frontend:** Thymeleaf, HTML, CSS
* **Database:** MySQL
* **Security:** Spring Security
* **Build Tool:** Maven

---

## ⚙️ How to Run Locally

### 1️⃣ Clone Repository

```bash
git clone https://github.com/Jeno2002/ecommerce-website.git
cd ecommerce-website
```

### 2️⃣ Configure Database

Update in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=your_password
```

### 3️⃣ Run Application

* Open in VS Code / Eclipse
* Run: `EcommerceApplication.java`

### 4️⃣ Open Browser

```
http://localhost:8080
```

---

## 📸 Screenshots

(Add images inside `screenshots/` folder)

```
![Home](screenshots/home.png)
![Cart](screenshots/cart.png)
![Orders](screenshots/orders.png)
```

---

## 🔒 Security

* Implemented **Spring Security**
* Custom User Details Service
* Role-based access (User/Admin)

---

## 📈 Key Highlights

* Clean MVC architecture
* Real-time cart management
* Secure authentication system
* Database integration using JPA

---

## 👨‍💻 Author

**Infant Jeno J**

* GitHub: https://github.com/Jeno2002

---

## ⭐ Future Enhancements

* Payment Gateway Integration
* REST API version (React frontend)
* Email notifications
* Product search & filters
