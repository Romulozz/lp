package upeu.edu.pe.lp.app.repository;

import upeu.edu.pe.lp.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp.infrastructure.entity.StockEntity;

import java.util.List;
import java.util.Optional;


public interface StockRepository {

    Iterable<StockEntity> getStock();
    StockEntity getStockByid(Integer id);
    StockEntity saveStock(StockEntity stockEntity);
    List<StockEntity> getStockByProductEntity(ProductEntity productEntity);
}
