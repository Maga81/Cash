package mojprogram.elkosz.utils;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * Created by Dany on 2017-09-23.
 */
public class Notyfication {
    private final static String TITLE = "Informacja";
    private final static String MESSEGE = "Dane zostały dodane do bazy danych prawidłowo";



    public static void noty(){
        Image img = new Image("/icons/confirm.png");
        Notifications notifications = Notifications.create()
                .title(TITLE)
                .text(MESSEGE)
                .graphic(new ImageView(img))
                .hideAfter(Duration.seconds(3))
                .position(Pos.BOTTOM_RIGHT);

        notifications.show();
    }
}
