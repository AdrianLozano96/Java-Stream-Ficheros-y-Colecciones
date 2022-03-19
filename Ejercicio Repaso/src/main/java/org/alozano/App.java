package org.alozano;

import org.alozano.io.Lectura1;
import org.alozano.io.LeerEscribirFichero;
import org.alozano.model.Csv;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //LeerEscribirFichero read = new LeerEscribirFichero();
        //read.leerArchivo("calidad_aire_estaciones.csv");
        //read.toString();
        //read.mostrar();
        Lectura1 lee = new Lectura1();
        //lee.leerArchivo("calidad_aire_estaciones.csv");
        //lee.ver();
        lee.lecturas("calidad_aire_estaciones.csv");
    }
}
