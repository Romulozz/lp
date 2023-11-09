package upeu.edu.pe.lp.app.service;

import upeu.edu.pe.lp.app.repository.StockRepository;
import upeu.edu.pe.lp.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp.infrastructure.entity.StockEntity;

import java.util.List;

public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Iterable<StockEntity> getStock(){
        return stockRepository.getStock();
    }
    public StockEntity getStockByid(Integer id){
        return stockRepository.getStockByid(id);
    }

    public List<StockEntity> getStockByProductEntity(ProductEntity productEntity){
        return stockRepository.getStockByProductEntity(productEntity);
    }
    public StockEntity saveStock(StockEntity stockEntity) {
        return stockRepository.saveStock(stockEntity);
    }

}
