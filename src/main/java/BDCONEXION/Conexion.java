package BDCONEXION;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {

    // Variables de configuración de la base de datos
    public String db = "gestion_destajeros";
    public String url = "jdbc:mysql://localhost:3306/" + db; // Incluye el puerto 3306
    public String user = "root";
    public String pass = "root";

    // Método para conectar a la base de datos MySQL usando el driver
    public Connection Conectar() {
        Connection link = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            link = DriverManager.getConnection(url, user, pass);
            System.out.println("CONECION OK");
        } catch (Exception e) {
            e.printStackTrace();
           // JOptionPane.showMessageDialog(null, e);
        }
        return link;
    }
    
    public static void main(String[] args) {
        Conexion cn = new Conexion();
        cn.Conectar();
    }
}

    
    
    
    
    

