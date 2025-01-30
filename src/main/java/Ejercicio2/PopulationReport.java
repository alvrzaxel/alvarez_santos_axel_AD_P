package Ejercicio2;

import util.Console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PopulationReport {
    
    // Configuración para la conexión a la base de datos
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/dbworld";
    private static final String USERNAME = "root"; // Usuario de la base de datos
    private static final String PASSWORD = "secret"; // Contraseña del usuario
    
    public static void main(String[] args) {
        
        // Establece la conexión con la base de datos
        try(Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            
            String pais = Console.readString("Introduce el nombre del país: ");
            
            // Imprime la cabecera de la tabla
            printHeader();
            
            String idCountry = "";
            String queryCountry = "SELECT Code FROM country WHERE Name = ?";
            
            PreparedStatement pstmt = conn.prepareStatement(queryCountry);
            pstmt.setString(1, pais);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) { // Si hay resultados
                    idCountry = rs.getString(1);
                    
                    if (!idCountry.isEmpty()) {
                        
                        String queryCity = "SELECT * FROM city WHERE CountryCode = ?";
                        PreparedStatement pstmtCity = conn.prepareStatement(queryCity);
                        pstmtCity.setString(1, idCountry);
                        
                        ResultSet rsdos = pstmtCity.executeQuery();
                        while (rsdos.next()) {
                            int population = rsdos.getInt("Population");
                            String city = rsdos.getString("Name");
                            
                            System.out.printf("%-50s %s", city, population + "\n");
                        }
                    }
                }
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void printHeader() {
        // Ancho total de la tabla
        int totalWidth = 80;
        String separator = "-".repeat(totalWidth); // Línea separadora
        
        System.out.printf("%-50s %s", "Ciudad", "Población" + "\n");
        System.out.println(separator);
    }
}
