package com.view.employee;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.entity.employee.Employee;
import com.logic.employee.EmployeeLogic;

@ManagedBean
@RequestScoped
public class EmployeeView {
	
	EmployeeLogic logic = new EmployeeLogic();
		
	private Integer Id;
	private Employee employee;
	
	
	public EmployeeView() {
	}
	public EmployeeView(Integer id, Employee employee) {
		Id = id;
		this.employee = employee;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public void loadEmployee(){
		employee = logic.getEmployeeById(Id);
	}

}
