package Ejercicio4;

import Ejercicio4.entities.Author;
import Ejercicio4.entities.Book;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;
import java.util.List;

public class ListBooksByAuthor {
    
    public static void main(String[] args) {
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            List<Author> autores = getAuthor(session);
            
            List<Book> books = getBooks(autores.getFirst().getId(), session);
            
            for (Book b : books) {
                System.out.print("- " + b.getTitle());
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static List<Author> getAuthor(Session session) {
        String query = "FROM Author WHERE name = 'Axel'";
        
        Query<Author> createQuery = session.createQuery(query, Author.class);
        return createQuery.getResultList();
    }
    
    private static List<Book> getBooks(int id, Session session) {
        String query = "FROM Book b WHERE b.author = " + id;
        
        Query<Book> createQuery = session.createQuery(query, Book.class);
        return createQuery.getResultList();
        
    }
}
