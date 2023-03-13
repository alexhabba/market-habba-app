package market.habba.service;

import market.habba.entity.Category;
import market.habba.entity.Product;
import market.habba.model.CategoryDto;

/**
 *
 */
public interface CategoryService {

    void save(CategoryDto categoryDto);

    void update(String categoryName, Product product);

}
