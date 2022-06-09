package com.cibertec.CL2_Ecommerce_JoelSiguenza.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Data
@Table(name = "detalles")
public class DetalleOrden implements Serializable{
    
    private static final long serialVersionUID = 1L;
     
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long idDetalleOrden;
     
     private String nombre;
     private String cantidad;
     private String precio;
     private String total;
/*
     @OneToOne
     private Orden orden;
     
     @ManyToOne
     private Producto producto;*/
}
