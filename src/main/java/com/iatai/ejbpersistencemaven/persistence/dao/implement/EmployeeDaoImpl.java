/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iatai.ejbpersistencemaven.persistence.dao.implement;

import com.iatai.ejbpersistencemaven.bussines.entities.Department;
import com.iatai.ejbpersistencemaven.bussines.entities.Employee;
import com.iatai.ejbpersistencemaven.connection.base.BaseConnection;
import com.iatai.ejbpersistencemaven.exceptions.InfraestructureException;
import com.iatai.ejbpersistencemaven.persistence.dao.base.BaseDao;
import com.iatai.ejbpersistencemaven.persistence.dao.utils.enums.JdbcEnum;
import com.iatai.ejbpersistencemaven.persistence.dao.utils.enums.JdbcProcedureEmployeeEnum;
import com.iatai.ejbpersistencemaven.utils.properties.ConfigProperties;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Tania Alexandra Vaca
 */
@Repository
public class EmployeeDaoImpl extends BaseDao<Employee> implements Serializable{
    public static int contador = 0;
    public List<Employee> employees = new ArrayList<Employee>();
    public long time_incio, time_fin;
    public Employee employee = new Employee();

    public EmployeeDaoImpl() {
        super("MyAppBD-iatai");
    }
    
    public List<Employee> getEmployeesList(){
        try {
            employees = (List<Employee>) this.readEntitiesList(new Employee());
        } catch (InfraestructureException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }
    
    /**
    public List<Employee> consultarEmpleados() {
        
        Logger.getLogger("PRUEBA!!!").info("PRUEBAAAAAAA");
        
        try {
            BaseConnection baseConnection = new BaseConnection();
            Connection conn = baseConnection.BaseConnection(JdbcEnum.PROP_FILE_JDBC.getJdbcEnum(), JdbcEnum.JDBC_DRIVER.name());
            Properties prop;
            ConfigProperties configProperties = new ConfigProperties();
            System.err.println("STORE "+JdbcEnum.PROP_FILE_PROC_EMPL.getJdbcEnum());
            prop = configProperties.getProperties(JdbcEnum.PROP_FILE_PROC_EMPL.getJdbcEnum());
            
            System.err.println("STORE2 "+prop.getProperty(JdbcProcedureEmployeeEnum.JDBC_PROCEDURE_LIST.name()));
            
            CallableStatement statement = conn.prepareCall(prop.getProperty(JdbcProcedureEmployeeEnum.JDBC_PROCEDURE_LIST.name()));
            statement.setInt(1, 0);
            statement.setString(2, "");
            statement.setInt(3, 10);
            statement.setInt(4, 0);
            statement.registerOutParameter(5, Types.INTEGER);
            statement.registerOutParameter(6, Types.VARCHAR);
            statement.registerOutParameter(7, Types.VARCHAR);
            statement.registerOutParameter(8, Types.OTHER);
            time_incio = System.currentTimeMillis();
            statement.execute();
            time_fin = System.currentTimeMillis();
            System.out.println("the task has taken: " + (time_fin - time_incio) + " milliseconds");
            System.out.println("Contador : " + statement.getInt(5));
            System.out.println("Codigo : " + statement.getString(6));
            System.out.println("Descripcion : " + statement.getString(7));
                
            if (statement.getInt(5) != 0) {
                ResultSet results = (ResultSet) statement.getObject(8);
                System.out.println("---------");
                while (results.next()) {
                    employee.setId(results.getInt(1));
                    employee.setName(results.getString(2));
                    
//                    employee.setSalary(results.getInt(3));
                    employee.setSalary(250);
                    employees.add(contador, employee);
                    contador++;
                    employee= new Employee();
                }
                results.close();
            }
            for(Employee emp: employees){
                System.err.println("EMPELADO ;"+emp.getName());
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }
    * */

}
