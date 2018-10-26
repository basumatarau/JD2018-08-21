package by.it.bindyuk.project.java.dao.beans;

import java.util.Objects;

public class Route {

    private long id;
    private String city;

    public Route(long id, String city) {
        this.id = id;
        this.city = city;
    }

    public Route() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", city='" + city + '\'' +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return id == route.id &&
                Objects.equals(city, route.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city);
    }
}
