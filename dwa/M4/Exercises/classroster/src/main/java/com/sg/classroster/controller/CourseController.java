/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.controller;

import com.sg.classroster.dao.CourseDAO;
import com.sg.classroster.dao.StudentDAO;
import com.sg.classroster.dao.TeacherDAO;
import com.sg.classroster.entities.Course;
import com.sg.classroster.entities.Student;
import com.sg.classroster.entities.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Alex
 */
@Controller
public class CourseController {

    @Autowired
    TeacherDAO teacherDAO;

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    CourseDAO courseDAO;

    @GetMapping("courses")
    public String displayCourses(Model model) {
        List<Course> courses = courseDAO.getAllCourses();
        List<Teacher> teachers = teacherDAO.getAllTeachers();
        List<Student> students = studentDAO.getAllStudents();
        model.addAttribute("courses", courses);
        model.addAttribute("teachers", teachers);
        model.addAttribute("students", students);
        return "courses";
    }

    @PostMapping("addCourse")
    public String addCourse(Course course, HttpServletRequest request) {
        String teacherId = request.getParameter("teacherId");
        String[] studentIds = request.getParameterValues("studentId");

        course.setTeacher(teacherDAO.getTeacherById(Integer.parseInt(teacherId)));

        List<Student> students = new ArrayList<>();
        for (String studentId : studentIds) {
            students.add(studentDAO.getStudentById(Integer.parseInt(studentId)));
        }
        course.setStudents(students);
        courseDAO.addCourse(course);

        return "redirect:/courses";
    }

    @GetMapping("courseDetail")
    public String courseDetail(Integer id, Model model) {
        Course course = courseDAO.getCourseById(id);
        model.addAttribute("course", course);
        return "courseDetail";
    }

    @GetMapping("deleteCourse")
    public String deleteCourse(Integer id) {
        courseDAO.deleteCourseById(id);
        return "redirect:/courses";
    }

    @GetMapping("editCourse")
    public String editCourse(Integer id, Model model) {
        Course course = courseDAO.getCourseById(id);
        List<Student> students = studentDAO.getAllStudents();
        List<Teacher> teachers = teacherDAO.getAllTeachers();
        model.addAttribute("course", course);
        model.addAttribute("students", students);
        model.addAttribute("teachers", teachers);
        return "editCourse";
    }

    @PostMapping("editCourse")
    public String performEditCourse(Course course, HttpServletRequest request) {
        String teacherId = request.getParameter("teacherId");
        String[] studentIds = request.getParameterValues("studentId");

        course.setTeacher(teacherDAO.getTeacherById(Integer.parseInt(teacherId)));

        List<Student> students = new ArrayList<>();
        for (String studentId : studentIds) {
            students.add(studentDAO.getStudentById(Integer.parseInt(studentId)));
        }
        course.setStudents(students);
        courseDAO.updateCourse(course);

        return "redirect:/courses";
    }
}
