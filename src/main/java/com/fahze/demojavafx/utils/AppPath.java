package com.fahze.demojavafx.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppPath {

    // Base folder name for the application
    private static final String APP_FOLDER_NAME = ".expense";

    // Subfolder names
    private static final String LOGS_FOLDER = "logs";
    private static final String DATA_FOLDER = "data";
    private static final String CONFIG_FOLDER = "config";

    // Base application path
    private static Path appBasePath;

    /**
     * Initialises les chemins pour l'app
     */
    public static void initialize() throws IOException {
        // Get user's home directory
        String userHome = System.getProperty("user.home");
        appBasePath = Paths.get(userHome, APP_FOLDER_NAME);

        // Create the base directory and subdirectories
        Files.createDirectories(getLogsPath());
        Files.createDirectories(getDataPath());
        Files.createDirectories(getConfigPath());

        // Set system properties for Log4j2
        System.setProperty("app.log.dir", getLogsPath().toString());
    }


    public static Path getLogsPath() {
        return appBasePath.resolve(LOGS_FOLDER);
    }


    public static Path getDataPath() {
        return appBasePath.resolve(DATA_FOLDER);
    }


    public static Path getConfigPath() {
        return appBasePath.resolve(CONFIG_FOLDER);
    }


    public static Path getDatabasePath(String dbName) {
        return getDataPath().resolve(dbName);
    }


    public static Path getConfigFilePath(String configFileName) {
        return getConfigPath().resolve(configFileName);
    }
}