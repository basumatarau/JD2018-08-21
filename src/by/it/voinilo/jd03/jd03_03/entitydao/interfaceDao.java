package by.it.voinilo.jd03.jd03_03.entitydao;

import java.sql.SQLException;
import java.util.List;

public interface interfaceDao <TYPE> {
     boolean create(TYPE bean) throws SQLException;
    TYPE read(int id)throws SQLException;
    boolean update(TYPE bean)throws SQLException;
    boolean delete (TYPE bean)throws SQLException;
    List<TYPE> getALL ()throws SQLException;
    List<TYPE> getALL (String where)throws SQLException;
}
