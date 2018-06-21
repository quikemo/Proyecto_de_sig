/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peliculas;

/**
 *
 * @author fam. moreno
 */
public class Variables {
    String Nombre;
    String Sinopsis;
    String Director;
    String Productora;
    String Genero;
    String Edad;
    String NombreUsuario;
    String Password;

    

    public Variables(String Nombre, String Sinopsis, String Director, String Productora, String Genero, String Edad) {
        this.Nombre = Nombre;
        this.Sinopsis = Sinopsis;
        this.Director = Director;
        this.Productora = Productora;
        this.Genero = Genero;
        this.Edad = Edad;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }

    public String getProductora() {
        return Productora;
    }

    public void setProductora(String Productora) {
        this.Productora = Productora;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

  

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getSinopsis() {
        return Sinopsis;
    }

    public void setSinopsis(String Sinopsis) {
        this.Sinopsis = Sinopsis;
    }
    
    
}
