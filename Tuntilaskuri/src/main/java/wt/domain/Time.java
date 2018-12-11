/**
 * Aika-luokka joka käsittää Time oliot ja jonka avulla niitähin liittyvää tietoa voidaan hakea.
 * 
 * Aikaluokka käyttää User luokan usernamea sisältääkseen tietyn ajan aina tiettyä User-oliota kohden.
 */
package wt.domain;

public class Time {

    private String user;
    private Integer month;
    private Integer day;
    private Integer startHour;
    private Integer startMinute;
    private Integer endHour;
    private Integer endMinute;

    public Time(String user, Integer month, Integer day, Integer startHour, Integer startMinute, Integer endHour, Integer endMinute) {
        this.user = user;
        this.month = month;
        this.day = day;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
    }

    public String getUser() {
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

}
