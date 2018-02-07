package mojprogram.elkosz.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mojprogram.elkosz.utils.Dialogs;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by Dany on 2017-07-24.
 */
public class MainController {

    @FXML
    private BorderPane borderpane;
    @FXML
    private ToggleButtonsController togglebuttonsController;

    @FXML
    private void initialize(){
        togglebuttonsController.setMainController(this);
    }

    public void setCenter(String fxmlPath){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        Parent parent = null;
        try {
             parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        borderpane.setCenter(parent);

    }
    @FXML
    public void CloseApp() {
        Optional<ButtonType> result = Dialogs.exitDialog();
        if(result.get()== ButtonType.OK){
            Platform.exit();
            System.exit(0);
        }
    }
    @FXML
    public void Settings() {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MonthSet.fxml"));
        AnchorPane anchorPane = null;
        try {
             anchorPane = loader.load();
            Scene scene = new Scene(anchorPane);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void About() {
        Dialogs.InformationDialog();
    }
}
