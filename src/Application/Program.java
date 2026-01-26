package Application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.Date;


public class Program {
    static void main() {

        Connection conn = DB.getConnection();




        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(sellerDao.findById(2));


    }
}
