package org.example;

import java.util.Date;

public class Student {
    private Person person;
    private int id;
    private String groupName;
    private Date joiningDate;

    public Student(Person person, int id) {
        this.person = person;
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public int getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "person=" + person +
                ", id=" + id +
                ", groupName='" + groupName + '\'' +
                ", joiningDate=" + joiningDate +
                '}';
    }
}