package org.alozano.io;

import lombok.Data;
import org.alozano.model.Csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.StringTokenizer;

@Data
public class LeerEscribirFichero {
    //String[]contenidoR;
    private ArrayList<String> miArray = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();
    private ArrayList<Csv> miCsv = new ArrayList<>();

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
                br = new BufferedReader(new FileReader(archivoR));
                String fila = br.readLine();
                String contenidos;
                String[] contenido; //Para guardar el contenido
                while ((fila = br.readLine()) != null){ //Mientras exista contenido por leer
                    //System.out.println(fila); //Muestra el contenido
                    contenido = fila.split(";");   //Guardame en un array la lectura separandomela por ;
                    //contenidoR = fila.split(";");
                    //System.out.println(contenido);

                    StringTokenizer tk = new StringTokenizer(fila,";");
                    while(tk.hasMoreTokens()){
                        miArray.add(tk.nextToken());
                        //sb.append(tk.nextToken());
                    }






                    //miArray.add();
                    //sb.append();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Archivo no encontrado");
        }

    }

    public void mostrar(){
        //System.out.println(sb);
        //System.out.println(miArray);
        System.out.println(miCsv);
    }
}
