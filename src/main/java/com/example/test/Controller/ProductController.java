package com.example.test.Controller;


import com.example.test.Service.ProductService;
import com.example.test.model.Products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){

        this.productService = productService;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<String> saveProduct(@RequestBody Product data) {
        productService.save(data);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable long productId) {

        productService.delete(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Deleted successfully");
    }

    @PutMapping("/updateProduct/{productId}")
    public void updateProduct(@PathVariable long productId, @RequestBody Product updatedProductData) {
//        userService.update(userId, updatedProductData );
    }

    @GetMapping("/getAll")
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @GetMapping("/findById/{productId}")
    public ResponseEntity<Product> findById(@PathVariable long productId) {
        Product product = productService.findById(productId);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
