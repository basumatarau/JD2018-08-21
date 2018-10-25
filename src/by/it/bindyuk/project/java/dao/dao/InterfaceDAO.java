package by.it.bindyuk.project.java.dao.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO<TYPE> {

    boolean create(TYPE bean) throws SQLException, IllegalAccessException;

    TYPE read(long id) throws SQLException;

    boolean update(TYPE bean) throws SQLException;

    boolean delete(TYPE bean) throws SQLException;

    List<TYPE> getAll() throws SQLException ;

    List<TYPE> getAll(String where)throws SQLException;


}
