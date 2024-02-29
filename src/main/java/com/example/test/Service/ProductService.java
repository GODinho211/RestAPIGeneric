package com.example.test.Service;

import com.example.test.Repository.ProductRepository;
import com.example.test.model.Products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){

        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(n -> products.add(n));
        return products;
    }
    public void save(Product data){
        productRepository.save(data);
    }

    public void delete(long userId) {
        productRepository.deleteById(userId);
    }

    public Product findById(long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId); //optional permite que o objeto possa ou nao ser null
        return optionalProduct.orElse(null);
    }


}
