package market.habba.service;

import lombok.RequiredArgsConstructor;
import market.habba.entity.Product;
import market.habba.mapper.ProductMapper;
import market.habba.model.ProductDto;
import market.habba.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final AuthenticationService authenticationService;
    private final CategoryService categoryService;
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public ProductDto addProduct(ProductDto dto, String categoryName) {
        Product product = productMapper.toProduct(dto);
        UUID userId = authenticationService.getUserId();
        product.setUserId(userId);
        categoryService.update(categoryName, product);
        Product updateProduct = productRepository.findByNameAndUserId(dto.getName(), userId).orElseThrow();
        return productMapper.toProductDto(updateProduct);
    }
}
