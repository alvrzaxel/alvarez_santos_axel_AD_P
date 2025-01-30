package Ejercicio4;

import Ejercicio4.entities.Author;
import Ejercicio4.entities.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.time.LocalDate;

public class CreateAuthorWithBooks {
    
    public static void main(String[] args) {
        
        
        // Abre una sesión de Hibernate para interactuar con la base de datos
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null; // Variable para gestionar la transacción
            
            try {
                // Inicia una transacción para realizar operaciones en la base de datos
                transaction = session.beginTransaction();

                Author author = createAuthor();
                
                Book book = createBook("Mi primer libro", LocalDate.now(), "Horror", author);
                Book book2 = createBook("Mi segundo libro", LocalDate.now(), "Humor", author);
                
                session.persist(author);
                session.persist(book);
                session.persist(book2);
                transaction.commit();
                
                System.out.println("Autor y libros creados correctamente");
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    private static Author createAuthor() {
        return new Author("Axel", "Alvarez", LocalDate.now(),"Spain");
    }
    private static Book createBook(String title, LocalDate date, String genre, Author author) {
        return new Book(title, date, genre, author);
    }
}
