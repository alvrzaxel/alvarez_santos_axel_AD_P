package Ejercicio4.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "book")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    // Columna que almacena el nombre del conductor
    @Column(name = "title")
    private String title;
    
    @Column(name = "publication_date")
    private LocalDate publication_date;
    
    @Column(name = "genre")
    private String genre;
    
    @ManyToOne
    @JoinColumn (name = "author_id")
    private Author author;
    
    public Book() {
    
    }
    
    public Book(String title, LocalDate publication_date, String genre, Author author) {
        this.title = title;
        this.publication_date = publication_date;
        this.genre = genre;
        this.author = author;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public LocalDate getPublication_date() {
        return publication_date;
    }
    
    public void setPublication_date(LocalDate publication_date) {
        this.publication_date = publication_date;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public Author getAuthor() {
        return author;
    }
    
    public void setAuthor(Author author) {
        this.author = author;
    }
}




