package kr.co.erst.mobilelink_front.entities;

import java.io.Serializable;
import java.util.Date;

public class UserEntity implements Serializable {
  private static final long serialVersionUID = -6375567936022237503L;

  private int id; // 순서번호
  private String name; // 이름
  private String login; // 로그인아이디
  private String password; // 비밀번호
  private String phonenumber; // 전화번호
  private int status; // 회원분류 (1. 일반회원, 2. 사업자회원)
  private Date createdDate; // 가입날짜

  public UserEntity() {}
  public UserEntity(String name, String login, String password, String phonenumber, int status) {
    this(0, name, login, password, phonenumber, status, null);
  }
  public UserEntity(int id, String name, String login, String password, String phonenumber, int status, Date createdDate) {
    this.id = id;
    this.name = name;
    this.login = login;
    this.password = password;
    this.phonenumber = phonenumber;
    this.status = status;
    this.createdDate = createdDate;
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

  public String getPhonenumber() {
    return phonenumber;
  }

  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  @Override
  public String toString() {
    return "UserEntity{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", login='" + login + '\'' +
            ", password='" + password + '\'' +
            ", phonenumber='" + phonenumber + '\'' +
            ", status=" + status +
            ", createdDate=" + createdDate +
            '}';
  }
}
