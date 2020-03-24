package com.lovo.jpa.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity  //被Hibernate管理的标记
@Table(name ="sys_user" ) //映射表
public class UserEntity {
    @Id
    //自定义UUID
    @GenericGenerator(name = "uuuid",strategy = "uuid")
    //给id一个生产策略,自定义生成策略
    @GeneratedValue(generator = "uuuid")
    @Column(name = "u_id",length = 32)
    private  String userId;
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


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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
