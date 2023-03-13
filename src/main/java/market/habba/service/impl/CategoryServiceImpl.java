package market.habba.service.impl;

import lombok.RequiredArgsConstructor;
import market.habba.entity.Category;
import market.habba.entity.Product;
import market.habba.mapper.CategoryMapper;
import market.habba.model.CategoryDto;
import market.habba.repository.CategoryRepository;
import market.habba.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public void save(CategoryDto categoryDto) {
        Category category = categoryMapper.toCategory(categoryDto);
        categoryRepository.save(category);
    }

    @Override
    public void update(String categoryName, Product product) {
        Category category = categoryRepository.findByName(categoryName).orElseThrow();
        category.getProducts().add(product);
        product.setCategory(category);
        categoryRepository.saveAndFlush(category);
    }

    @Override
    public List<CategoryDto> getCategories() {
        return categoryMapper.toCategoryDtoList(categoryRepository.findAll());
    }

}
