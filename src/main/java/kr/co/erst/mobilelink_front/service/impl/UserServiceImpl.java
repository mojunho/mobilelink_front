package kr.co.erst.mobilelink_front.service.impl;

import kr.co.erst.mobilelink_front.dao.UserDAO;
import kr.co.erst.mobilelink_front.entities.UserEntity;
import kr.co.erst.mobilelink_front.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDAO userDAO;

  public UserEntity selectMember() {
    UserEntity user = userDAO.selectMember();
    return user;
  }
}
