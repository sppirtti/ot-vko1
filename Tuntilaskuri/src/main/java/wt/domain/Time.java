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
    private Integer month;
    private Integer day;
    private Integer startHour;
    private Integer startMinute;
    private Integer endHour;
    private Integer endMinute;

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

    public Integer getMonth() {
        return this.month;
    }

    public Integer getDay() {
        return this.day;
    }

    public Integer getStartHour() {
        return this.startHour;
    }

    public Integer getStartMinute() {
        return this.startMinute;
    }

    public Integer getEndHour() {
        return this.endHour;
    }

    public Integer getEndMinute() {
        return this.endMinute;
    }

    public String toString() {

        return this.month.toString() + this.day.toString() + this.startMinute.toString() + this.endHour.toString() + this.endMinute.toString();
    }

}
