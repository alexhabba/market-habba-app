package market.habba.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import market.habba.entity.base.IdentifiedEntity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

/**
 * Информация о купленном товаре.
 */
@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Purchase extends IdentifiedEntity {

    /**
     * Сумма товара.
     */
    private int amount;

    /**
     * Дата создания записи.
     */
    @CreationTimestamp
    private LocalDateTime createDate;

    /**
     * Информация о продукте.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
