package br.com.valdirsillva.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

    private static ConnectionManager instance;

    private final static String driver = "com.mysql.cj.jdbc.Driver";
    private final static String user = "MasterDB";
    private final static String password = "";
    private final static String url = "jdbc:mysql://localhost:3306/db_products";

    // Construtor privado
    private ConnectionManager() {
    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            // Interface JDBC cuja implementação DriverManager abre uma conexão com
            // a Url definida para acesso ao banco de dados
            connection = DriverManager.getConnection(url, user, password);

            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("printTrace /n");
            e.printStackTrace();
        }
        return connection;
    }
}
