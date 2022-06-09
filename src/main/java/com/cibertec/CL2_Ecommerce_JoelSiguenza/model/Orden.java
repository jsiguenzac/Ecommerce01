package com.cibertec.CL2_Ecommerce_JoelSiguenza.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "orden")
public class Orden implements Serializable{
    
    private static final long serialVersionUID = 1L;
     
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long idOrden;
     
     private String numero;
     private Date fechaCreacion;
     private Date fechaRecibida;
     private double total;
    
 
}
