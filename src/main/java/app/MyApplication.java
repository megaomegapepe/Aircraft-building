package app;

import javafx.application.Application;
import javafx.stage.Stage;

public class MyApplication extends Application {

    /** Special method for launch JavaFX application **/
    public static void launch(String[] args) {
        Application.launch(args);
    }

    /** Method which will called from launch method first**/
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();
    }
}
