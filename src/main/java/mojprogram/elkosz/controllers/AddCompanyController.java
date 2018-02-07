package mojprogram.elkosz.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mojprogram.elkosz.modelFX.CompanyModel;
import mojprogram.elkosz.utils.Notyfication;
import org.omg.CORBA.portable.ApplicationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by Dany on 2017-07-30.
 */
public class AddCompanyController {

    @FXML
    private Button addButton;
    @FXML
    private TextField companyNametextfield;
    @FXML
    private TextField taxIdtextfield;
    @FXML
    private TextField citytextfield;
    @FXML
    private TextField streettextfield;
    @FXML
    private TextField contactpersontextfield;
    @FXML
    private TextField phonenumbertextfield;

    private CompanyModel companyModel;

    @FXML
    private void initialize(){
        this.companyModel = new CompanyModel();
        this.companyModel.companyFxObjectPropertyProperty().get().companyNameFxProperty().bind(this.companyNametextfield.textProperty());
        this.companyModel.companyFxObjectPropertyProperty().get().taxIdfxProperty().bind(this.taxIdtextfield.textProperty());
        this.companyModel.companyFxObjectPropertyProperty().get().cityfxProperty().bind(this.citytextfield.textProperty());
        this.companyModel.companyFxObjectPropertyProperty().get().streetfxProperty().bind(this.streettextfield.textProperty());
        this.companyModel.companyFxObjectPropertyProperty().get().contactpersonfxProperty().bind(this.contactpersontextfield.textProperty());
        this.companyModel.companyFxObjectPropertyProperty().get().phonenumberfxProperty().bind(this.phonenumbertextfield.textProperty());

        validation();
        Test();

    }

    @FXML
    public void addCompany() {
        try {
            if(validateNumber()) {
                this.companyModel.saveComapanyInDataBase();
                Notyfication.noty();
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
        }

        Clear();
    }

    private void validation() {
        this.addButton.disableProperty().bind(this.companyNametextfield.textProperty().isEmpty().or(this.taxIdtextfield.textProperty().isEmpty())
                .or(this.citytextfield.textProperty().isEmpty()).or(this.streettextfield.textProperty().isEmpty())
                .or(this.contactpersontextfield.textProperty().isEmpty()).or(this.phonenumbertextfield.textProperty().isEmpty()));
    }

    public void Clear(){
        this.companyNametextfield.clear();
        this.taxIdtextfield.clear();
        this.citytextfield.clear();
        this.streettextfield.clear();
        this.contactpersontextfield.clear();
        this.phonenumbertextfield.clear();
    }

    private boolean validateNumber(){
        Pattern p = Pattern.compile("^\\d{3}\\s\\d{3}\\s\\d{3}$");
        Matcher m = p.matcher(phonenumbertextfield.getText());
        if(m.find() && m.group().equals(phonenumbertextfield.getText())){
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Uwaga");
            alert.setHeaderText(null);
            alert.setContentText("To nie jest cyfra");
            alert.showAndWait();

            return false;
        }
    }

    private void Test(){
        taxIdtextfield.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { // when focus lost
                if (!taxIdtextfield.getText().matches("^[1-9]{3}\\s\\d{2}\\s\\d{2}\\s\\d{3}$")) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Uwaga");
                    alert.setHeaderText(null);
                    alert.setContentText("To TEST");
                    alert.showAndWait();
                    taxIdtextfield.clear();

                }
            }
        });
    }
}
