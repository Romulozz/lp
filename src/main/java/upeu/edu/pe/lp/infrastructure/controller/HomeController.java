package upeu.edu.pe.lp.infrastructure.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.lp.app.service.ProductService;
import upeu.edu.pe.lp.infrastructure.entity.ProductEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import upeu.edu.pe.lp.infrastructure.entity.OrderDetailsEntity;
import upeu.edu.pe.lp.infrastructure.entity.OrderEntity;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final Logger log = LoggerFactory.getLogger(HomeController.class);
    private final ProductService productService;
    //.Almacenar los detalles de la orden
    List<OrderDetailsEntity> detalles = new ArrayList<OrderDetailsEntity>();
    
    //Datos de la orden
    OrderEntity orden = new OrderEntity();
    
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
    
     @PostMapping("/cart")
    public String addCart(@RequestParam Integer id, @RequestParam Integer cantidad, Model model){
        
        OrderDetailsEntity detalleOrden = new OrderDetailsEntity();
        ProductEntity producto = new ProductEntity();
        double sumaTotal = 0;
        
        Optional<ProductEntity> optionalProducto = productService.getProductByid(id);
        producto = optionalProducto.get();
        detalleOrden.setCantidad(cantidad);
        detalleOrden.setPrecio(producto.getPrice());
        detalleOrden.setNombre(producto.getName());
        detalleOrden.setTotal(producto.getPrice()* cantidad);
        detalleOrden.setProductEntity(producto);

        detalles.add(detalleOrden);
        sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

        orden.setTotal(sumaTotal);
        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden );
        
               
        return"user/carrito";
    }
    
    
    
    


}
