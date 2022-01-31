package com.mouritech.hibernateexample;

import org.hibernate.Session;
import java.util.List;
import org.hibernate.Transaction;

import com.mouritech.employee.entity.Employee;
import com.mouritech.employee.util.HibernateUtil;


public class HibernateMain {
public static void main(String[] args) {
	
	Employee emp = new Employee("rama", "rama@hamil", "hyd","SrNagar",2332L,"HR",12);
	Employee emp1 = new Employee( "sitha", "sithadev@gamil", "hyd","gachibowle",434343L,"IT",13);
//	String empName, String empEmail, String empLocation, String empAddress, Long empContactNo,
//	String empDepartment, int empId
	
        Transaction transaction = null;
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {

		// start the transaction
		transaction = session.beginTransaction();
		// save the student objects in to database
		session.save(emp);
		session.save(emp1);
		// commit transaction
		transaction.commit();

	} catch (Exception e) {

		if (transaction != null) {
			transaction.rollback();
		}

		e.printStackTrace();
	}

	// retrieve the data from database to java program using hibernate

	try (Session session = HibernateUtil.getSessionFactory().openSession()) {

		List<Employee> studentList = session.createQuery("from Employee", Employee.class).list();
		studentList.forEach(stud -> System.out.println(stud));

	} catch (Exception e) {
		if (transaction != null) {
			transaction.rollback();
		}
		e.printStackTrace();
	}

}
	
}
