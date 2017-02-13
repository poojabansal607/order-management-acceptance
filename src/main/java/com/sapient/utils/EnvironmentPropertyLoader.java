package com.sapient.utils;

import java.net.URL;
import java.nio.file.Paths;

public class EnvironmentPropertyLoader {

    private static final String QA1_RESOURCE_PATH = "environment/qa1.properties";
    private static final String QA2_RESOURCE_PATH = "environment/qa2.properties";

    private String getEnvironment(){
        return System.getProperty("env");
    }

    public PropertiesFileUtils getPropertyFileUtils() throws Exception {
        String environment = getEnvironment();
        String environmentResourcePath = QA1_RESOURCE_PATH;
        if(environment.equalsIgnoreCase("qa2")){
            environmentResourcePath = QA2_RESOURCE_PATH;
        }
        URL resource = this.getClass().getClassLoader().getResource(environmentResourcePath);
        Paths.get(resource.toURI()).toFile();
        PropertiesFileUtils propertiesFileUtils = new PropertiesFileUtils(Paths.get(resource.toURI()).toFile().getPath());
        return propertiesFileUtils;
    }

    public static void main(String[] args) throws Exception{
        EnvironmentPropertyLoader environmentPropertyLoader = new EnvironmentPropertyLoader();
        environmentPropertyLoader.getPropertyFileUtils();
    }
}
