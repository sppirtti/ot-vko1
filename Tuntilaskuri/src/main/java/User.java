/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Samuli
 */
public class User {

    private String firstname;
    private String surname;
    private String username;

    public User(String firstname, String surname) {
        this.firstname = firstname;
        this.surname = surname;
        
    }
    
    public String getFirstname() {
        return firstname;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername() {
        String first = String.valueOf(firstname.charAt(0));
        String fourSur = surname.substring(0, 3);
        username = first + fourSur;
        
    }
    
    // uniikkitarkastelu puuttuu!
}
