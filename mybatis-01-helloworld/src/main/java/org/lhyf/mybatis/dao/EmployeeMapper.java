package org.lhyf.mybatis.dao;


import org.lhyf.mybatis.bean.Employee;

public interface EmployeeMapper {
	
	Employee getEmpById(Integer id);

}
