package com.example.project2d;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 713, 400);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);

        scene.setOnKeyPressed(e -> { //обработчик действия(момент нажатия на клавишу)
            if(e.getCode()== KeyCode.SPACE && !HelloController.jump)
                HelloController.jump = true;
            if(e.getCode()== KeyCode.A)
                HelloController.left = true;
            if(e.getCode()== KeyCode.D)
                HelloController.right = true;
        });

        scene.setOnKeyReleased(e -> { //обработчик действия(момент отжатия клавиши)
                    if (e.getCode() == KeyCode.A)
                        HelloController.left = false;
                    if (e.getCode() == KeyCode.D)
                        HelloController.right = false;
                    if (e.getCode() == KeyCode.ESCAPE)
                        HelloController.iSPause = !HelloController.iSPause; //устанавливаем противоположное значение
                });

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}