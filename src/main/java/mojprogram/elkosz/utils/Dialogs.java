package mojprogram.elkosz.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import mojprogram.elkosz.modelFX.CashRegisterFx;

import java.util.Optional;

/**
 * Created by Dany on 2017-07-06.
 */
public class Dialogs {

    public static void InformationDialog(){

        Alert informationdialog = new Alert(Alert.AlertType.INFORMATION);
        informationdialog.setTitle("O Programie");
        informationdialog.setHeaderText("Program ELKOSZ");
        informationdialog.setContentText("Progam rozwijamy");
        informationdialog.showAndWait();
    }

    public static Optional<ButtonType> exitDialog(){

        Alert exitdialog = new Alert(Alert.AlertType.CONFIRMATION);
        exitdialog.setTitle("Wyjscie");
        exitdialog.setHeaderText("Czy chcesz zakończyć pracę Aplikacji");
        Optional<ButtonType> result = exitdialog.showAndWait();
        return result;

    }

    public static Optional<ButtonType> confirmDialog(CashRegisterFx cashRegisterFx){

        Alert confirmdialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmdialog.setTitle("Potwierdzenie Przeglądu");
        confirmdialog.setHeaderText("Czy potwierdzasz zrobienie przeglądu dla kasy " + cashRegisterFx.getModelfx() + " o numerze seryjnym " + cashRegisterFx.getSrialnumberFX());
        Optional<ButtonType> result = confirmdialog.showAndWait();
        return result;

    }




}
