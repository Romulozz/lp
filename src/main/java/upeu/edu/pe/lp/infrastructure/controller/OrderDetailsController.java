/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.lp.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.lp.app.service.OrderDetailsService;
import upeu.edu.pe.lp.infrastructure.entity.OrderDetailsEntity;

/**
 *
 * @author DIEGO
 */


@RestController
@RequestMapping("/api/v1/orderDetails/")

public class OrderDetailsController {
    private final OrderDetailsService orderDetailsService;

    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }
    
    
    @GetMapping("/show-orderDetails")
    public Iterable <OrderDetailsEntity> showOrderDetails(){
        return orderDetailsService.getOrderDetails();
    }
    
    
    @PostMapping("/save-orderDetails")
    public String saveOrderDetail (@RequestBody OrderDetailsEntity orderDetailsEntity){
        return orderDetailsService.saveOrderDetail(orderDetailsEntity).toString();

    }
   @GetMapping("/show-OrderDetails/{id}")
    public OrderDetailsEntity show(@PathVariable Integer id){
        return orderDetailsService.getOrderDetailById(id);
    }
    
    
    @DeleteMapping("/delete-OrderDetails/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrderDetail(@PathVariable Integer id) {
        orderDetailsService.deleteOrderDetailById(id);
    }
    
    
}
