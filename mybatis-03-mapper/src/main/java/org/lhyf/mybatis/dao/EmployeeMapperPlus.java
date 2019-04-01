package org.lhyf.mybatis.dao;

import org.lhyf.mybatis.bean.Employee;

import java.util.List;


public interface EmployeeMapperPlus {
	
	Employee getEmpById(Integer id);
	
	Employee getEmpAndDept(Integer id);
	
	Employee getEmpByIdStep(Integer id);
	
	List<Employee> getEmpsByDeptId(Integer deptId);

}
