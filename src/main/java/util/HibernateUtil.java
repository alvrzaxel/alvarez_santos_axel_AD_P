/**************************************************
 * Autor: Axel Álvarez Santos
 * Fecha: 21/12/2024
 * Tarea: AD04 Tarea Evaluativa 01
 **************************************************/

package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase utilitaria para gestionar la configuración y el ciclo de vida de Hibernate
 * Proporciona una instancia de SessionFactory para manejar las sesiones con la base de datos
 */
public class HibernateUtil {
    // Instancia de la fábrica de sesiones Hibernate
    private static SessionFactory sessionFactory;
    
    // Bloque estático, se ejecuta una sola vez cuando la clase es cargada
    static {
        try {
            // Inicialización de la fábrica de sesiones con la configuración de Hibernate
            sessionFactory = new Configuration() // Crea una nueva instancia de Configuration
                    .configure("hibernate.cfg.xml") // Configura Hibernate a partir de un archivo de configuración XML
                    .buildSessionFactory(); // Construye y obtiene la SessionFactory
                
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al inicializar Hibernate");
        }
    }
    
    /**
     * Obtiene la fábrica de sesiones de Hibernate
     * Proporciona acceso a la instancia de SessionFactory para gestionar las sesiones
     * @return La instancia de SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory; // Devuelve la instancia de la fábrica de sesiones Hibernate
    }
    
    /**
     * Cierra la fábrica de sesiones de Hibernate
     */
    public static void shutdown() {
        // Verifica si la sesión está activa y no está cerrada
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            getSessionFactory().close(); // Cierra la fábrica de sesiones
        }
    }
}
