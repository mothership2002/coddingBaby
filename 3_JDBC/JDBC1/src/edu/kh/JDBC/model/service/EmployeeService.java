package edu.kh.JDBC.model.service;

import java.util.List;

import edu.kh.JDBC.model.DAO.EmployeeDAO;
import edu.kh.JDBC.model.vo.Employee;

public class EmployeeService {
	
	private EmployeeDAO dao = new EmployeeDAO();

	public List<Employee> selectAll() {
		
		List<Employee> empList = dao.selectAll();
		
		return empList;
	}


	public Employee selectOne(int input) {
		
		Employee emp = dao.selectOne(input);
		
		return emp;
	}


	public List<Employee> salaryOver(int input) {
		
		List<Employee> salaryOver = dao.salaryOver(input);
		
		return salaryOver;
	}


	public int insertEmployee(Employee insertEmployee) {
		
		int result  = dao.insertEmployee(insertEmployee);
		
		return result;
	}


	public int deleteEmployee(int empID) {

		int result = dao.deleteEmployee(empID);
		
		return result;
	}


	public int updateEmployee(Employee update) {

		int result = dao.updateEmployee(update);
		
		return result;
	}


	public int updateBonus(Employee updateBn) {
		
		int result = dao.updateBonus(updateBn);
		
		return result;
	}



	

	
}
