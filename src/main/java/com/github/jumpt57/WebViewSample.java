package com.github.jumpt57;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class WebViewSample extends Application {

    @Override
    public void start(Stage stage) {
        // create the scene
        stage.setTitle("Web View");
        Scene scene = new Scene(new Browser(), 750, 500, Color.web("#666970"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
