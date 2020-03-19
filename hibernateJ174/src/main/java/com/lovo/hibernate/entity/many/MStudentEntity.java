package com.lovo.hibernate.entity.many;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "m_student")
public class MStudentEntity {
    @Id
    @Column(name = "s_id",length = 32)
    @GenericGenerator(name = "smuuid",strategy = "uuid")
    @GeneratedValue(generator = "smuuid")
    private  String studentId;
    @Column(name = "s_name",length = 48)
    private  String studentName;
    @ManyToMany(mappedBy = "studentsets")
    private Set<MTeacherEntity> teacherSets;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Set<MTeacherEntity> getTeacherSets() {
        return teacherSets;
    }

    public void setTeacherSets(Set<MTeacherEntity> teacherSets) {
        this.teacherSets = teacherSets;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
