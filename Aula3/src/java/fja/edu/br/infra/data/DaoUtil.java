
package fja.edu.br.infra.data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class DaoUtil {
    
    private Connection cx = null;
    
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if(cx == null) {
            // cria conexão
            //String url = "jdbc:mysql://localhost:3306/quarentena?zeroDateTimeBehavior=convertToNull [root em Esquema default]";
            String url = "jdbc:mysql://localhost:3306/quarentena?useTimezone=true&serverTimezone=UTC";
            String psw = "123456789";
            String usr = "root";
            //String drv = "com.mysql.jdbc.Driver";
            String drv = "com.mysql.cj.jdbc.Driver";
            
            Class.forName(drv);
            
            cx = DriverManager.getConnection(url, usr, psw);
        }   
        return cx;
    }
    
    public void getFechaConnection() throws SQLException {
        if(cx != null) {
            this.cx.close();
            this.cx = null;
        }
    }
    
    public Statement geStatement() throws ClassNotFoundException, SQLException {
        return this.getConnection().createStatement();
    }
    
    public PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException {
        return this.getConnection().prepareStatement(sql);
    }
}
