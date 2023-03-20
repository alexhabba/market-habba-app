package market.habba.mapper;

import market.habba.entity.User;
import market.habba.entity.enums.RoleEnum;
import market.habba.model.Role;
import market.habba.model.UserRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User toUser(UserRequestDto userDto);

    List<Role> toRolesDto(List<RoleEnum> roleEnum);

}
