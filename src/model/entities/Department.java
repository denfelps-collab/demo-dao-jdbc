package model.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Department implements Serializable {
    private Integer Id;
    private String name;
    private List<Seller> Sellers;

    public Department(Integer id, String name, List<Seller> sellers) {
        Id = id;
        this.name = name;
        Sellers = sellers;
    }

    public Department(Integer id, String name) {
        Id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department " +
                "Id -> " + Id +
                ", Name -> '" + name + '\'' +
                ", Sellers -> " + Sellers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(Id, that.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Id);
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Seller> getSellers() {
        return Sellers;
    }

    public void setSellers(List<Seller> sellers) {
        Sellers = sellers;
    }
}
