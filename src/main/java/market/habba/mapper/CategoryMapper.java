package market.habba.mapper;

import market.habba.entity.Category;
import market.habba.model.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    Category toCategory(CategoryDto dto);

    List<CategoryDto> toCategoryDtoList(List<Category> categories);
}
