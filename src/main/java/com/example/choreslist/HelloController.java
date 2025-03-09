package com.example.choreslist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.example.choreslist.FileController.collectTask;
import static com.example.choreslist.FileController.Addtask;
import static com.example.choreslist.FileController.Removetask;



public class HelloController {
    @FXML
    private ListView<String> dailylist;
    private ObservableList<String> dailyobs;
    @FXML
    private TextField dailytext;

    @FXML
    private ListView<String> weeklylist;
    private ObservableList<String> weeklyobs;
    @FXML
    private TextField weeklytext;

    @FXML
    private ListView<String> monthlylist;
    private ObservableList<String> monthlyobs;
    @FXML
    private TextField monthlytext;




    @FXML
    public void initialize() throws FileNotFoundException {
        //setup OBS
        dailyobs = FXCollections.observableArrayList();
        weeklyobs = FXCollections.observableArrayList();
        monthlyobs = FXCollections.observableArrayList();

        dailylist.setItems(dailyobs);
        weeklylist.setItems(weeklyobs);
        monthlylist.setItems(monthlyobs);

        ArrayList<String> d_tasks = new ArrayList<>();
        d_tasks = collectTask("src/main/resources/com/example/choreslist/daily-tasks.txt");

        ArrayList<String> w_tasks = new ArrayList<>();
        w_tasks = collectTask("src/main/resources/com/example/choreslist/weekly-tasks.txt");

        ArrayList<String> m_tasks = new ArrayList<>();
        m_tasks = collectTask("src/main/resources/com/example/choreslist/monthly-tasks.txt");


        dailyobs.addAll(d_tasks);
        weeklyobs.addAll(w_tasks);
        monthlyobs.addAll(m_tasks);

    }

    @FXML
    protected void onAddClick_d() throws FileNotFoundException {
        String input = dailytext.getText().trim();
        if(!input.isEmpty()) {
            dailyobs.add(input);
            Addtask("src/main/resources/com/example/choreslist/daily-tasks.txt", input);
            dailytext.clear();
        }
    }

    @FXML
    protected void onAddClick_w() throws FileNotFoundException {
        String input = weeklytext.getText().trim();
        if(!input.isEmpty()) {
            weeklyobs.add(input);
            Addtask("src/main/resources/com/example/choreslist/weekly-tasks.txt", input);
            weeklytext.clear();
        }
    }

    @FXML
    protected void onAddClick_m() throws FileNotFoundException {
        String input = monthlytext.getText().trim();
        if(!input.isEmpty()) {
            monthlyobs.add(input);
            Addtask("src/main/resources/com/example/choreslist/monthly-tasks.txt", input);
            monthlytext.clear();
        }
    }

    @FXML
    protected void onRemoveClick_d() throws FileNotFoundException {
        String input = dailytext.getText().trim();
        if(!input.isEmpty()) {
            dailyobs.remove(input);
            Removetask("src/main/resources/com/example/choreslist/daily-tasks.txt", input);
            dailytext.clear();
        }
    }

    @FXML
    protected void onRemoveClick_w() throws FileNotFoundException {
        String input = weeklytext.getText().trim();
        if(!input.isEmpty()) {
            weeklyobs.remove(input);
            Removetask("src/main/resources/com/example/choreslist/weekly-tasks.txt", input);
            weeklytext.clear();
        }
    }

    @FXML
    protected void onRemoveClick_m() throws FileNotFoundException {
        String input = monthlytext.getText().trim();
        if(!input.isEmpty()) {
            monthlyobs.remove(input);
            Removetask("src/main/resources/com/example/choreslist/monthly-tasks.txt", input);
            monthlytext.clear();
        }
    }

}