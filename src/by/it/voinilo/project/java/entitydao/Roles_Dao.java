package by.it.voinilo.project.java.entitydao;



import by.it.voinilo.project.java.beans.Roles;
import by.it.voinilo.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Roles_Dao extends AbstractDao implements interfaceDao<Roles> {
    @Override
    public boolean create(Roles roles) throws SQLException {
        String sql = String.format("INSERT INTO `roles`(`role`) " +
                "VALUES ('%s');", roles.getRole());
        int generatedKeys = (int) executeCreate(sql);
        if (generatedKeys > 0) {
            roles.setId(generatedKeys);
        }
        return generatedKeys > 0;
    }

    @Override
    public Roles read(int id) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `roles` " +
                    "WHERE `id`= %d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Roles(
                        resultSet.getLong("id"),
                        resultSet.getString("role"));
            }
            return null;
        }
    }

    @Override
    public boolean update(Roles role) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                    "UPDATE `roles` SET " +
                            "`role`='%s' WHERE `id` = %d",
                    role.getRole(), role.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }

    @Override
    public boolean delete(Roles role) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("DELETE FROM `roles` WHERE `id` = %d",
                    role.getId());
            return (statement.executeUpdate(sql) == 1);
        }
    }
@Override
    public List<Roles> getALL() throws SQLException {
        return getALL("");
    }

    @Override
    public List<Roles> getALL(String WHERE) throws SQLException {
        List<Roles> roles = new ArrayList<>();
        String sql = "SELECT * FROM roles " + WHERE + " ;";
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Roles role = new Roles();

                role.setId(resultSet.getLong("id"));
                role.setRole(resultSet.getString("role"));
                roles.add(role);
            }
            return roles;
        }
    }
}



