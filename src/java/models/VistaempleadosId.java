package models;
// Generated 03-mar-2021 15:58:02 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * VistaempleadosId generated by hbm2java
 */
public class VistaempleadosId  implements java.io.Serializable {


     private String apellido;
     private BigDecimal anual;
     private String oficio;
     private String fechaalta;
     private String departamento;
     private String localidad;

    public VistaempleadosId() {
    }

    public VistaempleadosId(String apellido, BigDecimal anual, String oficio, String fechaalta, String departamento, String localidad) {
       this.apellido = apellido;
       this.anual = anual;
       this.oficio = oficio;
       this.fechaalta = fechaalta;
       this.departamento = departamento;
       this.localidad = localidad;
    }
   
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public BigDecimal getAnual() {
        return this.anual;
    }
    
    public void setAnual(BigDecimal anual) {
        this.anual = anual;
    }
    public String getOficio() {
        return this.oficio;
    }
    
    public void setOficio(String oficio) {
        this.oficio = oficio;
    }
    public String getFechaalta() {
        return this.fechaalta;
    }
    
    public void setFechaalta(String fechaalta) {
        this.fechaalta = fechaalta;
    }
    public String getDepartamento() {
        return this.departamento;
    }
    
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public String getLocalidad() {
        return this.localidad;
    }
    
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }




}


