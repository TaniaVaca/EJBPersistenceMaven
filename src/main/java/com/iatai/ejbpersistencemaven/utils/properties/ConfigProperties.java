/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iatai.ejbpersistencemaven.utils.properties;

import com.iatai.ejbpersistencemaven.persistence.dao.implement.EmployeeDaoImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;
import java.util.logging.Level;

/**
 *
 * @author Tania Alexandra Vaca
 */
public class ConfigProperties {

    public static Properties configProperties;
    
    public Properties getProperties(String nameFile) {
         InputStream is = null;
        try {
            this.configProperties = new Properties();
            is = this.getClass().getResourceAsStream("/properties/"+nameFile);
            configProperties.load(is);
        } catch (FileNotFoundException e) {
            java.util.logging.Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            java.util.logging.Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return configProperties;
    }
    /**
     * Gets the config property.
     *
     * @param key the key
     * @return the config property
     */
    public static String getConfigProperty(String key){
        String valueKey;
        valueKey = configProperties.getProperty(key);
        if(valueKey==null){
            Logger.getRootLogger().fatal("Cannot get the properties");
            return null;
        }else{
            return configProperties.getProperty(key);   
        }
    }
}
