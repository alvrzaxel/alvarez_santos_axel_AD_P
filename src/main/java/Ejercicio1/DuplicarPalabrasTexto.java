package Ejercicio1;

import java.io.*;

public class DuplicarPalabrasTexto {
    
    public static void main(String[] args) {
        // Rutas de los archivos de entrada y salida
        String inputPathFile = "." + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "data.txt";
        // String inputPathFile = "." + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "noexiste.txt";
        String outputPathFile = "." + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "outputdata.txt";
        
        File file = new File(inputPathFile);
        
        if (!file.exists()) {
            System.out.println("Error: El archivo no existe.");
            System.exit(-1);
        }
        
        try (
                // BufferedReader para leer texto de forma eficiente, línea por línea
                BufferedReader bffReader = new BufferedReader(new FileReader(inputPathFile)); // Para leer líneas del archivo de entrada
                // BufferedWriter escribir texto de manera eficiente en el archivo de salida
                BufferedWriter bffWriter = new BufferedWriter(new FileWriter(outputPathFile)) // Para escribir líneas en el archivo de salida
        ) {
            // Variable temporal para almacenar cada línea del fichero
            String inputLine;
            String outputLine = "";
            
            // Lectura línea a línea del fichero de entrada

            while ((inputLine = bffReader.readLine()) != null) {
                String[] words = inputLine.split(" ");
                
                for (String w : words) {
                    for(int i = 0; i < 2; i++) {
                        outputLine += w + " ";
                    }
                }
            }
            
            bffWriter.write(outputLine);
            System.out.println(outputLine);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
