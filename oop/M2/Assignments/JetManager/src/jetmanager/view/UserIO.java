/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jetmanager.view;

/**
 *
 * @author Alex
 */
public interface UserIO {
    void print(String message);
    String readString(String message);
    int promptUserInt(String message);
    double promptUserDouble(String message);
}
