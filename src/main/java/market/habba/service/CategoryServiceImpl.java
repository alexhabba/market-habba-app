package market.habba.service;

import lombok.RequiredArgsConstructor;
import market.habba.entity.Category;
import market.habba.entity.Product;
import market.habba.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public void save(String categoryName) {
        categoryRepository.save(Category.builder()
                .name(categoryName)
                .build());
    }

    @Override
    public void update(String categoryName, Product product) {
        Category category = categoryRepository.findByName(categoryName).orElseThrow();
        category.getProducts().add(product);
        product.setCategory(category);
        categoryRepository.saveAndFlush(category);
    }

}
