package upeu.edu.pe.lp.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import upeu.edu.pe.lp.app.repository.ProductRepository;
import upeu.edu.pe.lp.app.service.ProductService;

@Configuration
public class BeanConfiguration {
    @Bean
    public ProductService productService(ProductRepository productRepository){
        return new ProductService(productRepository);
    }
}
