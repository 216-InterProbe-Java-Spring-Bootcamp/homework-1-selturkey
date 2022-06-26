package com.selahattinkabasakal.interprobe.homework1.users.service;



import com.selahattinkabasakal.interprobe.homework1.generic.exceptions.RecordNotFoundException;
import com.selahattinkabasakal.interprobe.homework1.users.converter.UserMapper;
import com.selahattinkabasakal.interprobe.homework1.users.dto.UserResponseDto;
import com.selahattinkabasakal.interprobe.homework1.users.dto.UserSaveRequestDto;
import com.selahattinkabasakal.interprobe.homework1.users.dto.UserUpdateRequestDto;
import com.selahattinkabasakal.interprobe.homework1.users.entity.Users;
import com.selahattinkabasakal.interprobe.homework1.users.service.entityservice.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */
@Service
@RequiredArgsConstructor
public class UsersService {

    private final UserEntityService userEntityService;

    public List<UserResponseDto> findAll(){

        List<Users> userList = userEntityService.findAll();
        return UserMapper.INSTANCE.convertToUserDtoList(userList);
    }

    public UserResponseDto findById(Long id){

        Users user = userEntityService.findById(id).orElseThrow(()-> new RecordNotFoundException("User Not find Id: "+ id));
        return UserMapper.INSTANCE.convertToUserResponseDto(user);
    }

    public UserResponseDto save(UserSaveRequestDto userSaveRequestDto){

        Users user = UserMapper.INSTANCE.convertToUser(userSaveRequestDto);
        user = userEntityService.save(user);

        return UserMapper.INSTANCE.convertToUserResponseDto(user);
    }

    public void delete(Long id){ userEntityService.delete(id);}

    public void delete(Users user){ userEntityService.delete(user); }
    public UserResponseDto update(UserUpdateRequestDto userUpdateRequestDto) {

        boolean isExist = userEntityService.isExist(userUpdateRequestDto.getId());

        if (!isExist){ throw new RecordNotFoundException("No Record Find to Update Id: "+ userUpdateRequestDto.getId());}

        Users user = UserMapper.INSTANCE.convertToUser(userUpdateRequestDto);

        user = userEntityService.save(user);

        return UserMapper.INSTANCE.convertToUserResponseDto(user);
    }

}
