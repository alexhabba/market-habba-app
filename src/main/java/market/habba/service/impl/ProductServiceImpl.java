package market.habba.service.impl;

import lombok.RequiredArgsConstructor;
import market.habba.entity.Image;
import market.habba.entity.Product;
import market.habba.mapper.ProductMapper;
import market.habba.model.ProductDto;
import market.habba.repository.ProductRepository;
import market.habba.service.AuthenticationService;
import market.habba.service.CategoryService;
import market.habba.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Override
    @Transactional
    public void addImagesProduct(List<Image> images, String productName) {
        Product product = productRepository.findByNameAndUserId(productName, authenticationService.getUserId()).orElseThrow();
        product.getImages().addAll(images);
        images.forEach(image -> image.setProduct(product));
        productRepository.saveAndFlush(product);
    }

    @Override
    public void addImage(Image image, String productName) {
        Product product = productRepository.findByNameAndUserId(productName, authenticationService.getUserId()).orElseThrow();
        product.getImages().add(image);
        image.setProduct(product);
        productRepository.saveAndFlush(product);
    }
}
