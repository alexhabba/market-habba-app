package market.habba.controller;

import lombok.RequiredArgsConstructor;
import market.habba.api.ProductApi;
import market.habba.model.ProductDto;
import market.habba.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class ProductRestController implements ProductApi {

    private final ProductService productService;

    @Override
    public ResponseEntity<List<ProductDto>> getProducts() {
        return ResponseEntity.ok(productService.getProdacts());
    }
}
