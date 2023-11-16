package upeu.edu.pe.lp.app.repository;

import upeu.edu.pe.lp.infrastructure.entity.OrderEntity;
import upeu.edu.pe.lp.infrastructure.entity.UserEntity;


public interface OrderRepository {
    public Iterable<OrderEntity> getOrders();
    public Iterable<OrderEntity> getOrdersByUser(UserEntity user);
    public OrderEntity saveOrder(OrderEntity order);
}
