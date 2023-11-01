package upeu.edu.pe.lp.app.service;

import org.slf4j.*;
import org.springframework.web.multipart.MultipartFile;
import upeu.edu.pe.lp.app.repository.ProductRepository;
import upeu.edu.pe.lp.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp.infrastructure.entity.UserEntity;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;


public class ProductService {
    private final ProductRepository productRepository;
    private final UploadFile uploadFile;
    private Logger LOG = LoggerFactory.getLogger(ProductService.class);

    public ProductService(ProductRepository productRepository, UploadFile uploadFile) {
        this.productRepository = productRepository;
        this.uploadFile = uploadFile;
    }

    public Iterable<ProductEntity> getProducts(){
        return productRepository.getProducts();
    }
    public Iterable<ProductEntity> getProductsByUser(UserEntity user){
        return productRepository.getProductsByUser(user);
    }
    
     public  Optional<ProductEntity> getProductByid(Integer id){
         
         return productRepository.getProductByid(id);
     }

    
    public ProductEntity getProductById(Integer id){
        return productRepository.getProductById(id);
    }
    public ProductEntity saveProductApi(ProductEntity product) throws IOException {
        if (product.getId() == null){
            UserEntity user = new UserEntity();
            user.setId(1);
            product.setDataCreated(LocalDateTime.now());
            product.setDataUpdated(LocalDateTime.now());
            product.setUserEntity(user);
            return productRepository.saveProduct(product);
        }else{
            ProductEntity productDB = productRepository.getProductById(product.getId());

            product.setCode(productDB.getCode());
            product.setUserEntity(productDB.getUserEntity());
            product.setDataCreated(productDB.getDataCreated());
            product.setDataUpdated(LocalDateTime.now());
            return productRepository.saveProduct(product);
        }
    }
    public void deleteProductById(Integer id){
        productRepository.deleteProductById(id);
    }
}
