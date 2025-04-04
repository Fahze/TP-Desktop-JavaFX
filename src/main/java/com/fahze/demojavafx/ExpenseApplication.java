package com.fahze.demojavafx;

import com.fahze.demojavafx.utils.AppPath;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ExpenseApplication extends Application {

    static {
        try {
            AppPath.initialize();
            System.out.println("Logging directory: " + System.getProperty("app.log.dir")); // Debug
        } catch (IOException e) {
            System.err.println("Failed to initialize application directories: " + e.getMessage());
        }
    }

    private static final Logger logger = LoggerFactory.getLogger(ExpenseApplication.class);

    @Override
    public void start(Stage stage) throws IOException {
        logger.info("Lancement de l'application");
        FXMLLoader fxmlLoader = new FXMLLoader(ExpenseApplication.class.getResource("expenseTable.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(ExpenseApplication.class.getResource("css/style.css").toExternalForm());
        stage.setTitle("Tableau de dépenses");
        stage.setScene(scene);
        stage.show();

        if(dbStatus){
            logger.info("Base de donnée detecté");
        }else {
            logger.error("CONNEXION SQL IMPOSSIBLE !!!!");
            throw new Error("Connexion SQL IMPOSSIBLE");
        }

    }

    public boolean dbStatus = Database.isOK();

    public static void main(String[] args) {
        Application.launch(args);
    }
}