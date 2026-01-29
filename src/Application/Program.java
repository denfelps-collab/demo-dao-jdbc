package Application;

import db.DB;
import model.dao.DaoFactorySeller;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.Date;

public class Program {
    static void main() {

        Connection conn = DB.getConnection();

        SellerDao sellerDao = DaoFactorySeller.createSellerDao();

        Department depart = new Department(3,null);

        Seller seller = new Seller(null, "Braga", "Braga@Gmail.com", new Date(15-10-2000),1000.0, depart);

        sellerDao.insert(seller);

    }
}
