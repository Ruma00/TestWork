package main.Controllers;

import main.Models.Product;
import main.Models.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository repository) {
        productRepository = repository;
    }

    @GetMapping("/products/")
    public List<Product> productList() {
        Iterable<Product> iterable = productRepository.findAll();

        List<Product> list = new ArrayList<>();

        for (Product product : iterable) {
            list.add(product);
        }

        return list;
    }

    @PostMapping("/products/")
    public int addProduct(Product product) {
        Product newProduct = productRepository.save(product);
        
        return newProduct.getId();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (!optionalProduct.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return new ResponseEntity<>(optionalProduct.get(), HttpStatus.OK);
    }
}
