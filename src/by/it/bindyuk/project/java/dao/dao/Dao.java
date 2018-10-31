package by.it.bindyuk.project.java.dao.dao;

import by.it.bindyuk.project.java.dao.beans.Role;
import by.it.bindyuk.project.java.dao.beans.Route;
import by.it.bindyuk.project.java.dao.beans.Ticket;
import by.it.bindyuk.project.java.dao.beans.User;

public class Dao {

    private static Dao instance;

    public InterfaceDAO<User> user;
    public InterfaceDAO<Role> role;
    public InterfaceDAO<Ticket> ticket;
    public InterfaceDAO<Route> route;

    private Dao() {
    }

    public void reset() {
        Reset.main(new String[0]);
    }

    //==================================================================================================================
    //Singleton, внутри инициализируются все поля DAO
    public static Dao getDao() {
        if (instance == null) {
            synchronized (Dao.class) {
                if (instance == null) {
                    instance = new Dao();
                    instance.user = new UserDAO();
                    instance.role = new RoleDAO();
                    instance.route = new RouteDAO();
                    instance.ticket = new TicketDAO();
                }
            }
        }
        return instance;
    }
}
