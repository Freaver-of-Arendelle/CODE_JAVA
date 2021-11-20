/**
 * @author Freaver
 * @date 07/11/2021 22:28
 * @description
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private Button okButton;

    @FXML
    void okay(ActionEvent event) {
        System.out.println("hello");
    }

}
