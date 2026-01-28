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


        Department dep = new Department(2, null);

        List<Seller> list = sellerDao.findByDepartment(dep);
        for(Seller seller : list){
            System.out.println(seller);
        }

    }
}
