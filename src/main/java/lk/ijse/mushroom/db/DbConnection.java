package lk.ijse.mushroom.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
