package mojprogram.elkosz.controllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mojprogram.elkosz.modelFX.*;
import mojprogram.elkosz.utils.Dialogs;
import org.omg.CORBA.portable.ApplicationException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;


/**
 * Created by Dany on 2017-10-07.
 */
public class ListofCashRegisterController {

    @FXML
    private TableView<CashRegisterFx> cashRegisterFxTableView;

    @FXML
    private TableColumn<CashRegisterFx, CashRegisterFx> CompanyNameColumn;
    @FXML
    private TableColumn<CashRegisterFx, String> TypeofCashRegisterColumn;
    @FXML
    private TableColumn<CashRegisterFx, String> SerialNumerColumn;
    @FXML
    private TableColumn<CashRegisterFx, LocalDate> BuyColumn;
    @FXML
    private TableColumn<CashRegisterFx, LocalDate> LastCheckColumn;
    @FXML
    private TableColumn<CashRegisterFx, CashRegisterFx> CheackColumn;

    private CashRegisterList cashRegisterList;





    @FXML
    private void initialize(){
        this.cashRegisterList = new CashRegisterList();

        try {
            cashRegisterList.init();

        } catch (ApplicationException e) {
            e.printStackTrace();
        }

        this.cashRegisterFxTableView.setItems(this.cashRegisterList.getCashRegisterFxObservableList());
       // this.CompanyNameColumn.setCellValueFactory(cellData -> cellData.getValue().companyFxProperty());
        this.TypeofCashRegisterColumn.setCellValueFactory(cellData -> cellData.getValue().modelfxProperty());
        this.SerialNumerColumn.setCellValueFactory((cellData -> cellData.getValue().srialnumberFXProperty()));
        this.BuyColumn.setCellValueFactory(cellData -> cellData.getValue().datepuchacefxProperty());
        this.LastCheckColumn.setCellValueFactory(cellData -> cellData.getValue().lastcheckFxProperty());
        this.CheackColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));
       // this.CompanyNameColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));


        this.CheackColumn.setCellFactory(param -> {
            return new TableCell<CashRegisterFx, CashRegisterFx>() {
                Button button = createButton("/icons/if_CheckCircle_1031542.png");


                @Override
                protected void updateItem(CashRegisterFx item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        return;
                    }
                    if (!empty) {
                        setGraphic(button);
                        button.setOnAction(event -> {
                            try {

                                Optional<ButtonType> result = Dialogs.confirmDialog(item);
                                if(result.get()== ButtonType.OK){
                                    cashRegisterList.callservice(item);
                                }
                            } catch (ApplicationException e) {
                                e.printStackTrace();
                            }
                        });
                    }

                }
            };
        });



    }

        private Button createButton(String path){
        Button button = new Button();
        Image image = new Image(this.getClass().getResource(path).toString());
        ImageView imageView = new ImageView(image);
        button.setGraphic(imageView);
        return  button;
    }

    private void showdialog(){
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/DetalisCompany.fxml"));
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




}
