package com.example.matvey;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController extends ActionEvent{

    @FXML TextField fieldX;
    @FXML TextField fieldN;
    @FXML Label output;
    @FXML Label errorText;

    @FXML
    public void toEnterData(){
        try{
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            Pane root = fxmlLoader.load(getClass().getResource("www.fxml").openStream());
            Scene scene = new Scene(root, 700, 400);
            stage.setScene(scene);
            stage.setTitle("Лабораторная работа №6");
            stage.showAndWait();

        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void toSolve(ActionEvent actionEvent) throws IOException {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            Pane root = fxmlLoader.load(getClass().getResource("wwww.fxml").openStream());
            Scene scene = new Scene(root, 700, 400);
            stage.setScene(scene);
            stage.setTitle("Лабораторная работа №6");
            Label label = (Label) scene.lookup("#output");
            label.setText(String.valueOf(Stepen(Double.parseDouble(fieldX.getText()), Integer.parseInt(fieldN.getText()))));
            stage.showAndWait();
        }
        catch (Exception ex){
            errorText.setText("Ошибка - введенные данные неккоректны");
        }
    }

    public static double Stepen(double x, int n){
        return Math.pow(x, n);
    }
}