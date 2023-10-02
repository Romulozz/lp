/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.lp.app.service;

import upeu.edu.pe.lp.app.repository.OrderDetailsRepository;
import upeu.edu.pe.lp.infrastructure.entity.OrderDetailsEntity;

/**
 *
 * @author DIEGO
 */
public class OrderDetailsService {
    
    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    public Iterable<OrderDetailsEntity> getOrderDetails(){
         
        return orderDetailsRepository.getOrderDetails();
    }
    public OrderDetailsEntity saveOrderDetail(OrderDetailsEntity orderDetails){
    
        return orderDetailsRepository.saveOrderDetail(orderDetails);
    }
    public void deleteOrderDetailById(Integer id){
        
        orderDetailsRepository.deleteOrderDetailById(id);
    }
    
    public OrderDetailsEntity getOrderDetailById(Integer id){
        return orderDetailsRepository.getOrderDetailById(id);
    }

    
}
