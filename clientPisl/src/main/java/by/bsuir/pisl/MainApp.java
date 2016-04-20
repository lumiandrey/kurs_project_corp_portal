package by.bsuir.pisl;

import by.bsuir.pisl.controller.ApplicationController;
import by.bsuir.pisl.model.entity.PersonPisl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by andrey on 18.04.2016.
 */

public class MainApp extends Application{
    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        ApplicationController controller = (ApplicationController) SpringFXLoader.load("/view/TablePerson.fxml");
        Scene scene = new Scene(controller.getRootLauotl());
        primaryStage.setScene(scene);
        controller.setPrimaryStage(primaryStage);
        primaryStage.show();
    }
}
