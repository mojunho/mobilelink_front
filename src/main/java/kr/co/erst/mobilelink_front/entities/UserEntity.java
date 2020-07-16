package kr.co.erst.mobilelink_front.entities;

import java.io.Serializable;

public class UserEntity implements Serializable {
  private static final long serialVersionUID = -6375567936022237503L;

  private int id;
  private String name;
  private String login;
  private String password;

  public UserEntity() {}
  public UserEntity(String name, String login, String password) {
    this(0, name, login, password);
  }
  public UserEntity(int id, String name, String login, String password) {
    this.id = id;
    this.name = name;
    this.login = login;
    this.password = password;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "UserEntity{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", login='" + login + '\'' +
            ", password='" + password + '\'' +
            '}';
  }

}
