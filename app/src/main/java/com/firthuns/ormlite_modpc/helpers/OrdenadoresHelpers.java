package com.firthuns.ormlite_modpc.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.firthuns.ormlite_modpc.configuraciones.Configuracion;
import com.firthuns.ormlite_modpc.modelos.Ordenador;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class OrdenadoresHelpers  extends OrmLiteSqliteOpenHelper {

//    Clase especial que necesita heredar del ORM

//    TERCER PASO-------------------
    // Atributo DAO que va a trabajar sobre la clase Ordenador y su PK será int
// si tuvieramos 12 tablas, necesitariamos 12 DAO diferentes.
    private Dao<Ordenador, Integer> daoOrdenador;
    // (necesario su getter), sobre 'daoOrdenador', segundo boton raton y create getter for daoOrdenador

    public Dao<Ordenador, Integer> getDaoOrdenador() throws SQLException {

        if (daoOrdenador == null){
                daoOrdenador = this.getDao(Ordenador.class);
                // le agregamos una excepcion throws... para que sea la funcion que llama
            // a esta función sea la que lo  gestione
        }
        return daoOrdenador;
    }



// PRIMERO PASO
    public OrdenadoresHelpers(Context context) {
        super(context, Configuracion.DB_NAME, null  , Configuracion.DB_VERSION);
        // factory, lo dejaremos a null, ya que si necesitamos realizar algo lo haremos en el onCreate

    }

    // SEGUNDO PASO
    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
    // se llamara cuando la base de datos no exista
        // Crea la tabla en base a la clase Ordenador
        try {
            TableUtils.createTable(connectionSource, Ordenador.class);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource,
                          int oldVersion, int newVersion) {
// metodo  solo se llamara si se ha modificado nuestro modelo de datos: Añadir mas atributos
        // Para cumplir con todos los cambios y solucionar errores en usuarios que pasen
        // de la versión 1 a la 3, la 2 a la 5 etc
        // ejemplo que añadiremos un atributo precio a nuestro modelo
        // y el cambio lo marca, en nuestra clase configuracion, modificando la version
        if (oldVersion < 4){
            try {
                getDaoOrdenador().executeRaw("alter table ordenadores add column precio float not null default 0 ");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }





}
