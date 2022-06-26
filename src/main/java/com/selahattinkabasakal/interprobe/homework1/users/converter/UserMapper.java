package com.selahattinkabasakal.interprobe.homework1.users.converter;

import com.selahattinkabasakal.interprobe.homework1.users.dto.UserResponseDto;
import com.selahattinkabasakal.interprobe.homework1.users.dto.UserSaveRequestDto;
import com.selahattinkabasakal.interprobe.homework1.users.dto.UserUpdateRequestDto;
import com.selahattinkabasakal.interprobe.homework1.users.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserResponseDto convertToUserResponseDto(Users user);
    Users convertToUser(UserUpdateRequestDto userUpdateRequestDto);
    Users convertToUser(UserSaveRequestDto userSaveRequestDto);

    List<UserResponseDto> convertToUserDtoList(List<Users> usersList);
}
