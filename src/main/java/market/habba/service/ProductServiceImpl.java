package market.habba.service;

import lombok.RequiredArgsConstructor;
import market.habba.entity.Product;
import market.habba.mapper.ProductMapper;
import market.habba.model.ProductDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final AuthenticationService authenticationService;
    private final CategoryService categoryService;
    private final ProductMapper productMapper;

    @Override
    @Transactional
    public void addProduct(ProductDto dto, String categoryName) {
        Product product = productMapper.toProduct(dto);
        product.setUserId(authenticationService.getUserId());
        categoryService.update(categoryName, product);
    }
}
