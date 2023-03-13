package market.habba.controller;

import lombok.RequiredArgsConstructor;
import market.habba.api.AdminApi;
import market.habba.model.ProductDto;
import market.habba.service.ImageService;
import market.habba.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class AdminRestController implements AdminApi {

    private final ProductService productService;
    private final ImageService imageService;

    @Override
    public ResponseEntity<Void> addImages(String productName, List<MultipartFile> images) {
        imageService.uploadImages(images, productName);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<ProductDto> addProduct(String categoryName, ProductDto productDto) {
        return ResponseEntity.ok().body(productService.addProduct(productDto, categoryName));
    }

}
