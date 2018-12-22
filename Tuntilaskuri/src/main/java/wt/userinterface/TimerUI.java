/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wt.userinterface;

import java.util.ArrayList;
import java.util.List;
import wt.dao.UserFileDao;
import wt.domain.AppLogic;

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
import wt.dao.TimeFileDao;
import wt.domain.Time;

/**
 *
 * @author Samuli
 */
public class TimerUI extends Application {

    /**
     * @param args the command line arguments
     */
    private AppLogic appLogic;
    private VBox timesBox;

    public static void main(String[] args) {
        // TODO code application logic here

        launch(args);
    }

    @Override
    public void init() throws Exception {

        UserFileDao userDao = new UserFileDao("users.txt");
        TimeFileDao timeDao = new TimeFileDao("times.txt", userDao);

        appLogic = new AppLogic(userDao, timeDao);
        appLogic.logOutUser();

        timesBox = new VBox();

    }

    /**
     * Listaa ajat omiin Label olioihin ja laittaa ne muotoon jotta niitä voidaan tarkastella historiassa.
     */
    public void timeList() {
        List<Time> timeList = new ArrayList<>();
        timeList.addAll(appLogic.getTimes());

        int i = 0;

        timesBox = new VBox();

        if (timeList.size() > 14) {
            i = timeList.size() - 14;
        } else {
            i = 0;
        }

        while (i < timeList.size()) {
            if (i == timeList.size()) {
                break;
            }
            Label tempLabel = new Label("");
            Time tempTime = timeList.get(i);
            Integer totalHours = 0;
            Integer totalMinutes = 0;

            String TWorked = appLogic.timeWorkedForTime(tempTime);

            String tempText = new String();
            tempText = tempTime.getMonth().toString() + "    " + tempTime.getDay().toString() + "     " + tempTime.getStartHour()
                    + "    " + tempTime.getStartMinute() + "    " + tempTime.getEndHour() + "    " + tempTime.getEndMinute()
                    + "    " + TWorked;
            tempLabel.setText(tempText);

            timesBox.getChildren().add(tempLabel);
            i++;

        }

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
        createLayout.setMinHeight(230);
        createLayout.setSpacing(20);
        createLayout.setPadding(new Insets(20));

        createLayout.getChildren().addAll(firstName, surName, userName, buttons, userCreation);

        Scene newuserScene = new Scene(createLayout);

        //TimerScreen
        Button logOutButton = new Button("Log Out");
        Button timerButton = new Button("Start Timer");

        Label timeDate = new Label("");
        Label timeStarted = new Label("");
        Label timeStopped = new Label("");
        Label timeWorked = new Label("");

        Label date = new Label("Date(DD/MM): ");
        Label started = new Label("Time Started(HH/MM): ");
        Label stopped = new Label("Time Stopped(HH/MM): ");
        Label worked = new Label("Time Worked(HH/MM) : ");
        Label timerLabel = new Label("");

        Button history = new Button("Show History");

        HBox dateBox = new HBox();
        HBox startBox = new HBox();
        HBox stopBox = new HBox();
        HBox workedBox = new HBox();

        dateBox.setSpacing(20);
        startBox.setSpacing(20);
        stopBox.setSpacing(20);
        workedBox.setSpacing(20);

        dateBox.getChildren().addAll(date, timeDate);
        startBox.getChildren().addAll(started, timeStarted);
        stopBox.getChildren().addAll(stopped, timeStopped);
        workedBox.getChildren().addAll(worked, timeWorked);

        VBox timerLayout = new VBox();
        timerLayout.setSpacing(20);
        timerLayout.setPadding(new Insets(20));
        timerLayout.setMinWidth(350);
        timerLayout.getChildren().addAll(dateBox, startBox, stopBox, workedBox, timerButton, logOutButton, timerLabel, history);

        Scene timerScene = new Scene(timerLayout);

        //TIME HISTORY SCREEN
        Label historyLabel = new Label("Mo" + " | " + "Da" + " | " + "SH:SM" + "  " + "EH:EM" + "    Total(H:MM)");
        Button back = new Button("Back");
        VBox historyBox = new VBox();

        historyBox.setMinSize(250, 300);
        historyBox.setSpacing(20);
        historyBox.setPadding(new Insets(20));

        historyBox.getChildren().addAll(back, historyLabel);

        Scene historyScene = new Scene(historyBox);

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

            } else {
                userCreation.setText("User with same Username exists!" + "\n" + "Contact Support!");
            }

        });

        loginbutton.setOnAction(action -> {

            if (appLogic.userLogin(loginfield.getText())) {

                primaryStage.setScene(timerScene);

            } else {
                loginMessage.setText("User doesn't exist!");
            }

        });

        timerButton.setOnAction(action -> {

            if (timerButton.getText().equals("Start Timer")) {

                appLogic.startTimer();

                timerButton.setText("Stop Timer");

                timeDate.setText(appLogic.getDate().toString() + "." + appLogic.getMonth().toString());

                if (appLogic.getHour() < 10 && appLogic.getMinute() < 10) {
                    timeStarted.setText("0" + appLogic.getHour().toString() + ":" + "0" + appLogic.getMinute().toString());
                }
                if (appLogic.getHour() < 10 && appLogic.getMinute() > 10) {
                    timeStarted.setText("0" + appLogic.getHour().toString() + ":" + appLogic.getMinute().toString());
                }
                if (appLogic.getHour() > 10 && appLogic.getMinute() < 10) {
                    timeStarted.setText(appLogic.getHour().toString() + ":" + "0" + appLogic.getMinute().toString());
                } else {
                    timeStarted.setText(appLogic.getHour().toString() + ":" + appLogic.getMinute().toString());
                }

            } else {
                appLogic.stopTimer();
                timeWorked.setText(appLogic.timeWorked());
                appLogic.createNewTime();

                timerButton.setText("Start Timer");

                if (appLogic.getEndHour() < 10 && appLogic.getEndMinute() < 10) {
                    timeStopped.setText("0" + appLogic.getEndHour().toString() + ":" + "0" + appLogic.getEndMinute().toString());
                }
                if (appLogic.getEndHour() < 10 && appLogic.getEndMinute() > 10) {
                    timeStopped.setText("0" + appLogic.getEndHour().toString() + ":" + appLogic.getEndMinute().toString());
                }
                if (appLogic.getEndHour() > 10 && appLogic.getEndMinute() < 10) {
                    timeStopped.setText(appLogic.getEndHour().toString() + ":" + "0" + appLogic.getEndMinute().toString());
                } else {
                    timeStopped.setText(appLogic.getEndHour().toString() + ":" + appLogic.getEndMinute().toString());
                }
            }

        });

        logOutButton.setOnAction(action -> {
            if (timerButton.getText().equals("Stop Timer")) {
                timerLabel.setText("Stop timer before logging out!");

            } else {
                timeDate.setText("");
                timeStarted.setText("");
                timeWorked.setText("");
                timeStopped.setText("");
                appLogic.logOutUser();
                primaryStage.setScene(loginView);
            }
        });

        history.setOnAction(action -> {

            timeList();
            historyBox.getChildren().add(timesBox);
            primaryStage.setScene(historyScene);
        });

        back.setOnAction(action -> {
            historyBox.getChildren().remove(timesBox);

            primaryStage.setScene(timerScene);
        });

    }

}
