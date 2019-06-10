package group144.afrikanov;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;

public class Controller {

    @FXML
    private Slider slider;

    @FXML
    private ProgressBar progressBar;

    /** Initialization */
    @FXML
    void initialize() {
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.valueProperty().addListener(new ChangeListener<>() {

            /** Method changes value in progress bar when user changes value in slider. */
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                progressBar.setProgress(newValue.doubleValue() / 100);
            }
        });
    }
}
