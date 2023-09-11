package upeu.edu.pe.lp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.lp.infrastructure.entity.OrderEntity;


import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository <OrderEntity, Long>{
    //public List<OrderEntity> findByOrderDate(LocalDate orderDate);
    public List<OrderEntity> findByDate(LocalDateTime date);

    //Para contar el numero de ordenes para un cliente en especifico
    Long countByCustomerName(String customerName);

    //Buscar órdenes por un cliente y un estado específico:
    List<OrderEntity> findByCustomerNameAndOrderStatus(String customerName, String orderStatus);

}
