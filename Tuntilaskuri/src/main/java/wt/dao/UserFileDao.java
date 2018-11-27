/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wt.dao;

import wt.domain.User;
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
    String filename;
    
    public UserFileDao(String filename) throws Exception {
        this.filename = filename;
        users = new ArrayList<>();
        System.out.println("uusi dao");
        
        try {
            
            Scanner scanner = new Scanner(new File(filename));
            System.out.println("luetaan lista");
            while (scanner.hasNextLine()) {
                
                String[] split = scanner.nextLine().split(";");
                User newUser = new User(split[0], split[1], split[2]);
                users.add(newUser);
                System.out.println("1");
                
            }
        } catch (Exception e) {
            FileWriter fw = new FileWriter(new File(filename));
            fw.close();
        }
    }
    
    private void save() throws Exception {
        
        try (FileWriter fw = new FileWriter(new File(filename))) {
            for (User u : users) {
                fw.write(u.getFirstname() + ";" + u.getSurname() + ";" + u.getUsername() + "\n");
            }
        }
    }
    
    @Override
    public User findByUsername(String username
    ) {
        
        return users.stream()
                .filter(u -> u.getUsername()
                .equals(username))
                .findFirst()
                .orElse(null);
        
    }
    
    @Override
    public User createUser(User user) throws Exception {
        
        users.add(user);
        System.out.println("luonti" + user.toString());
        save();
        return user;
    }
    
}
