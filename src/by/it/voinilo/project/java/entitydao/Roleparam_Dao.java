package by.it.voinilo.project.java.entitydao;
import by.it.voinilo.project.java.beans.Roleparam;
import by.it.voinilo.project.java.connection.ConnectionCreator;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Roleparam_Dao extends AbstractDao implements interfaceDao<Roleparam> {
    @Override
    public boolean create(Roleparam roleparam) throws SQLException {

        String sql = String.format("INSERT INTO `roleparam`" +
                        "(`login`, `password`, `email`, `roles_id`)" +
                        " VALUES ('%s','%s','%s','%d');",
                roleparam.getLogin(), roleparam.getPassword(),
                roleparam.getEmail(), roleparam.getRoles_id());
        long generatedKeys = executeCreate(sql);

        if (generatedKeys > 0) {
            roleparam.setId(generatedKeys);
        }
        return generatedKeys > 0;


    }


    @Override
    public boolean update(Roleparam role) throws SQLException {

        String sql = String.format(
                "UPDATE `roleparam` SET `login`='%s',`password`='%s'," +
                        "`email`='%s',`roles_id`='%d'" +
                        " WHERE `id`= %d",
                role.getLogin(), role.getPassword(), role.getEmail(),
                role.getRoles_id(), role.getId());
        return executeUpdate(sql);

    }


    @Override
    public Roleparam read(int id) throws SQLException {

        List<Roleparam> users = getALL("WHERE `id`=" + id + " LIMIT 0,1");

        if (users.size() > 0) {
            return users.get(0);

        } else
            return null;

    }


    @Override
    public boolean delete(Roleparam role) throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("DELETE FROM `roleparam` WHERE `id` = %d",
                    role.getId());
            return executeUpdate(sql);
        }
    }

    @Override
    public List<Roleparam> getALL(String WHERE) throws SQLException {
        List<Roleparam> users = new ArrayList<>();
        String sql = "SELECT * FROM roleparam " + WHERE + " ;";
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Roleparam user = new Roleparam();

                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setLogin(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setRoles_id(resultSet.getInt("roles_id"));
                users.add(user);
            }
            return users;
        }
    }

    @Override
    public List<Roleparam> getALL() throws SQLException {
        return getALL("");
    }

//    public static void main(String[] args) throws SQLException {
//        Roleparam role = new Roleparam(0,"log", "passwordddd", "email", 1 );
//        if (create(role))
//            System.out.println("create is ok: " + role );
//        long id = role.getId();
//        role = null;
//        role = read(id);
//        if (role!= null)
//            System.out.println("read is ok: " + role);
//       role.setLogin("==========================");
//        if (update(role))
//            System.out.println("Update is Ok: "+ role);
//        if (delete(role))
//            System.out.println("delete is ok: " + role);
//
//    }
}

