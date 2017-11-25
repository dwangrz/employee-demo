package com.logic.employee;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session; 
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.entity.employee.Employee;


public class EmployeeLogic {
	
	static SessionFactory factory;
	
	static{		
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.configure("/resources/hibernate.cfg.xml");
		factory = config.buildSessionFactory();
	}
	
	

	
	
//   SessionFactory factory;
   
//  public static void main(String[] args) {
//     try{
//        factory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
//     }catch (Throwable ex) { 
//        System.err.println("Failed to create sessionFactory object." + ex);
//        throw new ExceptionInInitializerError(ex); 
//     }
//     ManageEmployee ME = new ManageEmployee();
//
//     /* Add few employee records in database */
//     Integer empID1 = ME.addEmployee("Zara", "Ali", 1000);
//     Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
//     Integer empID3 = ME.addEmployee("John", "Paul", 10000);
//
//     /* List down all the employees */
//     ME.listEmployees();
//
//     /* Update employee's records */
//     ME.updateEmployee(empID1, 5000);
//
//     /* Delete an employee from the database */
//     ME.deleteEmployee(empID2);
//
//     /* List down new list of the employees */
//     ME.listEmployees();
//  }
  /* Method to CREATE an employee in the database */
	public Employee addEmployee(String fname, String lname, int salary) {

//		config.addAnnotatedClass(Employee.class);  this already set in cfg
//		config.configure("/resources/hibernate.cfg.xml");

//		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();

		Employee employee = new Employee(fname, lname, salary);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
//			new SchemaExport(config).create(true, true);
			session.save(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employee;
	}
  /* Method to  READ all the employees */
//  public List<Employee> getAllEmployees( ){
//	  
//	  List<Employee> employeeList = new ArrayList<>();
//     Session session = factory.openSession();
//     Transaction tx = null;
//     try{
//        tx = session.beginTransaction();
//        Query query = session.createQuery("SELECT e FROM Employee e");
//        
//        employeeList =  query.list(); 
////        for (Iterator iterator = 
////                          employees.iterator(); iterator.hasNext();){
////           Employee employee = (Employee) iterator.next(); 
////           System.out.print("First Name: " + employee.getFirstName()); 
////           System.out.print("  Last Name: " + employee.getLastName()); 
////           System.out.println("  Salary: " + employee.getSalary()); 
////        }
//        tx.commit();
//     }catch (HibernateException e) {
//        if (tx!=null) tx.rollback();
//        e.printStackTrace(); 
//     }finally {
//        session.close(); 
//     }
//     return employeeList;
//  }
//  /* Method to UPDATE salary for an employee */
//  public void updateEmployee(Integer EmployeeID, int salary ){
//     Session session = factory.openSession();
//     Transaction tx = null;
//     try{
//        tx = session.beginTransaction();
//        Employee employee = 
//                   (Employee)session.get(Employee.class, EmployeeID); 
//        employee.setSalary( salary );
//		 session.update(employee); 
//        tx.commit();
//     }catch (HibernateException e) {
//        if (tx!=null) tx.rollback();
//        e.printStackTrace(); 
//     }finally {
//        session.close(); 
//     }
//  }
//  /* Method to DELETE an employee from the records */
//  public void deleteEmployee(Integer EmployeeID){
//     Session session = factory.openSession();
//     Transaction tx = null;
//     try{
//        tx = session.beginTransaction();
//        Employee employee = 
//                  (Employee)session.get(Employee.class, EmployeeID); 
//        session.delete(employee); 
//        tx.commit();
//     }catch (HibernateException e) {
//        if (tx!=null) tx.rollback();
//        e.printStackTrace(); 
//     }finally {
//        session.close(); 
//     }
//  }
  
	public Employee getEmployeeById(Integer Id) {
		
//		config.addAnnotatedClass(Employee.class);
//		config.configure("/resources/hibernate.cfg.xml");

//		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		Employee employee = null;

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			employee = (Employee) session.get(Employee.class, Id);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
//			session.close();
		}

		return employee;
	}  

}