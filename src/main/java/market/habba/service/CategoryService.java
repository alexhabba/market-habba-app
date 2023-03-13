package market.habba.service;

import market.habba.entity.Category;
import market.habba.entity.Product;

/**
 *
 */
public interface CategoryService {

    void save(String categoryName);

    void update(String categoryName, Product product);

}
