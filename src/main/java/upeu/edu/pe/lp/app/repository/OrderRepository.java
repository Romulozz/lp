package upeu.edu.pe.lp.app.repository;

import upeu.edu.pe.lp.infrastructure.entity.OrderEntity;
import upeu.edu.pe.lp.infrastructure.entity.UserEntity;


public interface OrderRepository {
    Iterable<OrderEntity> getOrders();
    Iterable<OrderEntity> getOrdersByUser(UserEntity user);
    OrderEntity getOrderById(Integer id);
    OrderEntity saveOrder(OrderEntity order);
    void deleteProductById(Integer id);
}
