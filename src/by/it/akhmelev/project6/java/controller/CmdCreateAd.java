package by.it.akhmelev.project6.java.controller;

import by.it.akhmelev.project6.java.beans.Ad;
import by.it.akhmelev.project6.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdCreateAd extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws ParseException, SQLException {
        if (Form.isPost(req)) {
            String description=Form.getString(req,"description");
            String address=Form.getString(req,"address");
            int rooms=Form.getInt(req,"rooms");
            int floor=Form.getInt(req,"floor");
            int floors=Form.getInt(req,"floors");
            double price=Form.getDouble(req,"price");
            double area=Form.getDouble(req,"area");
            Ad ad=new Ad(0,description,address,rooms,floor,floors,price,area,2);
            Dao.getDao().ad.create(ad);

        }
        return null;
    }
}
