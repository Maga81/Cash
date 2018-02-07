package mojprogram.elkosz.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mojprogram.elkosz.modelFX.CompanyFx;
import mojprogram.elkosz.modelFX.CompanyListModel;
import org.omg.CORBA.portable.ApplicationException;

/**
 * Created by Dany on 2017-08-04.
 */
public class ChoiceCompanyController {
    @FXML
    private Button CancelBtn;
    @FXML
    private Button OkButton;
    @FXML
    private TableView<CompanyFx> CompanyTableView;

    @FXML
    private TableColumn<CompanyFx, String> companycolumn;
    @FXML
    private TableColumn<CompanyFx, String> taxIdcolumn;
    @FXML
    private TableColumn<CompanyFx, String> citycolumn;
    @FXML
    private TableColumn<CompanyFx, String> streetcolum;
    @FXML
    private TableColumn<CompanyFx, String> contactcolumn;
    @FXML
    private TableColumn<CompanyFx, String> phonecolumn;

    private CompanyListModel companyListModel;
    @FXML
    private AddCashRegisterController addCashRegisterController;


    public void setAddCashRegisterController(AddCashRegisterController addCashRegisterController) {
        this.addCashRegisterController = addCashRegisterController;
    }

    @FXML
    private void initialize(){
        this.companyListModel = new CompanyListModel();
        try {
            this.companyListModel.iniati();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
        this.CompanyTableView.setItems(this.companyListModel.getCompanyFxObservableList());
        this.companycolumn.setCellValueFactory(cellData -> cellData.getValue().companyNameFxProperty());
        this.taxIdcolumn.setCellValueFactory(cellData -> cellData.getValue().taxIdfxProperty());
        this.citycolumn.setCellValueFactory(cellData -> cellData.getValue().cityfxProperty());
        this.streetcolum.setCellValueFactory(cellData -> cellData.getValue().streetfxProperty());
        this.contactcolumn.setCellValueFactory(cellData -> cellData.getValue().contactpersonfxProperty());
        phonecolumn.setCellValueFactory(cellData -> cellData.getValue().phonenumberfxProperty());

    }

        public CompanyFx getData(){
            CompanyFx company = CompanyTableView.getSelectionModel().getSelectedItem();
            return company;
        }


    @FXML
    public void closeButtonaction() {
            if(getData()==null){
                ButtonAction(OkButton);
            }else{
            this.addCashRegisterController.setSelected(getData());
                ButtonAction(OkButton);
        }
    }
    @FXML
    public void CancelAction(){
        ButtonAction(CancelBtn);
    }

    public void ButtonAction(Button button){
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }
}
