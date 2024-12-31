package com.hermes.hermes.mapper;

import com.hermes.hermes.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void insertUser(User user);
    String getImage(int productId);
    User login(String user_id, String user_pw);
}
