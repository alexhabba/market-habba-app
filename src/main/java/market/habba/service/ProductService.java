package market.habba.service;

import market.habba.model.ProductDto;

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
    void addProduct(ProductDto dto, String category);
}
