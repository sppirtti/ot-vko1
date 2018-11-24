/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Domain.User;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Samuli
 */
public class UserFileDao implements UserDao {

    List<User> users;
    String file;

    public UserFileDao(String file) {
        this.file = file;
        users = new ArrayList<User>();

        try {
            Scanner scanner = new Scanner(new File(file));
            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split(";");
                User newUser = new User(split[0], split[1]);
                users.add(newUser);
            }
        } catch (Exception e) {
            System.out.println("jotain meni pieleen!");
        }
    }

    @Override
    public User createUser(User user) {
        users.add(user);
        save();
        return user;
    }

    public void save() {
        try {
            FileWriter fw = new FileWriter(new File(file));
            for (User user : users) {
                fw.write(user.getFirstname() + ";" + user.getSurname() + ";" + user.getUsername() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Jotain meni pieleen");
        }

    }

    @Override
    public User findByUsername(String username) {

        return users.stream()
                .filter(u -> u.getUsername()
                .equals(username))
                .findFirst()
                .orElse(null);

    }

}
