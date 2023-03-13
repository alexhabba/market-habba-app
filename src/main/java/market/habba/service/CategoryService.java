package market.habba.service;

import market.habba.entity.Product;
import market.habba.model.CategoryDto;

import java.util.List;

/**
 *
 */
public interface CategoryService {

    void save(CategoryDto categoryDto);

    void update(String categoryName, Product product);

    List<CategoryDto> getCategories();
}
