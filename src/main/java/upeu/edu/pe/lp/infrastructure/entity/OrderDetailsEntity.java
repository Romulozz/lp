package upeu.edu.pe.lp.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Table (name = "detallesOrden")
public class OrderDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Getter
    private Integer quantity;

    @Getter
    @ManyToOne
    @JoinColumn(name = "orders_id")
    private OrderEntity orderEntity;

    @Getter
    @ManyToOne
    @JoinColumn(name = "products_id")
    private ProductEntity productEntity;

    public OrderDetailsEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
