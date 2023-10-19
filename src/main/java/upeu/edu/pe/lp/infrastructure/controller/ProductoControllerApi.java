package upeu.edu.pe.lp.infrastructure.controller;

import java.io.IOException;
import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import upeu.edu.pe.lp.app.service.ProductService;
import upeu.edu.pe.lp.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp.infrastructure.entity.UserEntity;


@CrossOrigin(origins = "http://localhost/4200")
@Controller
@RequestMapping("/api")
public class ProductoControllerApi {

    private final ProductService productService;
    private final Logger log = LoggerFactory.getLogger(ProductoControllerApi.class);

    public ProductoControllerApi(ProductService productService) {
        this.productService = productService;
    }

    //crear nuevo producto
    @GetMapping("/product")
    public String create(){
        return "admin/products/create";
    }
    //guardar producto
    @PostMapping("/product")
    public String saveProduct(ProductEntity product, @RequestParam("img") MultipartFile multipartFile) throws IOException {
        log.info("Nombre de producto: {}", product);
        productService.savProduct(product, multipartFile);

        // Agregar un retraso de 1 segundo (1000 milisegundos) antes de redirigir
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "redirect:/admin";
    }


    @GetMapping("/product")
    public String showProduct(Model model){
        //log.info("id user desde la variable de session: {}");
        UserEntity user = new UserEntity();
        user.setId(1);
        Iterable<ProductEntity> products = productService.getProductsByUser(user);
        model.addAttribute("products", products);
        return "admin/products/show";
    }


    @GetMapping("/product/{id}")
    public String editProduct(@PathVariable Integer id, Model model){
        ProductEntity product = productService.getProductById(id);
        log.info("Product obtenido: {}", product);
        model.addAttribute("product",product);
        return "admin/products/edit";
    }

    @GetMapping("/product/{id}")
    public String deleteProduct(@PathVariable Integer id){
        productService.deleteProductById(id);
        return "redirect:/admin";
    }

}