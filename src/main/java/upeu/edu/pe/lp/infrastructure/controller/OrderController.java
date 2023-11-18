package upeu.edu.pe.lp.infrastructure.controller;

import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import upeu.edu.pe.lp.app.domain.ItemCart;
import upeu.edu.pe.lp.app.service.*;
import upeu.edu.pe.lp.infrastructure.entity.OrderDetailsEntity;
import upeu.edu.pe.lp.infrastructure.entity.OrderEntity;
import upeu.edu.pe.lp.infrastructure.entity.StockEntity;
import upeu.edu.pe.lp.infrastructure.entity.UserEntity;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user/order")
public class OrderController {
    private final CartService cartService;
    private final UserService userServices;
    private final OrderService orderService;
    private final ProductService productService;
    private final OrderDetailsService orderProductService;
    private final Integer entradas = 0;
    private final StockService stockService;
    private final ValidateStock validateStock;

    private final Logger log = LoggerFactory.getLogger(OrderController.class);

    public OrderController(CartService cartService, UserService userServices, OrderService orderService, ProductService productService, OrderDetailsService orderProductService, StockService stockService, ValidateStock validateStock) {
        this.cartService = cartService;
        this.userServices = userServices;
        this.orderService = orderService;
        this.productService = productService;
        this.orderProductService = orderProductService;
        this.stockService = stockService;
        this.validateStock = validateStock;
    }

    @GetMapping("/sumary-order")
    public String showSumaryOrder(Model model) {
        UserEntity user = userServices.findById(1);
        model.addAttribute("cart", cartService.getItemCarts());
        model.addAttribute("total", cartService.getTotalCart());
        model.addAttribute("user", user);
        return "user/sumaryorder";

    }

    @GetMapping("/create-order")
    public String createOrder(RedirectAttributes attributes) {
        UserEntity user = userServices.findById(1);
        OrderEntity order = new OrderEntity();
        order.setOrderDate(LocalDateTime.now());
        order.setOrderstatus("Proceso");
        order.setUserEntity(user);
        log.info("order", order);
        //guardar Order
        order = orderService.createOrder(order);

        List<OrderDetailsEntity> orderProduct = new ArrayList<>();
        for (ItemCart itemCart : cartService.getItemCarts()) {
            orderProduct.add(new OrderDetailsEntity(productService.getProductById(itemCart.getIdProduct()),
                    itemCart.getQuantity(),
                    order));
        }

        orderProduct.forEach(
                op -> {
                    orderProductService.create(op);
                    StockEntity stock = new StockEntity();
                    stock.setDescripcion("salida");
                    stock.setEntradas(entradas);
                    stock.setProductEntity(op.getProductEntity());
                    stock.setSalidas(op.getQuantity());
                    stockService.saveStock(validateStock.calculateBalance(stock));
                }
        );

        cartService.removeAllItemCart();
        return "redirect:/home";
    }







}
