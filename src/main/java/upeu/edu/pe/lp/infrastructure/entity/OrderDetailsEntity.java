package upeu.edu.pe.lp.infrastructure.entity;

import jakarta.persistence.*;



@Entity
@Table (name = "detallesOrden")
public class OrderDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "products_id")
    private ProductEntity productEntity;

    public OrderDetailsEntity() {
    }

    public OrderDetailsEntity(Integer quantity, OrderEntity orderEntity, ProductEntity productEntity) {
        this.quantity = quantity;
        this.orderEntity = orderEntity;
        this.productEntity = productEntity;
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
