package javaSemester_Projects.lab10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private Properties properties;
    private static final String DEFAULT_PROPERTIES_PATH = "default.properties";
    private static final String USER_PROPERTIES_PATH = "user.properties";

    PropertyManager (){
        properties= new Properties();

        try{
            properties.load(new FileReader(DEFAULT_PROPERTIES_PATH)); // Read file propertie

            properties.load( new FileReader( USER_PROPERTIES_PATH));

        }catch (FileNotFoundException fileNotFoundException){
            System.out.println(fileNotFoundException);
        }catch (IOException ioException ){
            System.out.println(ioException);
        }


    }
}
