package upeu.edu.pe.lp.app.service;

import upeu.edu.pe.lp.app.repository.ProductRepository;
import upeu.edu.pe.lp.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp.infrastructure.entity.UserEntity;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<ProductEntity> getProducts(){
        return productRepository.getProducts();
    }
    public Iterable<ProductEntity> getProductsByUser(UserEntity user){
        return productRepository.getProductsByUser(user);
    }
    public ProductEntity getProductById(Integer id){
        return productRepository.getProductById(id);
    }
    public ProductEntity saveProduct(ProductEntity product){
        return productRepository.saveProduct(product);
    }
    public void deleteProductById(Integer id){
        productRepository.deleteProductById(id);
    }
}
