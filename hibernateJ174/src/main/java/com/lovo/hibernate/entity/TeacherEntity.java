package com.lovo.hibernate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sys_teacher")
public class TeacherEntity {
    @Id
    @Column(name = "t_id",length = 32)
    @GenericGenerator(name = "tuuid",strategy = "uuid")
    @GeneratedValue(generator = "tuuid")
    private  String teacherId;
    @Column(name = "t_name",length = 48)
    private  String teacherName;
    @Column(name = "t_class",length = 48)
    private String teacherClass;
    //mappedBy 把映射权利交给多的一方mappedBy = "多的一方，持有的一的引用"
    @OneToMany(mappedBy = "teacher",fetch = FetchType.EAGER)
    private Set<StudentEntity> setStus;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherClass() {
        return teacherClass;
    }

    public void setTeacherClass(String teacherClass) {
        this.teacherClass = teacherClass;
    }

    public Set<StudentEntity> getSetStus() {
        return setStus;
    }

    public void setSetStus(Set<StudentEntity> setStus) {
        this.setStus = setStus;
    }
}
