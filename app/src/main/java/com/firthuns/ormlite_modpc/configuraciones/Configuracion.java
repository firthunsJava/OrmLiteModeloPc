package com.firthuns.ormlite_modpc.configuraciones;

public class Configuracion {

    // Para el constructor super del Helper
    public static final int DB_VERSION = 3;
    public static final String DB_NAME = "ordenadores.db";
    /*Ojo!!! posteriormente a finalizar el ejericcio, siendo totalmente funcional
    * hemos añadido un atributo nuevo 'precio' a nuestra clase
    * por tanto hemos realizado modificaciones oportunas en:
    * -  la clase ordendado
    * - en el OrdendanoresHelpers
    * - faltaría en el adapter y Main, y en el CRUD
    *------------
    * y POR TANTO AQUI HEMOS PASADO DE LA db_version = 3 al 4
    * */
}
