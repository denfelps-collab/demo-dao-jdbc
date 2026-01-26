package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class SellerDaoJDBC implements SellerDao {

    Scanner sc = new Scanner(System.in);

    private Connection conn;

    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void insert(Seller obj) {
        try {
            PreparedStatement ps = null;
            ps = conn.prepareStatement(
                    "INSERT INTO seller "
                            + "(id,name,email,birthDate,baseSalary,departmentId) "
                            + "VALUES "
                            + "(?,?,?,?,?,?) "
            );


            ps.setInt(1, obj.getId());
            ps.setString(2, obj.getName());
            ps.setString(3, obj.getEmail());
            ps.setDate(4, obj.getBrithDate());
            ps.setDouble(5, obj.getBaseSalary());
            ps.setInt(6, obj.getDepartment());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Seller obj) {
    }

    @Override
    public void delete(Integer id) {
        try {
            PreparedStatement ps = null;
            ps = conn.prepareStatement(
                    "DELETE FROM seller "
                            + "WHERE id = (?)"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        Seller seller = new Seller();
        Department dep = new Department();

        try {
            st = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName" +
                            " FROM seller INNER JOIN department" +
                            " ON seller.DepartmentId = department.Id" +
                            " WHERE seller.Id = ?");

            st.setInt(1, id);
            rs = st.executeQuery();


            if (rs.next()) {
                dep.setId(rs.getInt("DepartmentId"));
                dep.setName(rs.getString("DepName"));

                seller.setId(rs.getInt("Id"));
                seller.setName(rs.getString("name"));
                seller.setEmail(rs.getString("Email"));
                seller.setBrithDate(rs.getDate("BirthDate"));
                seller.setBaseSalary(rs.getDouble("BaseSalary"));
                seller.setDepartment(dep);
                return seller;

            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Seller> findAll() {
        return List.of();
    }
}