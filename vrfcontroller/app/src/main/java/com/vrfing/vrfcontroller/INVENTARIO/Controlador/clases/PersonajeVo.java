package com.vrfing.vrfcontroller.INVENTARIO.Controlador.clases;

public class PersonajeVo {

    private String nombre;
    private String info;
    private int image;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public PersonajeVo(){

    }

    public PersonajeVo(String nombre, String info, int image) {

        this.nombre = nombre;
        this.info = info;
        this.image = image;
    }
}
