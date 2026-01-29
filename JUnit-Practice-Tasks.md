# JUnit with Spring Boot Practice Tasks

A comprehensive reference guide for practicing JUnit testing with Spring Boot, organized by difficulty level.

---

## 📝 Level 1: Foundation Tasks

### Task 1.1: Basic Unit Test

```java
// Given this simple service method:
public class CalculatorService {
    public int add(int a, int b) {
        return a + b;
    }
    
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}
```

**Tasks:**
- Write a test for `add()` method with positive numbers
- Write a test for `add()` with negative numbers
- Write tests for `isEven()` with even and odd numbers
- Add a test for `add()` with zero values

---

### Task 1.2: String Manipulation Testing

```java
public class StringService {
    public String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
    
    public boolean isPalindrome(String text) {
        // implement logic
    }
}
```

**Tasks:**
- Test `reverse()` with normal string
- Test `reverse()` with empty string
- Test `reverse()` with single character
- Implement and test `isPalindrome()` method

---

## 🎯 Level 2: Spring Boot Integration

### Task 2.1: Repository Testing

```java
@Entity
public class Product {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private double price;
    private int stock;
}

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByStockGreaterThan(int minStock);
    Optional<Product> findByName(String name);
}
```

**Tasks:**
- Create `@DataJpaTest` for ProductRepository
- Test `save()` and `findById()` operations
- Test custom query `findByStockGreaterThan()`
- Test `findByName()` returns empty when not found
- Add `@BeforeEach` to setup test data

---

### Task 2.2: Service Layer with Mocking

```java
@Service
public class OrderService {
    @Autowired
    private ProductRepository productRepository;
    
    public Order createOrder(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new ProductNotFoundException());
            
        if (product.getStock() < quantity) {
            throw new InsufficientStockException();
        }
        
        // Create order logic
    }
}
```

**Tasks:**
- Create service test with `@ExtendWith(MockitoExtension.class)`
- Mock ProductRepository using `@Mock`
- Test successful order creation
- Test `ProductNotFoundException` scenario
- Test `InsufficientStockException` scenario
- Verify repository interactions

---

## 🌐 Level 3: REST API Testing

### Task 3.1: Controller Testing

```java
@RestController
@RequestMapping("/api/users")
public class UserController {
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        // implementation
    }
    
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDTO) {
        // implementation
    }
}
```

**Tasks:**
- Create `@WebMvcTest(UserController.class)`
- Test GET endpoint returns 200 with valid ID
- Test GET endpoint returns 404 with invalid ID
- Test POST endpoint with valid user data
- Test POST endpoint returns 400 with invalid data
- Verify JSON response structure

---

### Task 3.2: REST Error Handling

```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound() {
        // implementation
    }
}
```

**Tasks:**
- Test controller throws `ResourceNotFoundException`
- Verify error response format
- Test HTTP status code in error response
- Test error message in response body

---

## 🔄 Level 4: Business Logic Scenarios

### Task 4.1: E-commerce Cart

```java
@Service
public class ShoppingCartService {
    public Cart addItem(Cart cart, CartItem item) {
        // Business rules:
        // 1. Item quantity must be positive
        // 2. Product must be in stock
        // 3. Max 10 items per product in cart
        // 4. Apply bulk discount for 5+ items
    }
}
```

**Tasks:**
- Test adding valid item to empty cart
- Test adding item with zero quantity (should throw)
- Test adding item exceeding stock limit
- Test adding 11th item of same product (should fail)
- Test bulk discount application
- Test multiple items with different products

---

### Task 4.2: Banking Transactions

```java
@Service
public class AccountService {
    public Transaction transfer(TransferRequest request) {
        // Rules:
        // 1. Sufficient balance in source account
        // 2. Accounts must be active
        // 3. Minimum transfer amount is $1
        // 4. Maximum daily limit per account
        // 5. Cannot transfer to same account
    }
}
```

**Tasks:**
- Test successful transfer
- Test insufficient balance scenario
- Test transfer to inactive account
- Test transfer below minimum amount
- Test exceeding daily limit
- Test transfer to same account (should fail)

---

## 📊 Level 5: Integration & Edge Cases

### Task 5.1: User Registration Flow

```java
@Service
public class UserRegistrationService {
    public User register(UserRegistrationDTO dto) {
        // Steps:
        // 1. Validate email format
        // 2. Check email not already registered
        // 3. Validate password strength
        // 4. Save user to database
        // 5. Send verification email
        // 6. Return created user
    }
}
```

**Tasks:**
- Write `@SpringBootTest` for complete flow
- Test successful registration
- Test duplicate email registration
- Test weak password validation
- Mock email service and verify it's called
- Test database persistence

---

### Task 5.2: Parameterized Tests

```java
public class ValidationService {
    public boolean isValidEmail(String email) {
        // email validation logic
    }
    
    public boolean isValidPhoneNumber(String phone) {
        // phone validation
    }
}
```

**Tasks:**
- Create parameterized test for valid emails
- Create parameterized test for invalid emails
- Test phone numbers with different formats
- Use `@CsvSource` for test data
- Add edge cases (null, empty, very long strings)

---

## 🧩 Level 6: Real-World Scenarios

### Task 6.1: Authentication & Authorization

```java
@RestController
public class SecureController {
    @GetMapping("/admin/dashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminDashboard() {
        return "Admin Data";
    }
    
    @GetMapping("/user/profile/{userId}")
    @PreAuthorize("#userId == principal.id")
    public UserProfile getUserProfile(@PathVariable Long userId) {
        // implementation
    }
}
```

**Tasks:**
- Test admin endpoint with admin user
- Test admin endpoint with regular user (should get 403)
- Test user profile access with correct user ID
- Test user profile access with different user ID (should fail)
- Test unauthenticated access (should get 401)

---

## 📚 Reference Guide

This document serves as a practice reference for JUnit testing with Spring Boot. Work through the levels progressively to build your testing skills from basic unit tests to complex integration scenarios.

### Recommended Approach:
1. Start with Level 1 to master basic JUnit syntax
2. Progress through Level 2 to understand Spring Boot testing annotations
3. Tackle Level 3 for REST API testing patterns
4. Apply business logic testing in Level 4
5. Master integration testing in Level 5
6. Complete with real-world security scenarios in Level 6

Happy Testing! 🚀
