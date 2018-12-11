/**
 * Sisältää User-olion. User olion voi luoda antamalla etunimen ja sukunimen.
 * 
 * Olio osaa generoida itse käyttäjänimen jota käytetään sisäänkirjatumiseen sovellukseen.
 */

package wt.domain;

public class User {

    private String firstname;
    private String surname;
    private String username;

    public User(String firstname, String surname) {
        this.firstname = firstname;
        this.surname = surname;
        setUsername();

    }
    
    public User(String firstname, String surname, String username) {
        this.firstname = firstname;
        this.surname = surname;
        this.username = username;
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
        String sur = new String();
        if (surname.length() < 4) {

            sur = surname.substring(0, surname.length());
        } else {
            sur = surname.substring(0, 3);
        }
        username = first + sur;

    }

    public Boolean uniqueUser(Object obj) {
        if (!(obj instanceof User)) {
            return false;
        }
        User other = (User) obj;

        return username.equals(other.username);
    }

    // uniikkitarkastelu puuttuu!
}
