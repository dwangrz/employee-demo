package com.view.employee;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;


import com.entity.employee.Employee;
import com.logic.employee.EmployeeLogic;

@ManagedBean(name = "employeeViewAdd")
@ApplicationScoped
public class EmployeeViewAdd {
	

	EmployeeLogic logic = new EmployeeLogic();

	private String firstName;
	private String lastName;
	private int salary;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String addEmployeeToView(){
		Employee employeeView = logic.addEmployee(firstName, lastName, salary);
		
		return "employeeView?faces-redirect=true&id=" + employeeView.getId();
	}

}
