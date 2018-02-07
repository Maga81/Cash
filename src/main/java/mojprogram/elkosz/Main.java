package mojprogram.elkosz;

/**
 * Created by Dany on 2018-02-05.
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mojprogram.elkosz.database.dbutils.DbManager;




/**
 * Created by Dany on 2017-07-03.
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainFrame.fxml"));
        BorderPane borderPane = loader.load();
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(e->{
            System.out.print("Koniec");
            Platform.exit();
        });

        primaryStage.setTitle("Program ELKOSZ");
        primaryStage.show();


        DbManager.initDatabase();

    }


}
