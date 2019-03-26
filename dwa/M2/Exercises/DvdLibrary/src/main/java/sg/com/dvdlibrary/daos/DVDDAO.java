/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.dvdlibrary.daos;

import java.util.List;
import sg.com.dvdlibrary.dtos.DVD;

/**
 *
 * @author Randall
 */
public interface DVDDAO {

    DVD Create(DVD entity);

    void Delete(int id);

    List<DVD> ReadAll();
    
    List<DVD> ReadByDirectorId(int directorId);

    DVD ReadById(int id);

    void Update(int id, DVD entity);
    
}
