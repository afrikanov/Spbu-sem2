package group144.afrikanov;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/group144.afrikanov/sample.fxml"));
        primaryStage.setTitle("Slider and ProgressBar");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMinHeight(200);
        primaryStage.setMinWidth(200);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
