package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class DepartmentDaoJDBC implements DepartmentDao {

    Scanner sc = new Scanner(System.in);

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(
                    """
                            INSERT INTO department 
                            (Name)""",
                            Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, obj.getName());

            ResultSet rs = ps.getGeneratedKeys();

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Done! " + rowsAffected + "have been affected");
            } else{
                throw new DbException("Error! none rows affected");
            }
            DB.closeResultSet(rs);

            if(rs.next()){
                int id = rs.getInt(1);
                obj.setId(id);
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }

    }

    @Override
    public void update(Department obj) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return List.of();
    }
}
