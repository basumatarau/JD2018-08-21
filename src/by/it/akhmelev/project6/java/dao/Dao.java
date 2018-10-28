package by.it.akhmelev.project6.java.dao;

import by.it.akhmelev.project6.java.beans.Ad;
import by.it.akhmelev.project6.java.dao.InterfaceDao;
import by.it.akhmelev.project6.java.dao.UniversalDAO;
import by.it.akhmelev.project6.java.dao.beansdao.Reset;
import by.it.akhmelev.project6.java.dao.beansdao.RoleDao;
import by.it.akhmelev.project6.java.dao.beansdao.UserDao;

public class Dao {

    private static Dao instance;

    public UserDao user;
    public RoleDao role;
    public InterfaceDao<Ad> ad;

    private Dao() {
        role = new RoleDao();
        user = new UserDao();
        ad = new UniversalDAO<>(new Ad(), "ads");
    }

    public static Dao getDao() {
        if (instance == null) {
            synchronized (Dao.class) {
                instance = new Dao();
            }
        }
        return instance;
    }

    public void reset() {
        Reset.main(new String[0]);
    }
}
