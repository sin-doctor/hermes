package com.hermes.hermes.service;
import com.hermes.hermes.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hermes.hermes.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User loginUser(String user_id, String user_pw) {
        User user = userMapper.login(user_id, user_pw);
        if (user != null && isPasswordValid(user_pw, user.getUser_pw())) {
            return user;
        }
        return null;
    }
    private boolean isPasswordValid(String inputPassword, String storedPassword) {
        return inputPassword.equals(storedPassword);
    }

    @Override
    public void insertUser(User user){
        userMapper.insertUser(user);
    }

    @Override
    public String getImage(int productId) {
        return userMapper.getImage(productId);
    }
}