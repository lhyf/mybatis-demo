package org.lhyf.mybatis.dao;

import org.lhyf.mybatis.bean.Employee;
import org.lhyf.mybatis.bean.OraclePage;

import java.util.List;


public interface EmployeeMapper {
	
	public Employee getEmpById(Integer id);
	
	public List<Employee> getEmps();
	
	public Long addEmp(Employee employee);
	
	public void getPageByProcedure(OraclePage page);
}
