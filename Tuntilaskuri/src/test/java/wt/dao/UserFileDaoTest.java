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
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import wt.domain.User;

/**
 *
 * @author Samuli
 */
public class UserFileDaoTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    File userFile;
    UserDao dao;

    @Before
    public void setUp() throws Exception {
        userFile = testFolder.newFile("testfile_users.txt");

        try (FileWriter fw = new FileWriter(userFile.getAbsolutePath())) {
            fw.write("Samuli;Pirttimaki;SPir\n");
        }

        dao = new UserFileDao(userFile.getAbsolutePath());
    }

    @Test
    public void newUserIsSaved() throws Exception {
        User u = new User("Matti", "Meika");
        dao.createUser(u);

        User listUser = dao.findByUsername("MMei");
        assertEquals("Matti", listUser.getFirstname());
        assertEquals("Meika", listUser.getSurname());
    }

    @Test
    public void nonExistingUserFound() {
        User u = dao.findByUsername("matti");

        assertEquals(null, u);
    }

}
