package com.vrfing.vrfcontroller.INVENTARIO.Controlador.clases;

public class Elementos_inventario_herramientas {

    private String id;
    private String clase;
    private String nombre;
    private String marca;
    private String modelo;
    private String referencia;
    private String capacidad;
    private String cantidad;
    private String estado;
    private String personaACargo;
    private String cedulaPersonaACargo;
    private String descripcion;
    private int foto;

    public Elementos_inventario_herramientas(){

    };

    public Elementos_inventario_herramientas(String id, String clase, String nombre, String marca, String modelo, String referencia, String capacidad, String cantidad, String estado, String personaACargo, String cedulaPersonaACargo, String descripcion, int foto) {
        this.id = id;
        this.clase = clase;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.referencia = referencia;
        this.capacidad = capacidad;
        this.cantidad = cantidad;
        this.estado = estado;
        this.personaACargo = personaACargo;
        this.cedulaPersonaACargo = cedulaPersonaACargo;
        this.descripcion = descripcion;
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPersonaACargo() {
        return personaACargo;
    }

    public void setPersonaACargo(String personaACargo) {
        this.personaACargo = personaACargo;
    }

    public String getCedulaPersonaACargo() {
        return cedulaPersonaACargo;
    }

    public void setCedulaPersonaACargo(String cedulaPersonaACargo) {
        this.cedulaPersonaACargo = cedulaPersonaACargo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
