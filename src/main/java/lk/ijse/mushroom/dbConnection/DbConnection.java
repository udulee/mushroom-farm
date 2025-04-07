package lk.ijse.mushroom.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

    public class DbConnection {
        private static DbConnection dbConnection;
        private Connection connection;
        private DbConnection() throws SQLException {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mushroom;",
                    "root",
                    "1234"
            );
        }

        public static DbConnection getInstance() throws SQLException {
            if (dbConnection==null){
                dbConnection=new DbConnection();
            }
            return dbConnection;
        }

    }
