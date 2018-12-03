/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wt.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import wt.domain.Time;
import wt.domain.User;

/**
 *
 * @author Samuli
 */
public class TimeFileDao implements TimeDao {

    public List<Time> times;
    private String filename;

    public TimeFileDao(String filename, UserFileDao users) throws Exception {

        this.filename = filename;
        times = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split(";");
                User u = users.getAll().stream().filter(e -> e.getUsername().equals(split[0])).findFirst().orElse(null);
                
                Time newTime = new Time(u, Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]),
                        Integer.parseInt(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split[6]));

                times.add(newTime);

            }

        } catch (Exception e) {
            FileWriter fw = new FileWriter(new File(filename));
            fw.close();

        }
    }

    public void save() throws Exception {
        try (FileWriter fw = new FileWriter(new File(filename))) {
            for (Time t : times) {
                fw.write(
                        t.getUser() + ";" + t.getMonth() + ";"
                        + t.getDay() + ";" + t.getStartHour() + ";"
                        + t.getStartMinute() + ";" + t.getEndHour() + ";"
                        + t.getEndMinute() + "\n");

            }

        }
    }

    @Override
    public Time addTime(Time time) throws Exception {
        times.add(time);
        save();

        return time;
    }

    @Override
    public List<Time> getAll() {
        return times;
    }

}
