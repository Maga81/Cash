package mojprogram.elkosz.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

/**
 * Created by Dany on 2017-07-24.
 */
public class ToggleButtonsController {


    public static final String ADD_CASH_REGISTER = "/fxml/AddCashRegister.fxml";
    public static final String ADD_COMPANY = "/fxml/AddCompany.fxml";
    public static final String LIST_OF_CASH_REGISTER = "/fxml/ListofCashRegister.fxml";
    public static final String LISTOF_COPMANY = "/fxml/ListofCopmany.fxml";
    private MainController mainController;

    @FXML
    private ToggleGroup toggleGroup;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
    @FXML
    public void addCash() {
        mainController.setCenter(ADD_CASH_REGISTER);
    }
    @FXML
    public void addCompany() {
        mainController.setCenter(ADD_COMPANY);

    }
    @FXML
    public void showcash() {
        mainController.setCenter(LIST_OF_CASH_REGISTER);

    }
    @FXML
    public void CompanyList() {
        mainController.setCenter(LISTOF_COPMANY);

    }
}
