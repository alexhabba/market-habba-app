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
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Информация о заказе.
 */
@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Order extends IdentifiedEntity {

    /**
     * Сумма заказа.
     */
    private int amount;

    /**
     * Дата создания записи.
     */
    @CreationTimestamp
    private LocalDateTime createDate;

    /**
     * Информация о товарах в заказе.
     */
    @OneToMany(mappedBy = "order")
    private List<Purchase> purchases;

    /**
     * Информация о клиенте.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
