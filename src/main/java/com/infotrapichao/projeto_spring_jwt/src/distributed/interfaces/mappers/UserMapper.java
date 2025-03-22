package com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.mappers;

import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.security.UserDTO;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.security.User;

import java.util.List;

public class UserMapper {
    public static UserDTO toUserDTO(User user) {
        return new UserDTO(user.getId(), user.getCreatedAt(), user.getUpdatedAt(), user.getUsername(), user.getEmail(), user.getPassword(), user.getRoles());
    }

    public static User toUser(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getCreatedAt(), userDTO.getUpdatedAt(), userDTO.getUsername(), userDTO.getEmail(), userDTO.getPassword(), userDTO.getRoles());
    }

    public static List<UserDTO> toUserDTOList(List<User> users) {
        return users.stream().map(user -> {
                                  UserDTO dto =  UserMapper.toUserDTO(user);
                                  dto.setPassword(null);
                                  return dto;
                              }).toList();
                           }

    public static List<User> toUserList(List<UserDTO> usersDtos) {
        return usersDtos.stream().map(UserMapper::toUser).toList();
    }
}