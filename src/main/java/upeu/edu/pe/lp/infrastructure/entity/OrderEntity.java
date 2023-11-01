package upeu.edu.pe.lp.infrastructure.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table (name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String numero;
    private double total;

    @Column(name = "order_date")
    private LocalDateTime orderDate;
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;


    public OrderEntity() {
    }

    public OrderEntity(Integer id, String numero, double total, LocalDateTime orderDate, double totalAmount, UserEntity userEntity) {
        this.id = id;
        this.numero = numero;
        this.total = total;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.userEntity = userEntity;
    }

   
 
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }



    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
