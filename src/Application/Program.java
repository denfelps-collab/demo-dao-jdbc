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



        Department obj = new Department(1, "Books");


        SellerDao sellerDao = DaoFactory.createSellerDao();

        sellerDao.delete(3100);


    }
}
