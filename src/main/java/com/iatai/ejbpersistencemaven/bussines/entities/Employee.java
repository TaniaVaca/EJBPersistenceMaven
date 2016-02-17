/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iatai.ejbpersistencemaven.bussines.entities;

import com.iatai.ejbpersistencemaven.bussines.base.BaseEntity;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Tania Alexandra Vaca
 */
@Entity
@Table(name = "employee")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id"),
    @NamedQuery(name = "Employee.findByName", query = "SELECT e FROM Employee e WHERE e.name = :name"),
    @NamedQuery(name = "Employee.findBySalary", query = "SELECT e FROM Employee e WHERE e.salary = :salary")})
public class Employee extends BaseEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "name")
    private String name;
    @Column(name = "salary")
    private Integer salary;
    @JoinColumn(name = "departmentid", referencedColumnName = "id")
    @ManyToOne
    private Department departmentid;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Department getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Department departmentid) {
        this.departmentid = departmentid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iatai.ejbpersistencemaven.bussines.entities.Employee[ id=" + id + " ]";
    }
    
}
