package market.habba.service;

import market.habba.entity.Image;
import market.habba.model.ProductDto;

import java.util.List;

/**
 * Сервисная логика связанная с продуктом.
 */
public interface ProductService {

    /**
     * Добавление нового продукта в БД.
     *
     * @param dto      Дто продукта
     * @param category Категория продукта
     */
    ProductDto addProduct(ProductDto dto, String category);

    void addImagesProduct(List<Image> images, String productName);

    void addImage(Image image, String productName);

}
