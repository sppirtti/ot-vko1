package Domain;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Samuli
 *
 * One instance of worktimer, includes starttime and end time, calculates the
 * time worked.
 */
public class Timer {

    private String time;
    private String date;
    private String dateToString;

    public Timer() {
        String dateToString = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String date = dateToString.substring(0, 7);
        String time = dateToString.substring(9, 14);

    }

}
