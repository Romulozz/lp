package upeu.edu.pe.lp.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.lp.app.service.ProductService;
import upeu.edu.pe.lp.app.service.StockService;
import upeu.edu.pe.lp.infrastructure.entity.StockEntity;

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
        return "home_admin";
    }

    @GetMapping ("/inventario")
    public String inventario(Model model){
        Iterable<StockEntity> inventario = stockService.getStock();
        model.addAttribute("stock", inventario);
        return "admin/inventario";
    }


}
