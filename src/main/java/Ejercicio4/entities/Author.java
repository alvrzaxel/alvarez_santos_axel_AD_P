package Ejercicio4.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "author")
public class Author {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    // Columna que almacena el nombre del conductor
    @Column(name = "first_name")
    private String name;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "birth_date")
    private LocalDate birthdate;
    
    @Column(name = "nationality")
    private String nationality;
    
    public Author() {
    
    }
    
    public Author(String name, String lastName, LocalDate birthdate, String nationality) {
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.nationality = nationality;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public LocalDate getBirthdate() {
        return birthdate;
    }
    
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
}
