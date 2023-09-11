package upeu.edu.pe.lp.app.service;

import upeu.edu.pe.lp.app.repository.OrderRepository;
import upeu.edu.pe.lp.infrastructure.entity.OrderEntity;

import java.time.LocalDateTime;
import java.util.List;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> findOrdersByOrderDate(LocalDateTime date) {
        return orderRepository.findByDate(date);
    }

    public Long countOrdersByCustomerName(String customerName) {
        return orderRepository.countByCustomerName(customerName);
    }

    public List<OrderEntity> findOrdersByCustomerNameAndOrderStatus(String customerName, String orderStatus) {
        return orderRepository.findByCustomerNameAndOrderStatus(customerName, orderStatus);
    }
}
