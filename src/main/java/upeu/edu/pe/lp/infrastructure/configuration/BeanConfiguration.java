package upeu.edu.pe.lp.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import upeu.edu.pe.lp.app.repository.ProductRepository;
import upeu.edu.pe.lp.app.repository.StockRepository;
import upeu.edu.pe.lp.app.service.ProductService;
import upeu.edu.pe.lp.app.service.StockService;
import upeu.edu.pe.lp.app.service.UploadFile;

@Configuration
public class BeanConfiguration {
    @Bean
    public ProductService productService(ProductRepository productRepository, UploadFile uploadFile){
        return new ProductService(productRepository, uploadFile);
    }

    @Bean
    public StockService stockService (StockRepository stockRepository){
        return new StockService(stockRepository);
    }

    @Bean
    public UploadFile uploadFile(){
        return new UploadFile();
    }
}
