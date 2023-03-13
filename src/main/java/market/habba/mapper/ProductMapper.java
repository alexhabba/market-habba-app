package market.habba.mapper;

import market.habba.entity.Product;
import market.habba.model.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    @Mapping(target = "isActive", expression = "java(true)")
    Product toProduct(ProductDto dto);

    ProductDto toProductDto(Product product);

}
