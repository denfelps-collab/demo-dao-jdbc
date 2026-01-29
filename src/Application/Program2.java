package Application;

import db.DB;
import model.dao.DaoFactoryDepartment;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.Connection;

public class Program2 {
    static void main() {

        Connection conn = DB.getConnection();

        DepartmentDao departmentDao = DaoFactoryDepartment.createDepartmentDao();

        Department department = new Department(6, "Construction");

        System.out.println(departmentDao.findAll());
    }
}
