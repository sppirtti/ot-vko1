/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Dao.UserFileDao;
import Domain.AppLogic;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Samuli
 */
public class TimerUI extends Application {

    /**
     * @param args the command line arguments
     */
    private AppLogic appLogic;

    public static void main(String[] args) {
        // TODO code application logic here

        launch(args);
    }

    
    @Override
    public void init() throws Exception {
        

        UserFileDao userDao = new UserFileDao("users.txt");

        appLogic = new AppLogic(userDao);
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Login screen
        //Create needed objects
        Button loginbutton = new Button("Login");
        Button newuserbutton = new Button("Create new user");
        Label userLabel = new Label("Username: ");
        TextField loginfield = new TextField("");

        //Set textfield and indicator
        HBox loginPane = new HBox();
        loginPane.setSpacing(10);
        loginPane.getChildren().addAll(userLabel, loginfield);

        Label loginMessage = new Label("");
        loginMessage.setFont(new Font("Serif", 14));

        //set loginbutton
        VBox loginLayout = new VBox();
        loginLayout.setSpacing(10);
        loginLayout.getChildren().addAll(loginPane, loginbutton, loginMessage);

        loginLayout.setMinHeight(200);

        //set final layout
        BorderPane loginGroup = new BorderPane();
        loginGroup.setCenter(loginLayout);
        loginGroup.setBottom(newuserbutton);

        loginGroup.setPadding(new Insets(20));

        //choose scene
        Scene loginView = new Scene(loginGroup);
        primaryStage.setScene(loginView);
        primaryStage.show();

        //New user screen
        //create panes
        HBox firstName = new HBox();
        HBox surName = new HBox();
        HBox buttons = new HBox();
        HBox userName = new HBox();

        //Create fields and indicators
        firstName.setSpacing(20);
        surName.setSpacing(20);
        buttons.setSpacing(60);

        Label firstInd = new Label("First name:");
        TextField firstField = new TextField("");

        firstName.getChildren().addAll(firstInd, firstField);

        Label surInd = new Label("Surname:");
        TextField surField = new TextField("");

        surName.getChildren().addAll(surInd, surField);

        Label userCreation = new Label("");

        //Create buttons
        Button create = new Button("Create");
        Button cancel = new Button("Cancel");

        buttons.getChildren().addAll(create, cancel);
        //Create layout
        VBox createLayout = new VBox();

        createLayout.setSpacing(20);
        createLayout.setPadding(new Insets(20));

        createLayout.getChildren().addAll(firstName, surName, userName, buttons, userCreation);

        Scene newuserScene = new Scene(createLayout);

        //BUTTON ACTIONS
        newuserbutton.setOnAction(e -> {
            primaryStage.setScene(newuserScene);
        });

        cancel.setOnAction(e -> {
            primaryStage.setScene(loginView);
        });

        create.setOnAction(e -> {
            String firstname = firstField.getText();
            String surname = surField.getText();

            String sur = new String();
            if (surname.length() < 4) {

                sur = surname.substring(0, surname.length());
            } else {
                sur = surname.substring(0, 3);
            }

            String username = new String(String.valueOf(firstname.charAt(0)) + sur);

            if (firstname.length() < 1) {
                userCreation.setText("First name too short!");
            }
            if (surname.length() < 1) {
                userCreation.setText("Surname too short!");
            } else if (appLogic.createNewUser(firstname, surname)) {

                primaryStage.setScene(loginView);
                loginMessage.setText("New user created!" + "\n" + "Username: " + username);

            }

        });
    }

}
