package com.scp.emp.business;

import java.util.List;

import com.scp.constants.AppLevelConstants;
import com.scp.emp.service.EmpService;
import com.scp.emp.service.impl.EmpServiceImpl;
import com.scp.pojos.EmpPojo;

public class EmpController {

	public String validateUserCredentails(String username, String password) {
		String dbUserName = null;
		String dbPassword = null;
		try {
			EmpService service = new EmpServiceImpl();
			List<EmpPojo> emps = service.getAllEmp(); // make sure one record is there-- for now consider this as an
														// assumption
			for (EmpPojo empPojo : emps) {
				dbUserName = empPojo.getUserName();
				dbPassword = empPojo.getPassWord();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (dbUserName == null) {
				dbUserName = "";
			}
			if (dbPassword == null) {
				dbPassword = "";
			}
		}
		if (username == null && password == null) {
			return AppLevelConstants.INVALID_USERNAME_PASSWORD;
		}
		if (username == null) {
			return AppLevelConstants.USERNAME_CANNOT_BE_EMPTY;
		} else if (password == null) {
			return AppLevelConstants.PASSWORD_CANNOT_BE_EMPTY;
		} else if (dbUserName.equals(username) && dbPassword.equals(password)) {
			return AppLevelConstants.LOGIN_SUCCESS;
		}
		return AppLevelConstants.INVALID_USERNAME_PASSWORD;
	}
}
