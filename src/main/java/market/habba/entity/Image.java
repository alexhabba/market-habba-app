package market.habba.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import market.habba.entity.base.IdentifiedEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 * Изображение товара
 */
@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Image extends IdentifiedEntity {

    /**
     *
     */
    private String name;

    /**
     *
     */
    boolean isMain;

//    @Lob

    private byte[] data;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
