/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.lp.app.repository;

import upeu.edu.pe.lp.infrastructure.entity.OrderDetailsEntity;

/**
 *
 * @author DIEGO
 */
public interface OrderDetailsRepository {
  Iterable<OrderDetailsEntity> getAllOrderDetails();
  Iterable<OrderDetailsEntity> getOrderDetailsByOrder(OrderDetailsEntity orderDetails);
  OrderDetailsEntity getOrderDetailsById(Integer id);
  OrderDetailsEntity saveOrderDetails(OrderDetailsEntity orderDetails);
  void deleteOrderDetailsById(Integer id);    
}



