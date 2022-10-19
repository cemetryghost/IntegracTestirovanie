package com.example.matvey;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import com.sun.management.OperatingSystemMXBean;


import javax.management.MBeanServerConnection;
import java.io.IOException;
import java.lang.management.ManagementFactory;

public class HelloController extends ActionEvent{

    @FXML TextField fieldX;
    @FXML TextField fieldN;
    @FXML Label output;
    @FXML Label errorText;
    int counter;

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

        long time = System.currentTimeMillis();
        long usedBytes = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());

        try {
            counter++;
            if(counter == 6){
                System.exit(1);
            }
            else{
                errorText.setText("");
                double x = Double.parseDouble(fieldX.getText());
                String n = fieldN.getText();
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader();
                Pane root = fxmlLoader.load(getClass().getResource("wwww.fxml").openStream());
                Scene scene = new Scene(root, 700, 400);
                stage.setScene(scene);
                stage.setTitle("Лабораторная работа №6");
                Label label = (Label) scene.lookup("#output");
                label.setText(String.valueOf(Stepen(Double.parseDouble(fieldX.getText()), Integer.parseInt(fieldN.getText()))));
                stage.showAndWait();
                System.out.println("Время выполения программы = " + (System.currentTimeMillis() - time) + " мс.");
                System.out.printf("Выделено памяти ОЗУ %d байт (%d Мб)\n", usedBytes, usedBytes / 1048576);
                checkCPU();
            }
        }
        catch (Exception ex){
            errorText.setText("Ошибка - неккоректный ввод данных!");
        }
    }

    public static double Stepen(double x, int n){
        double k = x;
        for(int i = 1; i < n; i++){
            x *= k;
        }
        return x;
    }
    public static void checkCPU() throws IOException {
        MBeanServerConnection mbsc = ManagementFactory.getPlatformMBeanServer();

        OperatingSystemMXBean osMBean = ManagementFactory.newPlatformMXBeanProxy(
                mbsc, ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME, OperatingSystemMXBean.class);

        long nanoBefore = System.nanoTime();
        long cpuBefore = osMBean.getProcessCpuTime();

        long cpuAfter = osMBean.getProcessCpuTime();
        long nanoAfter = System.nanoTime();

        double percent;
        if (nanoAfter > nanoBefore)
            percent = ((cpuAfter-cpuBefore)*100L)/
                    (nanoAfter-nanoBefore);
        else percent = 0;

        System.out.println("Cpu usage: "+ percent +"%");
    }
}