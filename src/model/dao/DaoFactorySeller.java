package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactorySeller {

    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }
}
