package upeu.edu.pe.lp.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table (name = "productos")
public class ProductEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Getter
    private String code;
    @Getter
    private String name;
    @Getter
    private String description;
    @Getter
    private String image;
    @Getter
    private BigDecimal price;

    @Getter
    private LocalDateTime dataCreated;
    @Getter
    private LocalDateTime dataUpdated;

    @Getter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public ProductEntity() {
        this.setCode(UUID.randomUUID().toString());
    }

    public ProductEntity(Integer id, String code, String name, String description, String image, BigDecimal price, LocalDateTime dataCreated, LocalDateTime dataUpdated, UserEntity userEntity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.dataCreated = dataCreated;
        this.dataUpdated = dataUpdated;
        this.userEntity = userEntity;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDataCreated(LocalDateTime dataCreated) {
        this.dataCreated = dataCreated;
    }

    public void setDataUpdated(LocalDateTime dataUpdated) {
        this.dataUpdated = dataUpdated;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
