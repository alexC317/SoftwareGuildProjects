/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.springbootrestservice.data;

import com.swcguild.springbootrestservice.models.ToDo;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface ToDoDAO {

    ToDo add(ToDo todo);

    List<ToDo> getAll();

    ToDo findById(int id);

    //true if item exists and is updated
    boolean update(ToDo todo);

    //true if item exists and is updated
    boolean delete(int id);
}
