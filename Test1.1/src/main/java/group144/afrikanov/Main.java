package group144.afrikanov;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {

    private final int N = 4;

    /* Array of buttons that realizes the field */
    private Button buttons[][] = new Button[N][N];

    /* Values of the buttons on the field */
    private int values[][] = new int[N][N];

    private int alreadyTapped = 0;
    private int[] x = new int[2];
    private int[] y = new int[2];
    private ArrayList<Pair> coordinates = new ArrayList<>();
    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                coordinates.add(new Pair(i, j));
            }
        }
        int positionValue = 0;
        for (int i = 0; i * 2 < N * N; ++i) {
            if (coordinates.size() == 1) {
                coordinates.remove(0);
                continue;
            }
            int firstCoordinatesPosition = random.nextInt(coordinates.size());
            values[coordinates.get(firstCoordinatesPosition).first][coordinates.get(firstCoordinatesPosition).second] = positionValue;
            coordinates.remove(firstCoordinatesPosition);
            int secondCoordinatesPosition = random.nextInt(coordinates.size());
            while (firstCoordinatesPosition == secondCoordinatesPosition) {
                secondCoordinatesPosition = random.nextInt(coordinates.size());
            }
            values[coordinates.get(secondCoordinatesPosition).first][coordinates.get(secondCoordinatesPosition).second] = positionValue;
            coordinates.remove(secondCoordinatesPosition);
            positionValue++;
            positionValue %= 2;
        }
        x[0] = -1;
        y[0] = -2;
        x[1] = -3;
        y[1] = -4;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                buttons[i][j] = new Button();
                buttons[i][j].setTranslateX(32 * i);
                buttons[i][j].setTranslateY(32 * j);
                buttons[i][j].setPrefWidth(30);
                buttons[i][j].setPrefHeight(30);
                root.getChildren().addAll(buttons[i][j]);
                final int iFinal = i, jFinal = j;
                buttons[i][j].setOnAction(event -> {
                    if (alreadyTapped == 0) {
                        x[alreadyTapped] = iFinal;
                        y[alreadyTapped] = jFinal;
                    }
                    else {
                        if (x[0] != iFinal || y[0] != jFinal) {
                            x[alreadyTapped] = iFinal;
                            y[alreadyTapped] = jFinal;
                        }
                        else {
                            return;
                        }
                    }
                    if (alreadyTapped == 1) {
                        if (values[x[0]][y[0]] == values[x[1]][y[1]]) {
                            buttons[x[0]][y[0]].setText(String.valueOf(values[x[0]][y[0]]));
                            buttons[x[1]][y[1]].setText(String.valueOf(values[x[0]][y[0]]));
                            buttons[x[0]][y[0]].setDisable(true);
                            buttons[x[1]][y[1]].setDisable(true);
                        }
                        x[0] = -1;
                        y[0] = -2;
                        x[1] = -3;
                        y[1] = -4;
                        alreadyTapped = -1;
                    }
                    ++alreadyTapped;
                });
            }
        }
        primaryStage.setHeight(50 * N);
        primaryStage.setWidth(40 * N);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
