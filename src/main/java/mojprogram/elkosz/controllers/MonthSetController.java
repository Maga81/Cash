package mojprogram.elkosz.controllers;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;


/**
 * Created by Dany on 2017-11-17.
 */
public class MonthSetController {
    @FXML
   private ListofCashRegisterController listofCashRegisterController;

     @FXML
    private Button close;

     @FXML
     private Spinner gapcheck;

     @FXML
     private void initialize(){
         SpinnerValueFactory<Integer> gapValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,24);
         this.gapcheck.setValueFactory(gapValueFactory);


     }

     public int getinfo(){
         return (int) gapcheck.getValue();
     }

    @FXML
    public void closeAction() {
       /// this.listofCashRegisterController.setMonth(getinfo());

        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }
}
