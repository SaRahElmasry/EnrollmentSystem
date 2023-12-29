/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaproject1;

/**
 *
 * @author LURA
 */

public class EnrollmentSystem {
    public Student students;

    public EnrollmentSystem() {
        students = null;
    }

    public void enrollStudent(String name) {
        Student newStudent = new Student(name);
        if (students == null) {
            students = newStudent;
        } else {
            Student current = students;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newStudent);
        }
    }
    
    public Student getStudent(String name) {
        Student current = students;
        
        while(current.getName() != name){
           current = current.getNext(); 
        }
        return current;
    }

    
    public int getNumberOfStudentsInCourse(String courseName) {
        int count = 0;
        Student current = students;
        while (current != null) {
            Course courses = current.getCourses();
            while (courses != null) {
                if (courses.getName().equals(courseName)) {
                    count++;
                }
                courses = courses.getNext();
            }
            current = current.getNext();
        }
        return count;
    }
  
    
    public int getNumberOfCoursesForStudent(String studentName) {
        int count = 0;
        Student current = students;
        while (current != null) {
            if (current.getName().equals(studentName)) {
                count += current.getNumberOfCourses();
            }
            current = current.getNext();
        }
        return count;
    }
}
