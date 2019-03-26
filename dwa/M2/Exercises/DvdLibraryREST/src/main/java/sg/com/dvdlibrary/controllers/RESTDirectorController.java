/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibrary.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alex
 */
@RestController
@RequestMapping("/api")

public class RESTDirectorController {
//GET, POST, PUT, DELETE
//create, read, update, delete

    @GetMapping
    public String[] helloWorld() {
        String[] result = {"Hello", "World", "!"};
        return result;
    }
}
