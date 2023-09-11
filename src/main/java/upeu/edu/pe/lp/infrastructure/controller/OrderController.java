package upeu.edu.pe.lp.infrastructure.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.lp.app.service.OrderService;
import upeu.edu.pe.lp.infrastructure.entity.OrderEntity;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/date/{orderDate}")
    public ResponseEntity<List<OrderEntity>> findOrdersByOrderDate(@PathVariable LocalDateTime date) {
        List<OrderEntity> orders = orderService.findOrdersByOrderDate(date);
        if (orders.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(orders);
        }
    }

    @GetMapping("/count/{id}")
    public ResponseEntity<Long> countOrdersByCustomerName(@PathVariable String customerName) {
        Long count = orderService.countOrdersByCustomerName(customerName);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/customer/{customerName}/status/{orderStatus}")
    public ResponseEntity<List<OrderEntity>> findOrdersByCustomerNameAndOrderStatus(
            @PathVariable String customerName,
            @PathVariable String orderStatus) {
        List<OrderEntity> orders = orderService.findOrdersByCustomerNameAndOrderStatus(customerName, orderStatus);
        if (orders.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(orders);
        }
    }


}
