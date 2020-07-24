package kr.co.erst.mobilelink_front.dao;

import kr.co.erst.mobilelink_front.entities.UserEntity;

import java.util.HashMap;

public interface UserDAO {

    UserEntity selectForPassword(HashMap<String, Object> map);

    UserEntity selectCheckForlogin(String login);

}
