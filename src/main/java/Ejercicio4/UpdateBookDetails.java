package Ejercicio4;

import Ejercicio4.entities.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Console;
import util.HibernateUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UpdateBookDetails {
    
    public static void main(String[] args) {
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null; // Variable para gestionar la transacción
            
            int id = Console.readInt("Introduce el ID del libro: ");
            String titulo = Console.readString("Introduce el título del libro: ");
            //LocalDate fecha = LocalDate.parse(Console.readString("Introduce la fecha (YYY-MM-DD)"));
            
            transaction = session.beginTransaction();
            
            Book book = session.get(Book.class, id);
            book.setTitle(titulo);
            
            transaction.commit();
            System.out.println("Detalles del libro actualizados correctamente");
            System.out.println("- Título: " + titulo);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


