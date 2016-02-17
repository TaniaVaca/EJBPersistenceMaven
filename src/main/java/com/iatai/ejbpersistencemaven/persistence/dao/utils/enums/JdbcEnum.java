/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iatai.ejbpersistencemaven.persistence.dao.utils.enums;

/**
 *
 * @author Tania Alexandra Vaca
 */
public enum JdbcEnum {
     JDBC_DRIVER("JDBC_DRIVER"),JDBC_URL("JDBC_URL"),JDBC_USERNAME("JDBC_USERNAME"),JDBC_PASSWORD("JDBC_PASSWORD"),JDBC_PROCEDURE("JDBC_PROCEDURE"), PROP_FILE_JDBC("jdbc.properties"),PROP_FILE_PROC_EMPL("jdbcProcedureEmpleado.properties");
     
     private final String value;
     
     JdbcEnum(String value){
         this.value = value;
     }
     public String getJdbcEnum(){
         return value;
     }
}
