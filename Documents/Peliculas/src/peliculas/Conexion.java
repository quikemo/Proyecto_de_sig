
package peliculas;

//Recuerde importar la biblioteca de conexión
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {
    
    private final String url = "jdbc:mysql://localhost:3306/clasificacion_peliculas";
    private final String login = "root"; //Administrador de MySQL
    private final String password = "rmd0623rabano";
    private Connection cnx = null;
    private Statement sttm = null;
    private ResultSet rst = null;
    //método para Update, Insert, Delete
    public void UID(String sql) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(url, login, password);
            sttm = cnx.createStatement();
            sttm.executeUpdate(sql); //statement
        } catch (ClassNotFoundException | SQLException c) {
            JOptionPane.showMessageDialog(null, "ERROR: " + c.getMessage());
            System.exit(1); //salir de aplicación
        }
    }

    //Método para Consultar
    public ResultSet getValores(String sql) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(url, login, password);
            sttm = cnx.createStatement();
            rst = sttm.executeQuery(sql);  //resultset
        } catch (ClassNotFoundException | SQLException c) {
            JOptionPane.showMessageDialog(null, "ERROR: " + c.getMessage());
            System.exit(1);
        } 
        return rst;
    }
}

