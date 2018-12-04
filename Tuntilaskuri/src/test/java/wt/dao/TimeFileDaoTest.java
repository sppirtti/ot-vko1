/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wt.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import wt.domain.AppLogic;
import wt.domain.Time;

/**
 *
 * @author Samuli
 */
public class TimeFileDaoTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    File timeFile;
    File userFile;
    UserDao udao;
    TimeDao dao;
    AppLogic appLogic;

    @Before
    public void setUp() throws Exception {
        List<Time> list = new ArrayList<>();

        timeFile = testFolder.newFile("testfile_times.txt");
        userFile = testFolder.newFile("testfile_users.txt");

        try (FileWriter fw = new FileWriter(userFile.getAbsolutePath())) {
            fw.write("Samuli;Pirttimäki;SPir");
        }

        udao = new UserFileDao(userFile.getAbsolutePath());
        dao = new TimeFileDao(timeFile.getAbsolutePath(), (UserFileDao) udao);

        appLogic = new AppLogic(udao, dao);

    }
    @Test
    public void NoListWhenLoggedOut() {
        appLogic.logOutUser();
        
        List <Time> times = appLogic.getTimes();
        assertEquals(0, times.size());
        
    }
    
    @Test
    public void addTime() {
        appLogic.createNewTime();
    }

}
