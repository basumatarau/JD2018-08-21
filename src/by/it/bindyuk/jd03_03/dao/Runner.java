package by.it.bindyuk.jd03_03.dao;

import by.it.bindyuk.jd03_03.beans.Role;
import by.it.bindyuk.jd03_03.beans.Ticket;
import by.it.bindyuk.jd03_03.beans.User;

import java.sql.*;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws IllegalAccessException {
        Dao dao = Dao.getDao();
        try {
            User user = new User(0, "test",
                    "test", "test", "test",
                    1234, "test", 123, 2);
            dao.user.create(user);
            String where =" WHERE Login='user' AND PASSWORD='user'";
            List<User> users = dao.user.getAll(where);
            System.out.println(users);
            user = dao.user.read(user.getId());
            System.out.println(user);
            List<Role> all = dao.role.getAll("WHERE `id`=1");
            System.out.println(all);
            List<Role> all1 = dao.role.getAll();
            System.out.println(all1);
            dao.reset();
            dao.ticket.create(new Ticket(0,"samokat",2,3,new Timestamp(1540771200000L),2));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
