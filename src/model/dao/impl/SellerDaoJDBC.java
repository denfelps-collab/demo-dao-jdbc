package model.dao.impl;

import db.DB;
import model.dao.SellerDao;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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


            ps.setInt(1,obj.getId());
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
        return null;
    }

    @Override
    public List<Seller> findAll() {
        return List.of();
    }
}
