package by.it.bindyuk.jd03_03.GenericDAO;

import by.it.bindyuk.jd03_03.dao.AbstractDao;
import by.it.bindyuk.jd03_03.dao.InterfaceDAO;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class GenericDAO<TypeBean> extends AbstractDao implements InterfaceDAO<TypeBean> {

    private TypeBean bean;
    private String table;
    private Field[] fields;

    public GenericDAO(TypeBean bean, String table) {
        this.bean = bean;
        this.table = table;
        this.fields = bean.getClass().getDeclaredFields();
    }
    @SuppressWarnings("unchecked")
    public TypeBean getBean() {
        try {
            return (TypeBean) bean.getClass().getConstructor().newInstance();
        } catch (InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean create(TypeBean bean) throws SQLException, IllegalAccessException {
        String type = "";
        String value = "";
        String delimeter = "";
        for (int i = 1; i < fields.length; i++) {
            Field field = fields[i];
            String name = field.getName();
            Object o = field.get(bean);

        }




        return false;
    }

    @Override
    public TypeBean read(long id) throws SQLException {
        return null;
    }

    @Override
    public boolean update(TypeBean bean) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(TypeBean bean) throws SQLException {
        return false;
    }

    @Override
    public List getAll() throws SQLException {
        return null;
    }

    @Override
    public List getAll(String where) throws SQLException {
        return null;
    }
}
