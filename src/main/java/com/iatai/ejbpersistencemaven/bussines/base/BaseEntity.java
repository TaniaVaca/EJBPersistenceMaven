/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iatai.ejbpersistencemaven.bussines.base;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 *
 * @author Alexandra
 */
@MappedSuperclass
public class BaseEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
