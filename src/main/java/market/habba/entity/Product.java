package market.habba.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import market.habba.entity.base.IdentifiedEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Информация о продукте.
 */
@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Product extends IdentifiedEntity {

    /**
     * Название товара.
     */
    private String name;

    /**
     * Цена товара.
     */
    private int price;

    /**
     * Краткое описание товара.
     */
    private String description;

    /**
     * Полное описание товара.
     */
    private String fullDescription;

    /**
     * true - имеется в продаже, false - не продается.
     */
    private boolean isActive;

    /**
     * Дата создания записи.
     */
    @CreationTimestamp
    private LocalDateTime createDate;

    /**
     * Дата обновления записи.
     */
    @UpdateTimestamp
    private LocalDateTime updateDate;

//    /**
//     * Продавец товара.
//     */
//    private Owner owner;

    /**
     * Изображения товара.
     */
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images;

    /**
     * Категория товара.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
}
