package org.lhyf.mybatis.dao;


import org.lhyf.mybatis.bean.Employee;

import java.util.List;


public interface EmployeeMapper {
	
	public Employee getEmpById(Integer id);
	
	public List<Employee> getEmps();
	

}
