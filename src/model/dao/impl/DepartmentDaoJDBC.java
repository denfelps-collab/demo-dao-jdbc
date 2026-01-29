package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
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
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(
                    """
                            INSERT INTO department 
                            (Name)
                            VALUES
                            (?)""",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, obj.getName());

            int rowsAffected = ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if (rowsAffected > 0) {
                System.out.println("Done! " + rowsAffected + " have been affected");
            } else {
                throw new DbException("Error! none rows affected");
            }

            if (rs.next()) {
                int id = rs.getInt(1);
                obj.setId(id);
            }


        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }

    @Override
    public void update(Department obj) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("""
                    UPDATE department 
                    SET Name = ?
                    Where Id = ?
                    """);

            ps.setString(1, obj.getName());
            ps.setInt(2, obj.getId());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Done! " + rowsAffected + " have been affected");
            } else {
                throw new DbException("Error! none rows affected");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("""
                    DELETE FROM department 
                    WHERE Id = (?)
                    """);

            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Done! " + rowsAffected + " have been affected");
            } else {
                throw new DbException("Error! none rows affected");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }


    @Override
    public Department findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(
                    """
                            SELECT *
                            FROM department
                            WHERE Id = (?)
                            """);

            ps.setInt(1, id);

            rs = ps.executeQuery();


            if (rs.next()) {
                Department dep = new Department(rs.getInt(1), rs.getString(2));
                return dep;
            } else {
                System.out.println("We dont found that ID");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
        return null;
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Department> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(
                    """
                            SELECT *
                            FROM department
                            """);

            rs = ps.executeQuery();

            while (rs.next()) {
                Department dep = new Department(rs.getInt(1), rs.getString(2));
                list.add(dep);
            }
            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());

        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }

    }
}
