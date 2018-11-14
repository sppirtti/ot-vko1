/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Button;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Samuli
 */
public class TimeUI extends Application {

    @Override
    public void start(Stage login) throws Exception {
        TextField loginField = new TextField();
        
        Button loginButton = new Button ("Login");
     
        VBox loginGroup = new VBox();
        
        loginGroup.setSpacing(25);
        
        loginGroup.getChildren().addAll(loginField, loginButton);
        
        Scene loginView = new Scene (loginGroup);
        
        login.setScene(loginView);
        login.show();
        
        
        
    }
    
}
