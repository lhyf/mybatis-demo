package org.lhyf.mybatis.dao;

import org.apache.ibatis.annotations.Select;
import org.lhyf.mybatis.bean.Employee;


public interface EmployeeMapperAnnotation {
	
	@Select("select * from tbl_employee where id=#{id}")
	public Employee getEmpById(Integer id);
}
