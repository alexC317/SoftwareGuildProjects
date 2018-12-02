/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentquizgrades;

import UserIO.UserIOImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Alex
 */
public class StudentQuizGrades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserIOImpl io = new UserIOImpl();
        HashMap<String, ArrayList<Integer>> students = new HashMap<>();
        int result = 0;

        String name;
        ArrayList<Integer> grades;

        int quit = 0;

        int sum = 0;

        String tempStr;
        int tempNum;
        ArrayList<Integer> tempList = new ArrayList<>();

        io.print("Hello! Welcome to QuizRec Pro, the #1 examination record keeping program.");
        io.print("\n Below are the options available to you.");

        while (result != 6) {
            result = menuDisplay();
            io.print("\n");
            switch (result) {
                case 1:
                    Set<String> names = students.keySet();
                    for (String k : names) {
                        System.out.println(k);
                    }
                    break;
                case 2:
                    grades = new ArrayList<>();
                    quit = 0;
                    name = io.readString("What is the student's name? ");
                    tempNum = io.readInt("What is the first quiz grade? ");
                    grades.add(0, tempNum);
                    while (quit != 1) {
                        tempStr = io.readString("Are there any more grades to input (y/n)? ");
                        if (tempStr.equals("n")) {
                            quit = 1;
                        } else if (tempStr.equals("y")) {
                            tempNum = io.readInt("What is the next quiz grade? ");
                            grades.add(tempNum);
                        }
                    }
                    students.put(name, grades);
                    io.print(name + " added to the system. \n");
                    break;
                case 3:
                    name = io.readString("What is the student's name? ");
                    if (students.containsKey(name)) {
                        students.remove(name);
                        io.print(name + " removed from the system. \n");
                    } else {
                        io.print("No such student in the list. \n");
                    }
                    break;
                case 4:
                    name = io.readString("What is the student's name? ");
                    if (students.containsKey(name)) {
                        tempList = students.get(name);
                        for (int i = 0; i < tempList.size(); i++) {
                            io.print("Quiz " + (i + 1) + ": " + tempList.get(i) + "\n");
                        }
                    } else {
                        io.print("No such student in the list. \n");
                    }
                    break;
                case 5:
                    name = io.readString("What is the student's name? ");
                    if (students.containsKey(name)) {
                        tempList = students.get(name);
                        for (int i = 0; i < tempList.size(); i++) {
                            sum += tempList.get(i);
                        }
                    } else {
                        io.print("No such student in the list. \n");
                    }
                    io.print("Average quiz score: " + (sum / tempList.size()) + "\n");
                    sum = 0;
                    break;
                case 6:
                //Quit the program
            }
        }
    }

    public static int menuDisplay() {
        int choice;
        UserIOImpl io = new UserIOImpl();

        io.print("\n   ==== Menu ====");
        io.print("\n   1. View all students registered with the system.");
        io.print("\n   2. Add a student to the system.");
        io.print("\n   3. Remove a student from the system.");
        io.print("\n   4. View all the quiz scores for a particular student.");
        io.print("\n   5. View the average quiz score for a particular student.");
        io.print("\n   6. Quit the program.");
        io.print("\n   ==============");
        choice = io.readInt("\n Please enter your selection: ");

        return choice;
    }

    /*
    public static void viewAllStudents(HashMap students) {
        Set<String> names = students.keySet();
        for (String k : names) {
            System.out.println(k);
        }
    }*/
 /*
    public static void addStudent(HashMap students) {

    }*/
}
