package upeu.edu.pe.lp.app.service;


import upeu.edu.pe.lp.app.repository.OrderRepository;
import upeu.edu.pe.lp.infrastructure.entity.OrderEntity;
import upeu.edu.pe.lp.infrastructure.entity.UserEntity;



public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Iterable<OrderEntity> getOrders(){
        return orderRepository.getOrders();
    }
    public Iterable<OrderEntity> getOrdersByUser(UserEntity user){
        return orderRepository.getOrdersByUser(user);
    }
    public OrderEntity getOrderById(Integer id){
        return orderRepository.getOrderById(id);
    }
    public OrderEntity saveOrder(OrderEntity order) {
        return orderRepository.saveOrder(order);
    }
    public void deleteOrderById(Integer id){
        orderRepository.deleteProductById(id);
    }
}
