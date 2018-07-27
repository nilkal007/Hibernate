package com.scp.emp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.scp.constants.AppLevelConstants.EmpFields;
import com.scp.emp.service.EmpService;
import com.scp.entities.EmpEntity;
import com.scp.pojos.EmpPojo;
import com.scp.util.HibernateUtil;

public class EmpServiceImpl implements EmpService {

	/*public static void main(String[] args) {
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
*/
	Session session = null;

	@Override
	public boolean addEmp(EmpPojo emp) {

		try {
			session = HibernateUtil.getsession();
			int i = (Integer) session.save(mapPojoToEntity(emp));// map pojo to entity to save entity type of data
			System.out.println(i);
			HibernateUtil.Flush_Commit(session);
			return i != 0;
		} catch (Exception e) {
			HibernateUtil.trnsactionRollback();
		} finally {
			HibernateUtil.closeSession();
		}

		return false;
	}

	@Override
	public boolean deleteEmp(int empId) {
		try {
			session = HibernateUtil.getsession();
			EmpEntity empEntity = session.get(EmpEntity.class, empId);
			if (empEntity == null)
				return false;
			session.delete(empEntity);
			return true;

		} catch (Exception e) {
			HibernateUtil.trnsactionRollback();
		} finally {
			HibernateUtil.closeSession();
		}
		return false;
	}

	@Override
	public EmpPojo getEmp(int empId) {
		try {
			session = HibernateUtil.getsession();
			return mapEntityToPojo(session.get(EmpEntity.class, empId));// return type EmpPojo hance map EmpEmtity to
																		// EmpPojo
			// HibernateUtil.Flush_Commit(session);
		} catch (Exception e) {
			HibernateUtil.trnsactionRollback();
		} finally {
			HibernateUtil.closeSession();
		}
		return null;
	}

	@Override
	public boolean updateEmp(EmpPojo emp) {
		try {
			session = HibernateUtil.getsession();
			EmpEntity empEntity = (EmpEntity) session.merge(mapPojoToEntity(emp));
			HibernateUtil.Flush_Commit(session);
			return empEntity != null;
		} catch (Exception e) {
			HibernateUtil.trnsactionRollback();
		} finally {
			HibernateUtil.closeSession();
		}
		return false;
	}

	@Override
	public List<EmpPojo> getAllEmp() {
		try {
			session = HibernateUtil.getsession();
			@SuppressWarnings("unchecked")
			List<EmpEntity> listofemp = session.createQuery("from EmpEntity").list();
			HibernateUtil.Flush_Commit(session);
			// HQL -- Class -- Class chya fields
			// SQL -- Table -- table che columns
			return mapListofEntityToPojo(listofemp);

		} catch (Exception e) {
			HibernateUtil.trnsactionRollback();
		} finally {
			HibernateUtil.closeSession();
		}
		return null;
	}

	private List<EmpPojo> mapListofEntityToPojo(List<EmpEntity> listOfEmpEntities) {
		List<EmpPojo> listofemppojos = null;
		if (listOfEmpEntities == null || listOfEmpEntities.isEmpty()) {
			return null;
		} else {
			listofemppojos = new ArrayList<EmpPojo>();
			for (EmpEntity empEntity : listOfEmpEntities) {
				listofemppojos.add(mapEntityToPojo(empEntity));
			}
		}

		return listofemppojos;

	}

	@Override
	public List<EmpPojo> searchEmp(HashMap<EmpFields, String> searchCriteria) {
		session = HibernateUtil.getsession();
		try {
			Query qurey = session.createQuery("from EmpEntity where empId=:empId and isActive=:isActive");
			Set<Entry<EmpFields, String>> entryset = searchCriteria.entrySet();
			for (Entry<EmpFields, String> entry : entryset) {
				if (entry.getKey().equals(EmpFields.empId))
					qurey.setInteger(entry.getKey().toString(), Integer.parseInt(entry.getValue()));

				if (entry.getKey().equals(EmpFields.isActive))
					qurey.setString(entry.getKey().toString(), String.valueOf(entry.getValue()));

				if (entry.getKey().equals(EmpFields.userName))
					qurey.setString(entry.getValue().toString(), String.valueOf(entry.getValue()));

				if (entry.getKey().equals(EmpFields.passWord))
					qurey.setString(entry.getValue().toString(), String.valueOf(entry.getValue()));
				System.out.println(qurey.getQueryString());
				System.out.println("query list--" + qurey.list());
			}
			return qurey.list();

		} catch (Exception e) {
			HibernateUtil.Flush_Commit(session);
		} finally {
			HibernateUtil.closeSession();
		}

		return null;
	}

	public String prepareWhereCondition(HashMap<EmpFields, String> searchCriteria) {

		String whereCondition = "";
		Set<Entry<EmpFields, String>> entrySet = searchCriteria.entrySet();
		for (Entry<EmpFields, String> entry : entrySet) {

			EmpFields field = entry.getKey(); // param
			String value = entry.getValue();// param value

			if (EmpFields.empId.toString().equals(field.toString())) {
				try {
					int val = Integer.parseInt(value);
					whereCondition += "where " + EmpFields.empId.toString() + "=" + val;
				} catch (NumberFormatException e) {
					System.out.println("Invalid empId");
				}
			}

			if (EmpFields.isActive.toString().equals(field.toString())) {
				try {
					boolean val = Boolean.parseBoolean(value);
					String yesOrNo = val ? "Yes" : "No";
					whereCondition += " and " + EmpFields.isActive.toString() + "= '" + yesOrNo + "'";
				} catch (NumberFormatException e) {
					System.out.println("Invalid empId");
				}
			}

		}
		return whereCondition;

	}

	private EmpPojo mapEntityToPojo(EmpEntity empEntity) {
		if (empEntity == null)
			return null;
		EmpPojo pojo = new EmpPojo();
		pojo.setEmpId(empEntity.getEmpId());
		pojo.setUserName(empEntity.getUserName());
		pojo.setPassWord(empEntity.getPassWord());
		pojo.setActive(empEntity.isActive());
		return pojo;
	}

	private EmpEntity mapPojoToEntity(EmpPojo empPojo) {
		if (empPojo == null)
			return null;

		EmpEntity entity = new EmpEntity();
		entity.setEmpId(empPojo.getEmpId());
		entity.setUserName(empPojo.getUserName());
		entity.setPassWord(empPojo.getPassWord());
		entity.setActive(empPojo.isActive());
		return entity;

	}
}
