/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wt.dao;

import java.io.File;
import java.io.FileWriter;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import wt.domain.User;

/**
 *
 * @author Samuli
 */
public class UserFileDaoTest {
    
    TemporaryFolder testFolder = new TemporaryFolder();
    
    File userFile;
    UserDao dao;
    
    @Before
    public void setUp() throws Exception {
        userFile = testFolder.newFile("testfile_users.txt");  
        
        try (FileWriter file = new FileWriter(userFile.getAbsolutePath())) {
            file.write("testertester;Teppo Testaaja\n");
        }
        
        dao = new UserFileDao(userFile.getAbsolutePath());
    }
    
    @Test
    public void UsersAddedToListCorrectly() throws Exception {
              
    }
    
    @Test
    public void NonExistingUserFound() {
        User u = dao.findByUsername("matti");
        
        assertEquals(null, u);
    }
    
}
