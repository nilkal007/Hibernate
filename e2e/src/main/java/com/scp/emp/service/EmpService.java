package com.scp.emp.service;

import java.util.HashMap;
import java.util.List;

import com.scp.constants.AppLevelConstants;
import com.scp.pojos.EmpPojo;

public interface EmpService {
	public boolean addEmp(EmpPojo emp);

	public boolean deleteEmp(int empId);

	public EmpPojo getEmp(int empId);

	public boolean updateEmp(EmpPojo emp);

	public List<EmpPojo> getAllEmp();

	public List<EmpPojo> searchEmp(HashMap<AppLevelConstants.EmpFields, String> searchCriteria);
}
