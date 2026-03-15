package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/Hospital";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Net04hack$";


    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL, USER, PASSWORD );
        }catch(Exception e ){
            e.printStackTrace();

        }
        return null;
    }
}
