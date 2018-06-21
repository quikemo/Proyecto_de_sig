package peliculas;

//Recuerde importar la biblioteca de conexión
import java.sql.*;
import java.util.ArrayList;

public class Conexion {

    static Connection con = null;
    static Statement sttm = null;
    static ResultSet rst = null;

    public static void conectar() {
        String ruta = "jdbc:mysql://localhost/Clasificacion_peliculas";
        String user = "root";
        String pass = "rmd0623rabano";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(ruta, user, pass);
            sttm = con.createStatement();
            System.out.println("conectado");
        } catch (Exception e) {
            System.out.println("No conectado");
        }
    }

    public static ArrayList<String> llenar_combobox(String tabla, String campo) {
        ArrayList<String> lista = new ArrayList<String>();
        String q = "SELECT * FROM " + tabla;
        try {
            rst = sttm.executeQuery(q);
            System.out.println("Correcto");
        } catch (Exception e) {
            System.out.println("no Correcto");
        }
        try {
            while (rst.next()) {
                lista.add(rst.getString(campo));
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public static String BuscarCombo(String texto, String tabla, String Campo, String Campo2){
        String q = "SELECT * FROM "+tabla+" "+"WHERE "+Campo+"='"+texto+"'";
        String campo = null;
        try {
            rst = sttm.executeQuery(q);
            System.out.println("Dato de combobox guardado");
        } catch (Exception e) {
            System.out.println("no se pudo buscar combobox");
        }
        try {
            if(rst.first()){
                campo = rst.getString(Campo2);
            }
            System.out.println("Se guardo id");
        } catch (Exception e) {
            System.out.println("No se guardo id");
        }
    return campo;
    }
    public static void guardar(Variables x) {
    int IdDirector;
    int IdProduccion;
    int IdGenero;
    
    IdDirector = Integer.parseInt(BuscarCombo(x.getDirector(),"director","Nombre_productor","id_Productor"));
    IdProduccion = Integer.parseInt(BuscarCombo(x.getProductora(),"productora","Nombre_Productora","id_Productora"));
    IdGenero = Integer.parseInt(BuscarCombo(x.getGenero(),"genero","Tipo_de_genero","Cod_Genero"));
        
    
    String q = "INSERT INTO `peliculas` (`Nombre_pelicula`, `id_productor1`, `id_Director1`, `Cod_clasificacion1`, `cod_genero`, `Sinopsis`) VALUES ('"+x.getNombre()+"', '"+IdProduccion+"', '"+IdDirector+"', '"+x.getEdad()+"', '"+IdGenero+"','"+x.getSinopsis()+"')";
        
        ejecutar(q);
        
    }

    private static void ejecutar(String q) {
        try {
            sttm.executeUpdate(q);
            System.out.println("Se hizo la actualizacion");
        } catch (Exception e) {
            System.err.println("No se pudo ingresar datos");
        }
    }

    public static Variables BuscarPeli(String Nombre) {
        Variables resultado = null;
        String q = "SELECT * FROM peliculas "+"WHERE Nombre_pelicula ='"+Nombre+"'";
        try {
           rst = sttm.executeQuery(q);
            System.out.println("Se hizo la consulta");
        } catch (Exception e) {
            System.out.println("No se hizo la consulta");
        }
        resultado = asignar();
        return resultado;
    }
    public static Variables asignar(){
    Variables resultado = null;
    String Nombre = null;
    int Genero = 0;
    int Produccion = 0;
    int Director = 0;
    String Genero1;
    String Produccion1;
    String Director1;
    String Edad = null;
    String Sinopsis = null;
        try {
            if(rst.first()){
                Nombre = rst.getString("Nombre_pelicula");
                Edad = rst.getString("Cod_clasificacion1");
                Genero = Integer.parseInt(rst.getString("cod_genero"));
                Produccion = Integer.parseInt(rst.getString("id_productor1"));
                Director = Integer.parseInt(rst.getString("id_Director1"));
                Sinopsis = rst.getString("Sinopsis");
            }
        } catch (Exception e) {
        }
       Genero1 = Busca("SELECT * FROM genero "+"WHERE Cod_Genero ='"+Genero+"'","Tipo_de_genero");
       Produccion1 = Busca("SELECT * FROM productora "+"WHERE id_productora ='"+Produccion+"'","Nombre_Productora");
       Director1 = Busca("SELECT * FROM director "+"WHERE id_Productor ='"+Director+"'","Nombre_productor");
    resultado = new Variables(Nombre,Sinopsis,Director1,Produccion1,Genero1,Edad);
    return resultado;
    }
    private static String Busca(String q,String Campo2) {
        
         String campo = null;
        try {
            rst = sttm.executeQuery(q);
            System.out.println("Dato de Id guardado");
        } catch (Exception e) {
            System.out.println("no se pudo buscar id");
        }
        try {
            if(rst.first()){
                campo = rst.getString(Campo2);
            }
            System.out.println("Se guardo campo");
        } catch (Exception e) {
            System.out.println("No se guardo campo");
        }
    return campo;
    }

   

}
