package by.it.voinilo.jd03.jd03_03.entitydao;



import by.it.voinilo.jd03.jd03_03.beans.Ads;
import by.it.voinilo.jd03.jd03_03.beans.Roleparam;
import by.it.voinilo.jd03.jd03_03.beans.Roles;

import java.sql.SQLException;

public class Runner {


    public static void main(String[] args) throws SQLException {
        by.it.voinilo.jd03.jd03_03.entitydao.Dao dao = by.it.voinilo.jd03.jd03_03.entitydao.Dao.getDao();
        //dao.reset();

        Roleparam user = new Roleparam(0, "UserDao", "UserDao", "UserDao@user.ru", 1);
        if (dao.user.create(user))
            System.out.println("CREATE:\n" + dao.user.getALL());
        user = dao.user.read((int) user.getId());
        user.setLogin("uuuuuu");
        if (dao.user.update(user))
            System.out.println("UPDATE:\n" + dao.user.getALL());
        if (dao.user.delete(user))
            System.out.println("DELETE:\n" + dao.user.getALL());

        Roles role = new Roles(0, "RoleDao");
        if (dao.role.create(role))
            System.out.println("CREATE:\n" + dao.role.getALL());
        role = dao.role.read((int) role.getId());
        role.setRole("rrrrrrr");
        if (dao.role.update(role))
            System.out.println("UPDATE:\n" + dao.role.getALL());
        if (dao.role.delete(role))
            System.out.println("DELETE:\n" + dao.role.getALL());

        Ads ad = new Ads();
        ad.setDescription("ad dao test ad dao test ad dao test ");
        ad.setRoles_id(2);
        if (dao.ad.create(ad))
            System.out.println("CREATE:\n" + dao.ad.getALL());
        ad = dao.ad.read((int) ad.getId());
        ad.setDescription("ddddddd");
        if (dao.ad.update(ad))
            System.out.println("UPDATE:\n" + dao.ad.getALL());
        if (dao.ad.delete(ad))
            System.out.println("DELETE:" + dao.ad.getALL());
    }
}
