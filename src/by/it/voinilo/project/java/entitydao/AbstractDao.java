package by.it.voinilo.project.java.entitydao;

import by.it.voinilo.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDao{
    static long executeCreate(String sql) throws SQLException {
        System.out.println(sql);
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {


            if (statement.executeUpdate(sql,
                    Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {


                    return (int) generatedKeys.getLong(1);
                }
            }

            return -1;
        }
    }


    static boolean executeUpdate(String sql) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {


            return (statement.executeUpdate(sql)>0);
        }
    }
}
