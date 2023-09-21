/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.lp.infrastructure.adapter;
import org.springframework.stereotype.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import upeu.edu.pe.lp.app.repository.OrderDetailsRepository;
import upeu.edu.pe.lp.infrastructure.entity.OrderDetailsEntity;

/**
 *
 * @author DIEGO
 */
@Repository
public class OrderDetailsRepositoryImpl implements OrderDetailsRepository {
     private final OrderDetailsRepository orderDetailsRepository;

    @Autowired
      public OrderDetailsRepositoryImpl(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

      
    @Override
    public Iterable<OrderDetailsEntity> getAllOrderDetails() {
        return orderDetailsRepository.getAllOrderDetails();
    }

    @Override
    public Iterable<OrderDetailsEntity> getOrderDetailsByOrder(OrderDetailsEntity orderDetails) {
        
        return orderDetailsRepository.getOrderDetailsByOrder(orderDetails);
    }

    @Override
    public OrderDetailsEntity getOrderDetailsById(Integer id) {
        
        return orderDetailsRepository.getOrderDetailsById(id);
    }

    @Override
    public OrderDetailsEntity saveOrderDetails(OrderDetailsEntity orderDetails) {
        
    return orderDetailsRepository.saveOrderDetails(orderDetails);
 
    }

    @Override
    public void deleteOrderDetailsById(Integer id) {
     
    orderDetailsRepository.deleteOrderDetailsById(id);

    }
    
}
