package com.firthuns.ormlite_modpc.modelos;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ordenadores") // dando nombre a la tabla
public class Ordenador {
//hemos creado el modelo de datos sin pensar que iba a necesitar una clave primaria, SOLUCION:
//    SE LA CREAMOS NOSOTROS AHORA, SENSE PEGUES, y lo gestionara el ORM
//    NO HACIENDO FALTA SU INCLUSION EN EL CONSTRUCTOR PERO SI EN LOS METODOS GETTERS Y SETTERS

    @DatabaseField(generatedId = true, columnName = "id_ordenador") // autoincremental
    private int id;
    @DatabaseField(canBeNull = false)   // Campo obligatorio
    private String marca;
    @DatabaseField(canBeNull = false)   // Campo obligatorio
    private String modelo;
    @DatabaseField()
    private int ram;
    @DatabaseField(canBeNull = false, defaultValue = "0")
    private float hd;
    /* una vez realizado to.do el proyecto y funciando decidimos posteriormente añadir otro atributo/
     ojo!! estos cambios los tienes que reflejar en las demas claSES AFECTADAS
         */
    @DatabaseField(canBeNull = false,  defaultValue = "0")
    private  float precio;

/* muy importante crear un constructor vacío para que el ORMLITE puede crear los objetos que necesite
    los metodos get setters, tienen que cumplir el nombre conforme se generan automaticamente
-----------------
    */

    public Ordenador() {
    }

    public Ordenador(String marca, String modelo, int ram, float hd, float precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.ram = ram;
        this.hd = hd;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public float getHd() {
        return hd;
    }

    public void setHd(float hd) {
        this.hd = hd;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
