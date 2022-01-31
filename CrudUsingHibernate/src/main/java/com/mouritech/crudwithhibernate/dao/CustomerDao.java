package com.mouritech.crudwithhibernate.dao;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mouritech.crudwithhibernate.entity.Customer;
import com.mouritech.crudwithhibernate.util.HibernateUtil;



public class CustomerDao<Criteria> {
	public void customerSave(Customer customer) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			session.save(customer);
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}

	public void getAllCustomer() {
		// retrieve the data from database to java program using hibernate
		//Transaction transaction = null;
				try (Session session = HibernateUtil.getSessionFactory().openSession()) {

					List<Customer> employeeList = session.createQuery("from Customer", Customer.class).list();
					employeeList.forEach(customer -> System.out.println(customer));

				} catch (Exception e) {
					e.printStackTrace();
				}
				
		
	}

	public void deleteCustomer(Class<Customer> type, Serializable customerid) {
		Transaction transaction1 = null;
		try (Session session1 = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction1 = session1.beginTransaction();
			Customer customer = session1.get(Customer.class,customerid);
			if(customer!=null) {
				session1.remove(customer);
				System.out.println("Customer deleted successfully");
			}
			
			/*
			 * Employee emp2 = new Employee(); emp2.setEmpId(empid); session1.delete(emp2);
			 * System.out.println("Employee deleted"); transaction1.commit();
			 */
			transaction1.commit();
			
		}catch (Exception e) {
			if (transaction1 != null) {
				transaction1.rollback();
			}

			e.printStackTrace();
		}
		
	}

	public void updateCustomer(Long customerid,String mobNo) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			//session.saveOrUpdate(emp);
			
			//get entity from database
			Customer updatingCustomer = session.get(Customer.class, customerid);
			System.out.println(updatingCustomer);
			//do changes
			updatingCustomer.setCustomerMobileNo(mobNo);
			//update the Employee object
			session.saveOrUpdate(updatingCustomer);
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		
	}

	public void getCustomerById(Long customerid) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			//session.saveOrUpdate(emp);
			
			//get entity from database
			Customer customerById = session.get(Customer.class, customerid);
			if(customerById!=null) {
				
				System.out.println("Customer details are = " + customerById);
			}
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		
	}

	public void getCustomerByName(String customerName) {
		Transaction transaction1 = null;
		try (Session session1 = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction1 = session1.beginTransaction();
	        Query deleteQuery = session1.createQuery("Delete from Customer where customerName= : customerName");
			deleteQuery.setParameter("id", 7);
            int deleteStatus = deleteQuery.executeUpdate();
			System.out.println(deleteStatus);
			
		
			transaction1.commit();
			
		}catch (Exception e) {
			if (transaction1 != null) {
				transaction1.rollback();
			}

			e.printStackTrace();
		}
		
	}
//	 SELECT * FROM department WHERE NAME LIKE 'S%';
//	SELECT SSN,ENAME FROM EMP WHERE DATEDIFF(YEAR, DOB, GETDATE())>30
	
}