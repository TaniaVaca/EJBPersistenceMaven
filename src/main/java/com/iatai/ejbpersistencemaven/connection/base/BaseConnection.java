/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iatai.ejbpersistencemaven.connection.base;

import com.iatai.ejbpersistencemaven.persistence.dao.utils.enums.JdbcEnum;
import com.iatai.ejbpersistencemaven.utils.properties.ConfigProperties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Tania Alexandra Vaca
 */
public class BaseConnection {
    
    public Connection BaseConnection(String fileProperty, String driverConnection){
        Connection conn = null;
        
        try {
            Properties prop;
            ConfigProperties configProperties = new ConfigProperties();
            prop = configProperties.getProperties(fileProperty);
            try{
                Class.forName(configProperties.getConfigProperty(driverConnection).toString());
            }catch (ClassNotFoundException e){
                Logger.getLogger(BaseConnection.class.getName()).log(Level.SEVERE, " Error class not fount exception for driver connection", e);
            }
            conn = DriverManager.getConnection(prop.getProperty(JdbcEnum.JDBC_URL.toString()), prop.getProperty(JdbcEnum.JDBC_USERNAME.toString()), prop.getProperty(JdbcEnum.JDBC_PASSWORD.toString()));
            conn.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(BaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    
}
