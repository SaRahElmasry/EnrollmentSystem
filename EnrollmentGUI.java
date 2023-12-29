/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaproject1;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author LURA
 */
public class EnrollmentGUI extends JFrame implements ActionListener {
    private EnrollmentSystem enrollmentSystem;
    private JTextField studentNameField;
    private JTextField courseNameField;
    private JTextArea outputArea;

    public EnrollmentGUI() {
        enrollmentSystem = new EnrollmentSystem();

        // Create GUI components
        JLabel studentNameLabel = new JLabel("  Student Name:");
        studentNameField = new JTextField(20);
        JLabel courseNameLabel = new JLabel("   Course Name:");
        courseNameField = new JTextField(20);
        JButton enrollButton = new JButton("Enroll");
        enrollButton.addActionListener(this);
        JButton numberOfStudentsButton = new JButton("Number of Students in Course");
        numberOfStudentsButton.addActionListener(this);
        JButton numberOfCoursesButton = new JButton("Number of Courses for Student");
        numberOfCoursesButton.addActionListener(this);
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(studentNameLabel);
        inputPanel.add(studentNameField);
        inputPanel.add(courseNameLabel);
        inputPanel.add(courseNameField);

        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(enrollButton);
        buttonPanel.add(numberOfStudentsButton);
        buttonPanel.add(numberOfCoursesButton);

        
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Create main panel and add components
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.WEST);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Set frame properties
        setTitle("Student Enrollment System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Enroll")) {
            enrollStudent();
        } else if (e.getActionCommand().equals("Number of Students in Course")) {
            getNumberOfStudentsInCourse();
        } else if (e.getActionCommand().equals("Number of Courses for Student")) {
            getNumberOfCoursesForStudent();
        }
    }

    private void enrollStudent() {
        String studentName = studentNameField.getText().trim();
        String courseName = courseNameField.getText().trim();

        if (!studentName.isEmpty() && !courseName.isEmpty()) {
            enrollmentSystem.enrollStudent(studentName);
            enrollmentSystem.getStudent(studentName).enrollCourse(courseName);
            outputArea.append(" Enrolled student: " + studentName + " in course: " + courseName + "\n");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter both student name and course name.");
        }
        studentNameField.setText("");
        courseNameField.setText("");
    }

    private void getNumberOfStudentsInCourse() {
        String courseName = courseNameField.getText().trim();
        if (!courseName.isEmpty()) {
            int numberOfStudents = enrollmentSystem.getNumberOfStudentsInCourse(courseName);
            outputArea.append(" Number of students enrolled in course " + courseName + ": " + numberOfStudents + "\n");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a course name.");
        }
        courseNameField.setText("");
    }

    private void getNumberOfCoursesForStudent() {
        String studentName = studentNameField.getText().trim();
        if (!studentName.isEmpty()) {
            int numberOfCourses = enrollmentSystem.getNumberOfCoursesForStudent(studentName);
            outputArea.append(" Number of courses for student " + studentName + ": " + numberOfCourses + "\n");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a student name.");
        }
        studentNameField.setText("");
    }
}
