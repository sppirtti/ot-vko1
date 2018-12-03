/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wt.domain;

/**
 *
 * @author Samuli
 */
public class Time {

    private User user;
    private int month;
    private int day;
    private int startHour;
    private int startMinute;
    private int endHour;
    private int endMinute;

    public Time(User user, Integer month, Integer day, Integer startHour, Integer startMinute, Integer endHour, Integer endMinute) {
        this.user = user;
        this.month = month;
        this.day = day;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
    }

    public User getUser() {
        return user;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public int getStartHour() {
        return this.startHour;
    }

    public int getStartMinute() {
        return this.startMinute;
    }

    public int getEndHour() {
        return this.endHour;
    }

    public int getEndMinute() {
        return this.endMinute;
    }

}
