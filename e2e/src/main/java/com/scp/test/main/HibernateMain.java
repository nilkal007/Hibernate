package com.scp.test.main;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.scp.constants.AppLevelConstants.EmpFields;
import com.scp.emp.service.EmpService;
import com.scp.emp.service.impl.EmpServiceImpl;
import com.scp.pojos.EmpPojo;;

public class HibernateMain {
	public static Logger logger = Logger.getLogger(HibernateMain.class);

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		 logger.debug("Sample debug message");
	        logger.info("Sample info message");
	        logger.error("Sample error message");
	        logger.fatal("Sample fatal message");
		
		if(true)
			return;
		EmpPojo emp1 = new EmpPojo(1, "nil", "nil123", true);

		EmpService empService = new EmpServiceImpl();
		for (int i = 0; i < 10; i++) {
			boolean isAdded = empService.addEmp(new EmpPojo(i, "nilesh" + i, "pass" + i, true));
		}

		EmpPojo getemp = empService.getEmp(1);
		System.out.println(getemp);
		EmpPojo emp = new EmpPojo(1, "ni2", "nil123", true);
		boolean empEntity = empService.updateEmp(emp);
		System.out.println(empEntity);
		List<EmpPojo> list = empService.getAllEmp();
		for (EmpPojo empPojo : list) {
			System.out.println(empPojo);
		}
		HashMap<EmpFields, String> hMap = new HashMap<>();
		hMap.put(EmpFields.empId, "2");
		hMap.put(EmpFields.userName, "nilesh2");
		String hqlQuery = "from EmpEntity " + ((EmpServiceImpl) empService).prepareWhereCondition(hMap);
		System.out.println(hqlQuery);

	}
}
