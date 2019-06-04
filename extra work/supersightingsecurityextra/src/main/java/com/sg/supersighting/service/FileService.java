/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Alex
 */
public interface FileService {

    //Create
    public void create(String path, MultipartFile file, int superID);

    //Read All
    public List<MultipartFile> readAll();

    //Read By Id
    public MultipartFile readByFileName(String fileName);

    //Read By Super ID
    public MultipartFile readBySuperID(String path, int superID);

    //Update
    public void update(String fileName);

    //Delete
    public void delete(String fileName);
}
