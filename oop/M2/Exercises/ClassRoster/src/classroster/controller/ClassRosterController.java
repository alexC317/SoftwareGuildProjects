package classroster.controller;

import classroster.dao.ClassRosterDao;
import classroster.dao.ClassRosterDaoFileImpl;
import classroster.dto.Student;
import classroster.ui.ClassRosterView;
import classroster.ui.UserIO;
import classroster.ui.UserIOConsoleImpl;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alex
 */
public class ClassRosterController {
    
    ClassRosterView view = new ClassRosterView();
    ClassRosterDao dao = new ClassRosterDaoFileImpl();
    private UserIO io = new UserIOConsoleImpl();
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            
            menuSelection = getMenuSelection();
            
            switch (menuSelection) {
                case 1:
                    listStudents();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    viewStudent();
                    break;
                case 4:
                    io.print("REMOVE STUDENT");
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }
        }
        io.print("GOOD BYE");
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createStudent() {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentinfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }
    
    private void listStudents() {
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayCurrentStudentList(studentList);
    }
    
    private void viewStudent(){
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
    }
}
