package upeu.edu.pe.lp.infrastructure.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.lp.app.service.ProductService;
import upeu.edu.pe.lp.app.service.StockService;
import upeu.edu.pe.lp.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp.infrastructure.entity.StockEntity;
import upeu.edu.pe.lp.infrastructure.entity.UserEntity;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    public final ProductService productService;
    private final StockService stockService;

    public AdminController(ProductService productService, StockService stockService) {
        this.productService = productService;
        this.stockService = stockService;
    }

    @GetMapping
    public String home (Model model){
        model.addAttribute("products",productService.getProducts());
        return "admin/home_admin2";
    }

    @GetMapping ("/inventario")
    public String inventario(Model model){
        Iterable<StockEntity> inventario = stockService.getStock();
        model.addAttribute("stock", inventario);
        return "admin/inventario";
    }


}
