package upeu.edu.pe.lp.app.service;

import org.slf4j.*;
import org.springframework.web.multipart.MultipartFile;
import upeu.edu.pe.lp.app.repository.ProductRepository;
import upeu.edu.pe.lp.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp.infrastructure.entity.UserEntity;

import java.io.IOException;
import java.time.LocalDateTime;


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
    public ProductEntity getProductById(Integer id){
        return productRepository.getProductById(id);
    }
    public ProductEntity saveProduct(ProductEntity product, MultipartFile multipartFile) throws IOException {
        if (product.getId() == null){
            UserEntity user = new UserEntity();
            user.setId(1);
            product.setDataCreated(LocalDateTime.now());
            product.setDataUpdated(LocalDateTime.now());
            product.setUserEntity(user);
            product.setImage(uploadFile.upload(multipartFile));
            return productRepository.saveProduct(product);
        }else{
            ProductEntity productDB = productRepository.getProductById(product.getId());

            //Actualizar la imagen del producto
            if (multipartFile.isEmpty()){
                product.setImage(productDB.getImage());
            }else {
                if(!productDB.getImage().equals("defaul.jpg")){
                    uploadFile.delete(product.getImage());
                }
                product.setImage(uploadFile.upload(multipartFile));
            }

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
