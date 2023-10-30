package upeu.edu.pe.lp.infrastructure.entity;

import jakarta.persistence.*;



@Entity
@Table (name = "detallesOrden")
public class OrderDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String nombre;
    private double cantidad;
    private double precio;
    private double total;
   

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "products_id")
    private ProductEntity productEntity;

    public OrderDetailsEntity() {
    }

    public OrderDetailsEntity(Integer id, String nombre, double cantidad, double precio, double total, OrderEntity orderEntity, ProductEntity productEntity) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.orderEntity = orderEntity;
        this.productEntity = productEntity;
    }
    



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
