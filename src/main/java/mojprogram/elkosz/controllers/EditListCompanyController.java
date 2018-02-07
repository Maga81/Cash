package mojprogram.elkosz.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mojprogram.elkosz.modelFX.CompanyModel;
import org.omg.CORBA.portable.ApplicationException;

/**
 * Created by Dany on 2017-08-07.
 */
public class EditListCompanyController {

    @FXML
    private Button cancelbutton;
    @FXML
    private TextField eCompanyNameTextfield;
    @FXML
    private TextField etaxIdTextField;
    @FXML
    private TextField eCityTextField;
    @FXML
    private TextField eStreetTextField;
    @FXML
    private TextField eContactPersonTextField;
    @FXML
    private TextField ephoneTextField;

    public CompanyModel getCompanyModel() {
        return companyModel;
    }

    @FXML
    private Button changeListButton;

    private CompanyModel companyModel;

    @FXML
    private void initialize(){

        this.companyModel = new CompanyModel();
        bindings();



    }

    public void bindings(){
        this.eCompanyNameTextfield.textProperty().bindBidirectional(this.companyModel.getCompanyFxObjectProperty().companyNameFxProperty());
        this.etaxIdTextField.textProperty().bindBidirectional(this.companyModel.getCompanyFxObjectProperty().taxIdfxProperty());
        this.eCityTextField.textProperty().bindBidirectional(this.companyModel.getCompanyFxObjectProperty().cityfxProperty());
        this.eStreetTextField.textProperty().bindBidirectional(this.companyModel.getCompanyFxObjectProperty().streetfxProperty());
        this.eContactPersonTextField.textProperty().bindBidirectional(this.companyModel.getCompanyFxObjectProperty().contactpersonfxProperty());
        this.ephoneTextField.textProperty().bindBidirectional(this.companyModel.getCompanyFxObjectProperty().phonenumberfxProperty());
    }

    public void Change() {
        try {
            this.companyModel.saveComapanyInDataBase();
            Stage stage = (Stage) changeListButton.getScene().getWindow();
            stage.close();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }


    }
    @FXML
    public void cancelAction() {
        Stage stage = (Stage) cancelbutton.getScene().getWindow();
        stage.close();

    }
}
