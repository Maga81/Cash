package mojprogram.elkosz.controllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mojprogram.elkosz.modelFX.CompanyFx;
import mojprogram.elkosz.modelFX.CompanyListModel;
import org.omg.CORBA.portable.ApplicationException;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Dany on 2017-07-31.
 */
public class CompanyListController {

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

    @FXML
    private TableColumn<CompanyFx, CompanyFx > delcompany;
    @FXML
    private TableColumn<CompanyFx, CompanyFx > editionColumn;

    private CompanyListModel companyListModel;



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
        this.phonecolumn.setCellValueFactory(cellData -> cellData.getValue().phonenumberfxProperty());
        this.delcompany.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));
        this.editionColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));

        this.delcompany.setCellFactory(param -> new TableCell<CompanyFx, CompanyFx>(){
            Button button = createButton("/icons/if_close_1348638.png");
            @Override
            protected void updateItem(CompanyFx item, boolean empty) {
                super.updateItem(item, empty);

                if(empty){
                    setGraphic(null);
                    return;
                }

                if(!empty){
                    setGraphic(button);
                    button.setOnAction(event -> {try {
                        try {
                            companyListModel.deleteCompany(item);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } catch (ApplicationException e) {
                        e.printStackTrace();
                    }

                    });
                }

            }
        });

        this.editionColumn.setCellFactory(param -> new TableCell<CompanyFx, CompanyFx>(){
            Button button = createButton("/icons/if_325-Document_1_2124304.png");
            @Override
            protected void updateItem(CompanyFx item, boolean empty) {
                super.updateItem(item, empty);

                if(empty){
                    setGraphic(null);
                    return;
                }

                if(!empty){
                    setGraphic(button);
                    button.setOnAction(event -> {
                        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/EditListofCompany.fxml"));
                       Pane pane = null;
                        try {
                            pane = loader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        EditListCompanyController controller = loader.getController();
                        controller.getCompanyModel().setCompanyFxObjectProperty(item);
                        controller.bindings();
                        Stage stage = new Stage();
                        Scene scene = new Scene(pane);
                        stage.setScene(scene);
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.showAndWait();

                    });
                }

            }
        });



    }

    private Button createButton(String path){
        Button button = new Button();
        Image image = new Image(this.getClass().getResource(path).toString());
        ImageView imageView = new ImageView(image);
        button.setGraphic(imageView);
        return  button;
    }

}
