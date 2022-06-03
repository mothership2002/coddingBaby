package UM.HW.management.model.service;

import static UM.HW.common.JDBCTemplate.getConnection;
import static UM.HW.common.JDBCTemplate.close;
import static UM.HW.common.JDBCTemplate.rollback;
import static UM.HW.common.JDBCTemplate.commit;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import UM.HW.management.model.dao.DAO;
import UM.HW.management.model.dao.DAOforDML;
import UM.HW.management.model.vo.LogVo;
import UM.HW.management.model.vo.ValueObject;

public class DataService {
	
	private Connection cont;
	private DAO dao = new DAO();
	private DAOforDML dml = new DAOforDML();

	public List<ValueObject> selectStudent(String departmentName) throws Exception {
		
		cont = getConnection();
		List<ValueObject> students = dao.selectStudent(cont,departmentName);
		close(cont);
		return students;
	}
	
	public List<ValueObject> selectProfessor(String departmentName) throws Exception{
		
		cont = getConnection();
		List<ValueObject> professors = dao.selectProfessor(cont,departmentName);
		close(cont);
		return professors;
	}

	public List<ValueObject> selectGrade(String studentName, String studentNo) throws Exception{
		cont = getConnection();
		List<ValueObject> studentGrade = dao.studentGrade(cont,studentName,studentNo);
		close(cont);
		return studentGrade;
	}

	public List<ValueObject> selectMessenger(String proDept, String proName) throws Exception {
		cont = getConnection();
		List<ValueObject> proMess = dao.professorMessenger(cont,proDept,proName);
		close(cont);
		return proMess;
	}

	public int duplicateCheck(String id)throws Exception {
		cont = getConnection();
		int result = dao.duplicateCheck(cont,id);
		close(cont);
		return result;
	}

	public int checkProfessor(LogVo check) throws Exception {
		cont = getConnection();
		int result = dao.checkProfessor(cont,check);
		close(cont);
		return result;
	}

	public int addAccount(LogVo lv)throws Exception {
		cont = getConnection();
		int result = dml.addAccount(cont,lv);
		if(result > 0) commit(cont);
		else		   rollback(cont);
		close(cont);
		return result;
	}

	public LogVo login(LogVo login) throws Exception{
		cont = getConnection();
		LogVo result = dao.login(cont,login);
		close(cont);
		return result;
	}

	public int checkStudent(ValueObject check) throws Exception{
		cont = getConnection();
		int result = dao.checkStudent(cont,check);
		close(cont);
		return result;
	}

	public int insertRecode(ValueObject check)throws Exception {
		cont = getConnection();
		int result = dml.insertRecord(cont,check);
		if(result > 0) commit(cont);
		else			rollback(cont);
		return result;
	}

	public int loginAdmin(LogVo login) throws Exception{
		cont = getConnection();
		int admin = dao.adminCheck(cont,login);
		close(cont);
		return admin;
	}

	public int dpcStudentNo(String studentNo) throws Exception {
		cont = getConnection();
		int dpc = dao.dpcStudentNo(cont,studentNo);
		close(cont);
		return dpc;
	}

	public int insertStudents(ArrayList<ValueObject> insertStudents) throws Exception {
		cont = getConnection();
		int result = dml.insertStudents(cont,insertStudents);
		if(result >0) commit(cont);
		else		 rollback(cont);
		close(cont);
		return result;
	}

	public List<ValueObject> PAAC() throws Exception{
		cont = getConnection();
		List<ValueObject> PAAC = dao.PAAC(cont);
		close(cont);
		return PAAC;
	}

	public int accessY(int accountNo)throws Exception {
		cont = getConnection();
		int result = dml.accessY(cont,accountNo);
		if(result >0) commit(cont);
		else		  rollback(cont);
		return result;
	}

	public ValueObject accountCheck(ValueObject accountNo) throws Exception{
		cont = getConnection();
		ValueObject accountCheck = dml.accountCheck(cont, accountNo);
		if(accountCheck != null) {
			commit(cont);
		}else {
			rollback(cont);
		}
		close(cont);
		return accountCheck;
	}

	public int updateGrade() throws Exception{
		cont = getConnection();
		int result = dml.updateGrade(cont);
		if(result >0) commit(cont);
		else		  rollback(cont);
		return result;
	}


	
}
