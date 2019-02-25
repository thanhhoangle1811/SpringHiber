package hoang.dao;

import java.util.List;

import hoang.entity.Department;

public interface DepartmentDAO {
	 
	  public List<Department> listDepartment() ;
	  
	  public Integer getMaxDeptId();
	  
	  public void createDepartment(String name,String location);  
	}