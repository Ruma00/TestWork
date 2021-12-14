package main.Controllers;

import main.Models.Product;
import main.Models.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class DefaultController {

    @Autowired
    ProductRepository productRepository;

    public DefaultController(ProductRepository repository) {
        productRepository = repository;
    }

    @RequestMapping("/")
    public String index(Model model) {
        Iterable<Product> productIterable = productRepository.findAll();
        ArrayList<Product> products = new ArrayList<>();

        for (Product product : productIterable) {
            products.add(product);
        }

        model.addAttribute("products", products)
                .addAttribute("productsCount", products.size());

        return "index";
    }
}
