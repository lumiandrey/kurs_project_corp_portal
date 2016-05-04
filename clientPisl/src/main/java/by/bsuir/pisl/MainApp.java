package by.bsuir.pisl;

import by.bsuir.pisl.controller.ApplicationController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by andrey on 18.04.2016.
 */

public class MainApp extends Application{
    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    ApplicationController controller ;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        controller = (ApplicationController) SpringFXLoader.load("/view/TablePerson.fxml");
        Scene scene = new Scene(controller.getRootLauotl());
        primaryStage.setScene(scene);
        controller.setPrimaryStage(primaryStage);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        controller.getRunn().stop();
        System.exit(0);
    }
}
