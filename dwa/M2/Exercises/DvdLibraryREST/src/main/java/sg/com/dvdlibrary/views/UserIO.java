/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibrary.views;

import java.time.LocalDate;

/**
 *
 * @author Randall
 */
public interface UserIO {
    String promptString(String messagge);
    void display(String message);
    int promptInt(String message);
    LocalDate promptDate(String message);
}
