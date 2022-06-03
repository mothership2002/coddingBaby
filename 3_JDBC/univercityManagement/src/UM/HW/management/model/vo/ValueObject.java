package UM.HW.management.model.vo;

import java.sql.Date;

public class ValueObject {
	
	//학생
	private String studentNo;
	private String studentName;
	private String studentSSN; //나이로 사용할예정 int변환
	private String studentPhone;
	private String studentEmail;
	private String studentAdress;
	private int studentGrade; //학년
	private String studentDepartment;
	private Date admission;		//입학
	private String admissoinString;
	private int studentAge;
	
	//교수
	private int accountNo;
	private String proName;
	private String proSSN;
	private String proPhone;
	private String proEmail;
	private String proDepartment;
	private int proAge;
	private char access_YN;


	//학생 성적 입력
	private String className;
	private double studenRecord;
	//학생이름 
	
	//학과 추가용
	private String departMentName;
	private String deptCategory;
	private String openYN;
	private String capacity;
	
	//수업 추가용
	//학과 이름
	//수업 이름
	private String classType;
	
	//계정구별
	
	
	public ValueObject() {	}
	

	public ValueObject(String studentNo, String studentName, String studentSSN, String studentPhone,
			String studentEmail, String studentAdress, int studentGrade, String studentDepartment,
			String admissoinString) {
		super();
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentSSN = studentSSN;
		this.studentPhone = studentPhone;
		this.studentEmail = studentEmail;
		this.studentAdress = studentAdress;
		this.studentGrade = studentGrade;
		this.studentDepartment = studentDepartment;
		this.admissoinString = admissoinString;
	}




	//학생 정보용 생성자
	public ValueObject(String studentNo,String studentName, int studentAge, String studentPhone, String studentEmail,
			String studentAdress, int studentGrade, String studentDepartment, Date admission) {
		super();
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentPhone = studentPhone;
		this.studentEmail = studentEmail;
		this.studentAdress = studentAdress;
		this.studentGrade = studentGrade;
		this.studentDepartment = studentDepartment;
		this.admission = admission;
	}

	//교수 정보용 생성자
	public ValueObject(String proName, int proAge, String proPhone, String proEmail, String proDepartment) {
		super();
		this.proName = proName;
		this.proAge = proAge;
		this.proPhone = proPhone;
		this.proEmail = proEmail;
		this.proDepartment = proDepartment;
	}
	
	//학생 성적 입력 생성자
	public ValueObject(String studentName, String className, double studenRecord) {
		super();
		this.studentName = studentName;
		this.className = className;
		this.studenRecord = studenRecord;
	}

	//학과 추가용 생성자
	public ValueObject(String departMentName, String deptCategory, String openYN, String capacity) {
		super();
		this.departMentName = departMentName;
		this.deptCategory = deptCategory;
		this.openYN = openYN;
		this.capacity = capacity;
	}

	public ValueObject(String className, String departMentName, String classType) {
		super();
		this.className = className;
		this.departMentName = departMentName;
		this.classType = classType;
	}
	
	public char getAccess_YN() {
		return access_YN;
	}


	public void setAccess_YN(char access_YN) {
		this.access_YN = access_YN;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSSN() {
		return studentSSN;
	}

	public void setStudentSSN(String studentSSN) {
		this.studentSSN = studentSSN;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentAdress() {
		return studentAdress;
	}

	public void setStudentAdress(String studentAdress) {
		this.studentAdress = studentAdress;
	}

	public int getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(int studentGrade) {
		this.studentGrade = studentGrade;
	}

	public String getStudentDepartment() {
		return studentDepartment;
	}

	public void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}

	public Date getAdmission() {
		return admission;
	}

	public void setAdmission(Date admission) {
		this.admission = admission;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProSSN() {
		return proSSN;
	}

	public void setProSSN(String proSSN) {
		this.proSSN = proSSN;
	}

	public String getProPhone() {
		return proPhone;
	}

	public void setProPhone(String proPhone) {
		this.proPhone = proPhone;
	}

	public String getProEmail() {
		return proEmail;
	}

	public void setProEmail(String proEmail) {
		this.proEmail = proEmail;
	}

	public String getProDepartment() {
		return proDepartment;
	}

	public void setProDepartment(String proDepartment) {
		this.proDepartment = proDepartment;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public double getStudenRecord() {
		return studenRecord;
	}

	public void setStudenRecord(double studenRecord) {
		this.studenRecord = studenRecord;
	}

	public String getDepartMentName() {
		return departMentName;
	}

	public void setDepartMentName(String departMentName) {
		this.departMentName = departMentName;
	}

	public String getDeptCategory() {
		return deptCategory;
	}

	public void setDeptCategory(String deptCategory) {
		this.deptCategory = deptCategory;
	}

	public String getOpenYN() {
		return openYN;
	}

	public void setOpenYN(String openYN) {
		this.openYN = openYN;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public int getProAge() {
		return proAge;
	}

	public void setProAge(int proAge) {
		this.proAge = proAge;
	}


	public String getAdmissoinString() {
		return admissoinString;
	}


	public void setAdmissoinString(String admissoinString) {
		this.admissoinString = admissoinString;
	}


	public int getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	
	
	
	
}
