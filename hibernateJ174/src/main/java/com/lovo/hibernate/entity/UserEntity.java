package com.lovo.hibernate.entity;

import javax.persistence.*;

@Entity  //被Hibernate管理的标记
@Table(name ="sys_user" ) //映射表
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int userId;
    @Column(name="u_name",length = 48,nullable = false,unique =true )
    private String userName;
   // @Column(insertable = false)
   // @Transient  //暂态
    private  String password;
    private  int age;
    @Column(columnDefinition = "TIMESTAMP")
    private  String addDate;
    @Column(columnDefinition = "TEXT")
    private  String  info;




    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
