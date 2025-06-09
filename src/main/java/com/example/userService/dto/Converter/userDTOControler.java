package com.example.userService.dto.Converter;

import com.example.userService.dto.userDto;
import com.example.userService.model.AppUser;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class userDTOControler {
    private final ModelMapper modelMapper;
    public userDto convertToDto(AppUser user){
        return modelMapper.map(user,userDto.class);
    }
}
