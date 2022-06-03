package UM.HW.management.model.vo;

public class LogVo {
	
	private String accountId;
	private String accountPw;
	private String accountName;
	private String accountSSN;
	private char access_YN;
	private String accountDept;

	public LogVo() { }


	public LogVo(String accountId, String accountPw, String accountName, String accountSSN, String accountDept) {
		super();
		this.accountId = accountId;
		this.accountPw = accountPw;
		this.accountName = accountName;
		this.accountSSN = accountSSN;
		this.accountDept = accountDept;
	}


	public LogVo(String accountId, String accountPw) {
		super();
		this.accountId = accountId;
		this.accountPw = accountPw;
	}


	public String getAccountId() {
		return accountId;
	}


	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}


	public String getAccountPw() {
		return accountPw;
	}


	public void setAccountPw(String accountPw) {
		this.accountPw = accountPw;
	}


	public String getAccountName() {
		return accountName;
	}


	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}


	public String getAccountSSN() {
		return accountSSN;
	}


	public void setAccountSSN(String accountSSN) {
		this.accountSSN = accountSSN;
	}


	public char getAccess_YN() {
		return access_YN;
	}


	public void setAccess_YN(char access_YN) {
		this.access_YN = access_YN;
	}


	public String getAccountDept() {
		return accountDept;
	}


	public void setAccountDept(String accountDept) {
		this.accountDept = accountDept;
	}
	
	
}
