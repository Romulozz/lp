/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.lp.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.lp.app.service.ProductService;
import upeu.edu.pe.lp.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp.infrastructure.entity.UserEntity;

/**
 *
 * @author Luki
 */
public class ProductoControllerApi {
    
@RestController
@RequestMapping("/admin/product/")
public class ProductControllerApi {
    
   private final ProductService productService;

    public ProductControllerApi(ProductService productService) {
        this.productService = productService;
    }
    //crear product
    @PostMapping("/save-product")
    public String saveProduct(@RequestBody ProductEntity productEntity){
       // return productService.saveProduct(productEntity).toString();
       return null;
    }
     //ver productos
    @GetMapping("/show")
    public Iterable <ProductEntity> showProduct(){
        UserEntity user = new UserEntity();
        user.setId(1);
        return productService.getProductsByUser(user);
    }
    //buscar producto por Id
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
       // return productService.saveProduct(productActual);
       return null;
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
    
}
