package Application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.util.List;

public class Program {
    static void main() {

        Connection conn = DB.getConnection();

        SellerDao sellerDao = DaoFactory.createSellerDao();

        List<Seller> lista = sellerDao.findAll();

        for(Seller a : lista){
            System.out.println(a);
        }

    }
}
