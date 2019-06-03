/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersighting.dao;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author acetip
 */
public interface FileDAO {

    //Create
    public MultipartFile create(MultipartFile file, int superID);

    //ReadAll
    public List<MultipartFile> readAll();

    //ReadByID
    public MultipartFile readByID(int fileID);

    //ReadBySuperID
    public MultipartFile readBySuperID(int superID);

    //Update
    public void update(int fileID);

    //Delete
    public void delete(int fileID);
}
