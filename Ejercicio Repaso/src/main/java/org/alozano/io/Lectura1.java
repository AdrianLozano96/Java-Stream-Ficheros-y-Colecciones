package org.alozano.io;

import org.alozano.model.Csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lectura1 {
    //String[]contenidoR;
    private ArrayList<String> miArray = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();
    private ArrayList<Csv> miCsv = new ArrayList<>();   //Lista donde almacenar los objetos

    public void leerArchivo(String nombre){
        //Creación de variables
        File archivoR;
        BufferedReader br;
        String direccion = System.getProperty("user.dir")+File.separator+"data"+File.separator+nombre;

        Path path = Paths.get(direccion);
        //Para saber si la ubicación del archivo es la correcta
        if(Files.exists(path)){ //Files.exists necesita un tipo Path
            try{
                //Se instancian las variables
                archivoR = new File(direccion);
                br = new BufferedReader(new FileReader(archivoR, Charset.forName("UTF-8")));
                String fila = br.readLine();
                String[] contenido; //Para guardar el contenido
                while ((fila = br.readLine()) != null){ //Mientras exista contenido por leer
                    //System.out.println(fila); //Muestra el contenido
                    contenido = fila.split(";");   //Guardame en un array la lectura separandomela por ;

                    miCsv.add(guardarDatosCsv(contenido)); //Cada fila se guarda en un objeto distinto

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Archivo no encontrado");
        }

    }


    public Csv guardarDatosCsv(String[] datos){
        Csv csv = new Csv();
        csv.setEstacion_codigo(datos[0]);
        csv.setZona_calidad_aire_descripcion(datos[1]);
        csv.setEstacion_municipio(datos[2]);
        csv.setEstacion_fecha_alta(datos[3]);
        csv.setEstacion_tipo_area(datos[4]);
        csv.setEstacion_tipo_estacion(datos[5]);
        csv.setEstacion_subarea_rural(datos[6]);
        csv.setEstacion_direccion_postal(datos[7]);
        csv.setEstacion_coord_UTM_ETRS89_x(datos[8]);
        csv.setEstacion_coord_UTM_ETRS89_y(datos[9]);
        csv.setEstacion_coord_longitud(datos[10]);
        csv.setEstacion_coord_latitud(datos[11]);
        return csv;
    }
    //COMO SE TIENE QUE HACER DE VERDAD
    public List<String> lecturas(String nombre) {
        List<String> nuevaLista =  null;
        String direccion = System.getProperty("user.dir")+File.separator+"data"+File.separator+nombre;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(direccion)));
            nuevaLista = Stream.of(br.readLine().split(";")).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nuevaLista;
    }

    /*
public Csv guardarDatosCsv(String[] datos){
    Csv csv = new Csv(
            .setEstacion_codigo(datos[0])
                .setZona_calidad_aire_descripcion(datos[1])
            .setEstacion_municipio(datos[2])
            .setEstacion_fecha_alta(datos[3])
            .setEstacion_tipo_area(datos[4])
            .setEstacion_tipo_estacion(datos[5])
            .setEstacion_subarea_rural(datos[6])
            .setEstacion_direccion_postal(datos[7])
            .setEstacion_coord_UTM_ETRS89_x(datos[8])
            .setEstacion_coord_UTM_ETRS89_y(datos[9])
            .setEstacion_coord_longitud(datos[10])
            .setEstacion_coord_latitud(datos[11])
            .build();
    return csv;
}

     */

    public void ver(){
        for(Csv datos: miCsv){
            System.out.println(datos);
        }

        //System.out.println(miCsv);
    }




}
