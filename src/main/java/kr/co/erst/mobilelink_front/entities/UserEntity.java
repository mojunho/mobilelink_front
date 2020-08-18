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
  private int telecom; // 회원 통신사
  private Date createdDate; // 가입날짜
  private Date updatedDate; // 갱신날짜
  private int status; // 회원 상태

  public UserEntity() {}
  public UserEntity(String name, String login, String password, String phonenumber, int telecom) {
    this(0, name, login, password, phonenumber, telecom, null, null, 1);
  }

  public UserEntity(int id, String name, String login, String password, String phonenumber, int telecom, Date createdDate, Date updatedDate, int status) {
    this.id = id;
    this.name = name;
    this.login = login;
    this.password = password;
    this.phonenumber = phonenumber;
    this.telecom = telecom;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
    this.status = status;
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

  public int getTelecom() {
    return telecom;
  }

  public void setTelecom(int telecom) {
    this.telecom = telecom;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public Date getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(Date updatedDate) {
    this.updatedDate = updatedDate;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "UserEntity{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", login='" + login + '\'' +
            ", password='" + password + '\'' +
            ", phonenumber='" + phonenumber + '\'' +
            ", telecom=" + telecom +
            ", createdDate=" + createdDate +
            ", updatedDate=" + updatedDate +
            ", status=" + status +
            '}';
  }

}
