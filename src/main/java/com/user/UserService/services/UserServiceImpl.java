package com.user.UserService.services;

import com.user.UserService.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    //fake List
    List<User>list=List.of(
            new User(1311L,"Sanket","862386328"),
            new User(1312L,"Govind","862386328"),
            new User(1313L,"Suraj","862386328")
    );

    @Override
    public User getUser(Long userId) {
        return this.list.stream().filter(user -> user.getUserId().equals(userId)).findAny().orElse(null);
    }
}
