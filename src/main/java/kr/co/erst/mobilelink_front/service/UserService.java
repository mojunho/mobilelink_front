package kr.co.erst.mobilelink_front.service;

import kr.co.erst.mobilelink_front.entities.UserEntity;

import java.util.HashMap;

public interface UserService {

    UserEntity selectForPassword(HashMap<String, Object> map);

}
