package org.lhyf.mybatis.mybatis.dao;

import org.apache.ibatis.annotations.Select;
import org.lhyf.mybatis.mybatis.bean.Employee;


public interface EmployeeMapperAnnotation {
	
	@Select("select * from tbl_employee where id=#{id}")
	public Employee getEmpById(Integer id);
}
