
# 🍒 **Cherry Cake Cafe Backend**

Welcome to the **Cherry Cake Cafe** backend! This backend is designed to manage various operations of the cafe, including user management, product handling, and order processing. The backend is built using **Java** and **Spring Framework**, designed to meet the needs of our cafe and provide an efficient system.

---

## 🌟 **Features**

- **User Management**: Register, login, and authenticate users.
- **Product Handling**: Retrieve all products or top-rated items.
- **Order Management**: Submit, manage, and track customer orders.

---

## 🛠️ **Tech Stack**

- **Programming Language**: Java
- **Framework**: Spring Boot
- **Database**: Configurable for use with your choice of database (MySQL, PostgreSQL, etc.)
- **Dependency Management**: Maven
- **Architecture**: Layered architecture with separation of concerns (Controller, Service, Database)

---

## 📂 **Project Structure**

```plaintext
src/main/java/org/example/
├── controller_api          # Contains API controllers for handling HTTP requests
│   ├── Main.java           # Main entry point of the application
│   ├── OrderAPI.java       # Handles requests related to orders
│   ├── ProductApi.java     # Handles requests related to products
│   └── UserApi.java        # Handles user-related requests
│
├── logic                   # Contains service and data access layers
│   ├── database            # Data Access Layer (DAL) for database operations
│   │   ├── DbConnection.java  # Manages database connection
│   │   ├── OrderDAL.java      # Data access logic for orders
│   │   ├── ProductsDAL.java   # Data access logic for products
│   │   └── UserDAL.java       # Data access logic for users
│   │
│   ├── dto                 # Data Transfer Objects for structured data exchange
│   │   ├── LoginDTO.java      # DTO for login information
│   │   ├── OrderDto.java      # DTO for order information
│   │   └── ProductDto.java    # DTO for product information
│   │
│   ├── entity              # Entity classes representing database models
│   │   ├── Order.java        # Order entity
│   │   └── User.java         # User entity
│   │
│   └── service             # Service layer for business logic
│       ├── OrdersService.java  # Business logic for order management
│       ├── ProductService.java # Business logic for product management
│       ├── UserService.java    # Business logic for user management
│       └── WebConfig.java      # Configuration for API access
│
└── application.properties   # Application configuration
```

---

## 🚀 **Getting Started**

### **1. Clone the Repository**
```bash
git clone https://github.com/username/cherry-cake-cafe-backend.git
cd cherry-cake-cafe-backend
```

### **2. Build the Project**
```bash
./mvnw clean install
```

### **3. Run the Application**
```bash
./mvnw spring-boot:run
```

### **4. Access the API**
By default, the backend runs on `http://localhost:8080`.

---

## 📖 **API Documentation**

### **User APIs**

#### ➡️ Register User
- **Endpoint**: `user/register`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "fullName": "Shahzod Zohidov",
    "phone": "1234567890",
    "password": "password123"
  }
  ```
#### ➡️ Login User
- **Endpoint**: `/user/login`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "phoneNumber": "1234567890",
    "password": "password123"
  }
  ```
### **Product APIs**

#### ➡️ Get All Products
- **Endpoint**: `/products/all`
- **Method**: `GET`
- **Response**:
  ```json
  [
    { "id": 1, "name": "Cake A","picture": "link to the picture","size": "200ml","alt": "picture short description", "price": 10,"raring": "1-5","description": "product description" },
  ]
  ```

#### ➡️ Get Top Products
- **Endpoint**: `/products/top`
- **Method**: `GET`
- **Response**:
  ```json
  [
    { "id": 1, "name": "Cake A","picture": "link to the picture","size": "200ml","alt": "picture short description", "price": 10,"raring": "1-5","description": "product description" },
  ]
  ```

### **Order APIs**

#### ➡️ Submit Order
- **Endpoint**: `/order/create`
- **Method**: `POST`
- **Request Body**:
  ```json
  {"quantity":6,"region":"Uzbekistan","date":"2024/11/30","price":17,"userId":11}
  ```

---

## 🧩 **How It Works**

1. **User Management**:
   - Users can register and log in securely.
   - The backend validates input and communicates with the database for authentication.

2. **Product Handling**:
   - The backend communicates with the `ProductsDAL` layer to fetch all products or the top-rated products.

3. **Order Processing**:
   - Orders are processed using the `OrdersService` and `OrderDAL`. The backend ensures data consistency and appropriate management of orders.

---

## 📜 **Code Design Principles**

1. **KISS (Keep It Simple, Stupid)**:
   - Classes and methods have a single responsibility, making the codebase easy to maintain and extend.
2. **DRY (Don't Repeat Yourself)**:
   - Reusable logic is abstracted into service methods to avoid duplication.
3. **YAGNI (You Aren’t Gonna Need It)**:
   - Features are implemented only when required, avoiding overcomplication.
4. **SOLID**:
   - The application follows principles like Single Responsibility and Open-Closed, ensuring maintainability and scalability.

---

## 🌐 **Contact & Support**

For questions or support, feel free to create an issue in the repository or contact us at **Shahzod_Zohidov@student.itpu.uz**.

---

**Enjoy managing your cafe with the Cherry Cake Cafe !** 🍰
