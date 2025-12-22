package org.example;

import java.util.Arrays;
import java.util.Date;

public class Group {
    private String name;
    private Student[] students;
    private int size;

    public Group(String name) {
        this.name = name;
        this.students = new Student[10];
        this.size = 0;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Student[] getStudents() {
        return students;
    }
    public void addStudent(Student student) {
        if  (size == students.length) {
            return;
        }
        students[size] = student;
        student.setGroupName(name);
        student.setJoiningDate(new Date());
        size++;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", students=" + Arrays.toString(students) +
                ", size=" + size +
                '}';
    }
}
