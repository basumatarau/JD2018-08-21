package by.it.basumatarau.project.java.customDAO;

import by.it.basumatarau.project.java.beans.Place;
import by.it.basumatarau.project.java.beans.Venue;
import by.it.basumatarau.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class VenueDAO extends DAO implements InterfaceDAO<Venue> {
    @Override
    public Venue read(long id) throws SQLException {
        List<Venue> result = getAll(String.format("WHERE `ID`=%d ;", id));  //"LIMIT 0,1 ;" why limit the query if the id is supposed to be unique?
        if(result.size()>0){
            return result.get(0);
        }
        return null;
    }

    @Override
    public boolean create(Venue bean) throws SQLException {
        NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);
        String sqlQuery = String.format("INSERT INTO `Venues`" +
                        "(`Name`, `Description`, `OpeningDeteTime`, `Fee`, `Users_ID`, `Places_ID`) " +
                        "VALUES ('%s','%s','%s',%s,%d,%d)",
                bean.getName(),
                bean.getDescription(),
                bean.getOpeningDeteTime(),
                nf.format(bean.getFee()),
                bean.getUsers_Id(),
                bean.getPlaces_Id()
        );
        long id;
        if((id=executeUpdate(sqlQuery))>0){
            bean.setId(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean update(Venue bean) throws SQLException {
        NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);
        String sqlQuery = String.format("UPDATE `Venues` SET " +
                        "`Name`='%s'," +
                        "`Description`='%s'," +
                        "`OpeningDeteTime`='%s'," +
                        "`Fee`=%s," +
                        "`Users_ID`=%d," +
                        "`Places_ID`=%d " +
                        "WHERE `ID`=%d ;",
                bean.getName(),
                bean.getDescription(),
                bean.getOpeningDeteTime(),
                nf.format(bean.getFee()),
                bean.getUsers_Id(),
                bean.getPlaces_Id(),
                bean.getId()
        );
        
        return executeUpdate(sqlQuery)==1;
    }

    @Override
    public boolean delete(Venue bean) throws SQLException {
        String sqlQuery = String.format("DELETE FROM `Venues` WHERE `ID`=%d",
                bean.getId()
        );
        return executeUpdate(sqlQuery)==1;
    }

    @Override
    public List<Venue> getAll(String sqlWHERE) throws SQLException {
        List<Venue> result = new ArrayList<>();

        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()){

            String sqlQuery = String.format("SELECT * FROM `Venues` %s ", sqlWHERE);
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()){
                result.add(
                        new Venue(resultSet.getLong("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Description"),
                        resultSet.getTimestamp("OpeningDeteTime"),
                        resultSet.getFloat("Fee"),
                        resultSet.getLong("Users_ID"),
                        resultSet.getLong("Places_ID"))
                );
            }
        }
        return result;
    }

    public void getAllDetailed(String sqlWHERE, List<Venue> venues, List<Place> places) throws SQLException {

        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()){

            String sqlQuery = String.format(
                    " SELECT Venues.ID, Venues.Name, Venues.Description, Venues.OpeningDeteTime, Venues.Fee, " +
                            "Venues.Users_ID, Venues.Places_ID, Places.Name, Places.Address " +
                            " FROM Venues LEFT JOIN Places ON Venues.Places_ID = Places.ID %s ;",
                    sqlWHERE
            );
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()){
                venues.add(
                        new Venue(resultSet.getLong("ID"),
                                resultSet.getString("Name"),
                                resultSet.getString("Description"),
                                resultSet.getTimestamp("OpeningDeteTime"),
                                resultSet.getFloat("Fee"),
                                resultSet.getLong("Users_ID"),
                                resultSet.getLong("Places_ID"))
                );
                places.add(
                        new Place(
                                resultSet.getLong("ID"),
                                resultSet.getString("Name"),
                                resultSet.getString("Address")
                        )
                );
            }
        }
    }

    public void searchVenues(String pattern, List<Venue> venues, List<Place> places) throws SQLException {

        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()){

            String sqlQuery = String.format(
                    " SELECT Venues.ID, Venues.Name, Venues.Description, Venues.OpeningDeteTime, Venues.Fee, " +
                            "Venues.Users_ID, Venues.Places_ID, Places.Name, Places.Address " +
                            " FROM Venues LEFT JOIN Places ON Venues.Places_ID = Places.ID WHERE " +
                            "(Venues.Name REGEXP '%s') OR (Venues.Description REGEXP '%s') OR " +
                            "(Venues.OpeningDeteTime REGEXP '%s') OR (Places.Name REGEXP '%s') OR " +
                            "(Places.Address REGEXP '%s') ;",
                    pattern, pattern, pattern, pattern, pattern
            );
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while(resultSet.next()){
                venues.add(
                        new Venue(resultSet.getLong("ID"),
                                resultSet.getString("Name"),
                                resultSet.getString("Description"),
                                resultSet.getTimestamp("OpeningDeteTime"),
                                resultSet.getFloat("Fee"),
                                resultSet.getLong("Users_ID"),
                                resultSet.getLong("Places_ID"))
                );
                places.add(
                        new Place(
                                resultSet.getLong("ID"),
                                resultSet.getString("Name"),
                                resultSet.getString("Address")
                        )
                );
            }
        }
    }

    public long getCount(String sqlWhere) throws SQLException {
        long result=1L;

        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()){

            String sqlQuery = String.format("SELECT COUNT(*) AS count FROM `Venues` %s ;", sqlWhere);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if(resultSet.next()) {
                result = resultSet.getLong("count");
            }
        }

        return result;
    }
}
