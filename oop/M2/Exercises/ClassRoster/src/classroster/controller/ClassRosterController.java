package classroster.controller;

import classroster.dao.ClassRosterDao;
import classroster.dto.Student;
import classroster.ui.ClassRosterView;
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

    ClassRosterView view;
    ClassRosterDao dao;

    public void run() {
        boolean keepGoing = true;
        int menuSelection;
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
                    removeStudent();
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
    }

    public ClassRosterController(ClassRosterDao dao, ClassRosterView view) {
        this.dao = dao;
        this.view = view;
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

    private void viewStudent() {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
    }

    private void removeStudent() {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        dao.removeStudent(studentId);
        view.displayRemoveSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
