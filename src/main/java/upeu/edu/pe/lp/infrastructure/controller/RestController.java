package upeu.edu.pe.lp.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.lp.app.service.ProductService;

@Controller
@RequestMapping("admin/products")
public class RestController {
    private final ProductService productService;

    public RestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/create")
    public String create(){
        return "admin/products/create";
    }
}
