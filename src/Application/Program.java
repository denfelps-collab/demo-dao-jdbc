package Application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;

public class Program {
    static void main() {

        LocalDate now = LocalDate.now();

        Department obj = new Department(1, "Books");

        Seller seller = new Seller(3100, "Felipe", "Braga@gmail.com",now, 3100.0, obj);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(seller);
    }
}
