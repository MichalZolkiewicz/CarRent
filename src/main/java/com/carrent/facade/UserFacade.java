package com.carrent.facade;

import com.carrent.core.User;
import com.carrent.core.UserDto;
import com.carrent.mappers.UserMapper;
import com.carrent.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Long createUser(UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        userRepository.save(user);
        return user.getId();
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
