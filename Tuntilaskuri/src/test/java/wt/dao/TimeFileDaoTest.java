package wt.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import wt.domain.AppLogic;
import wt.domain.Time;

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

        try (FileWriter fw = new FileWriter(timeFile.getAbsolutePath())) {
            fw.write("spir;10;10;12;30;13;40");
        }

        udao = new UserFileDao(userFile.getAbsolutePath());
        dao = new TimeFileDao(timeFile.getAbsolutePath(), (UserFileDao) udao);

        appLogic = new AppLogic(udao, dao);

    }

    @Test
    public void NoListWhenLoggedOut() {
        appLogic.logOutUser();

        List<Time> times = appLogic.getTimes();
        assertEquals(0, times.size());

    }

    @Test
    public void AddingNewTimesWorks() throws Exception {
        Time t = new Time("spir", 10, 10, 10, 10, 11, 10);
        dao.addTime(t);

        assertTrue(dao.getAll().size() > 0);
    }

}
