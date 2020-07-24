package kr.co.erst.mobilelink_front.service.impl;

import kr.co.erst.mobilelink_front.dao.UserDAO;
import kr.co.erst.mobilelink_front.entities.UserEntity;
import kr.co.erst.mobilelink_front.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDAO userDAO;

  @Override
  public UserEntity selectForPassword(HashMap<String, Object> map) {
    UserEntity user = userDAO.selectForPassword(map);
    return user;
  }

  @Override
  public UserEntity selectCheckForlogin(String login) {
    UserEntity user = userDAO.selectCheckForlogin(login);
    return user;
  }

}
