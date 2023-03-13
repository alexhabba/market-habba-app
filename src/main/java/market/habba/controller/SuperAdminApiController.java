package market.habba.controller;

import lombok.RequiredArgsConstructor;
import market.habba.api.SuperAdminApi;
import market.habba.model.CategoryDto;
import market.habba.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class SuperAdminApiController implements SuperAdminApi {

    private final CategoryService categoryService;

    @Override
    public ResponseEntity<Void> addCategory(CategoryDto categoryDto) {
        categoryService.save(categoryDto);
        return ResponseEntity.ok().build();
    }
}
