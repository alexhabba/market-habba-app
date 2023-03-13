package market.habba.controller;

import lombok.RequiredArgsConstructor;
import market.habba.api.AdminApi;
import market.habba.model.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class AdminApiController implements AdminApi {

    @Override
    public ResponseEntity<Void> addImages(String productName, List<MultipartFile> images) {
        System.out.println("все классно");
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> addProduct(ProductDto productDto) {
        return ResponseEntity.ok().build();
    }
}
