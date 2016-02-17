/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iatai.ejbpersistencemaven.persistence.dao.implement;

import com.iatai.ejbpersistencemaven.bussines.entities.Department;
import com.iatai.ejbpersistencemaven.exceptions.InfraestructureException;
import com.iatai.ejbpersistencemaven.persistence.dao.base.BaseDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Tania Alexandra Vaca
 */
@Repository
public class DeparmentDaoImpl extends BaseDao<Department> implements Serializable{
    public static int contador = 0;
    public List<Department> departments = new ArrayList<Department>();
    public long time_incio, time_fin;
    public Department department = new Department();

    public DeparmentDaoImpl() {
        super("MyAppBD-iatai");
    }
    
    public List<Department> getDepartmentsList(){
        try {
            departments = (List<Department>) this.readEntitiesList(new Department());
            for(Department dep: departments){
                System.err.println("PRUEABAAA "+dep.getName());
            }
        } catch (InfraestructureException ex) {
            Logger.getLogger(DeparmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departments;
    }
}
