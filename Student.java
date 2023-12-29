/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaproject1;

/**
 *
 * @author LURA
 */
public class Student {
    private String name;
    private Course courses;
    private Student next;

    public Student(String name) {
        this.name = name;
        this.courses = null;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public Course getCourses() {
        return courses;
    }

    public Student getNext() {
        return next;
    }

    public void setNext(Student next) {
        this.next = next;
    }

    public void enrollCourse(String courseName) {
        Course newCourse = new Course(courseName);
        if (courses == null) {
            courses = newCourse;
        } else {
            Course current = courses;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newCourse);
        }
    }

    public int getNumberOfCourses() {
        int count = 0;
        Course current = courses;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }
    
}
