package com.example.project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private char nowSym ='x';

    private char gameField[][] = new char[3][3];

    private boolean isGame = true;

    @FXML
    void btnClick(ActionEvent event) {

        Button btn =((Button)event.getSource());

        if(!isGame || btn.getText() != "") return;

        int rowIndex = GridPane.getRowIndex(btn) == null ? 0 : GridPane.getRowIndex(btn);
        int colIndex = GridPane.getColumnIndex(btn) == null ? 0 : GridPane.getColumnIndex(btn);

        gameField[rowIndex][colIndex] = nowSym;

        System.out.println(rowIndex);
        System.out.println(colIndex);

        btn.setText(String.valueOf(nowSym));

        if(gameField[0][0] == gameField[0][1] && gameField[0][0] == gameField[0][2] && (gameField[0][0] == 'x' || gameField[0][0] == 'o')) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "У нас есть победитель <" + btn.getText() + ">", ButtonType.OK);
            alert.showAndWait();
            isGame = false;
        }
        else if(gameField[1][0] == gameField[1][1] && gameField[1][0] == gameField[1][2] && (gameField[1][0] == 'x' || gameField[1][0] == 'o')) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "У нас есть победитель <" + btn.getText() + ">", ButtonType.OK);
            alert.showAndWait();
            isGame = false;
        }
        else if(gameField[2][0] == gameField[2][1] && gameField[2][0] == gameField[1][2] && (gameField[2][0] == 'x' || gameField[2][0] == 'o')) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "У нас есть победитель <" + btn.getText() + ">", ButtonType.OK);
            alert.showAndWait();
            isGame = false;
        }
        else if(gameField[0][0] == gameField[1][0] && gameField[0][0] == gameField[2][0] && (gameField[0][0] == 'x' || gameField[0][0] == 'o')) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "У нас есть победитель <" + btn.getText() + ">", ButtonType.OK);
            alert.showAndWait();
            isGame = false;
        }
        else if(gameField[0][1] == gameField[1][1] && gameField[0][1] == gameField[2][1] && (gameField[0][1] == 'x' || gameField[0][1] == 'o')) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "У нас есть победитель <" + btn.getText() + ">", ButtonType.OK);
            alert.showAndWait();
            isGame = false;
        }
        else if(gameField[0][2] == gameField[1][2] && gameField[0][2] == gameField[2][2] && (gameField[0][2] == 'x' || gameField[0][2] == 'o')) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "У нас есть победитель <" + btn.getText() + ">", ButtonType.OK);
            alert.showAndWait();
            isGame = false;
        }
        else if(gameField[0][0] == gameField[1][1] && gameField[0][0] == gameField[2][2] && (gameField[0][0] == 'x' || gameField[0][0] == 'o')) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "У нас есть победитель <" + btn.getText() + ">", ButtonType.OK);
            alert.showAndWait();
            isGame = false;
        }
        else if(gameField[2][2] == gameField[1][1] && gameField[2][2] == gameField[0][2] && (gameField[2][2] == 'x' || gameField[2][2] == 'o')) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "У нас есть победитель <" + btn.getText() + ">", ButtonType.OK);
            alert.showAndWait();
            isGame = false;
        }



        nowSym = nowSym == 'x' ? 'o' : 'x';
    }

    @FXML
    void initialize() {

    }
}
