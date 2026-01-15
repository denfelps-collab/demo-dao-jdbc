package model.dao.impl;

import model.dao.SellerDao;
import model.entities.Seller;

import java.util.List;
import java.util.Scanner;

public class SellerDaoJDBC implements SellerDao {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void insert(Seller obj) {
        try{

        }

    }

    @Override
    public void update(Seller obj) {

    }

    @Override
    public void delete(Integer id) {

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
