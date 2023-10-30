package upeu.edu.pe.lp.infrastructure.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.lp.app.service.ProductService;
import upeu.edu.pe.lp.infrastructure.entity.ProductEntity;

import java.util.Optional;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final Logger log = LoggerFactory.getLogger(HomeController.class);
    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String home(Model model){

        model.addAttribute("products",productService.getProducts());

        return "home";
    }

    @GetMapping("/{id}")
    public String productoHome(@PathVariable Integer id, Model model) {
        log.info("Id producto enviado como parámetro {}", id);
        ProductEntity product = productService.getProductById(id);

        model.addAttribute("producto", product);

        return "user/producto_home";
    }
    
    


}
