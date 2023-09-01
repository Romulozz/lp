package upeu.edu.pe.lp.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.lp.app.service.ProductService;
import upeu.edu.pe.lp.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp.infrastructure.entity.UserEntity;


@Controller
@RequestMapping("/api/v1/product/")
public class ProductoControllerApi {

    private final ProductService productService;

    public ProductoControllerApi(ProductService productService) {
        this.productService = productService;
    }

    //crear productos
    @PostMapping("/save-product")
    public String saveProduct (@RequestBody ProductEntity productEntity){
        return productService.saveProduct(productEntity).toString();
    }

    //ver productos
    @GetMapping("/show")
    public Iterable <ProductEntity> showProduct(){
        UserEntity user = new UserEntity();
        user.setId(1);
        return productService.getProductsByUser(user);
    }

    //buscar producto por id
    @GetMapping("/show/{id}")
    public ProductEntity show(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    //editar un product
    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity editProduct(@RequestBody ProductEntity product, @PathVariable Integer id) {
        ProductEntity productActual = productService.getProductById(id);
        productActual.setDescription(product.getDescription());
        productActual.setName(product.getName());
        productActual.setPrice(product.getPrice());
        productActual.setUserEntity(product.getUserEntity());
        return productService.saveProduct(productActual);
        // log.info("Product obtenido: {}", product);
        //model.addAttribute("product", product);
        //return "admin/products/edit";
    }

    //eliminar un product
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProductById(id);
        // return "redirect:/admin/products/show";
    }
}
