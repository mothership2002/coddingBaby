package edu.kh.SemiProject.member.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
	
	private int userNo;
	private String userID;
	private String userPW;
	private String userName;
	private String userNickname;
	private String userEmail;
	private String userTel;
	private String userProfile;
	private int point;
	private String grade;
	private String registDate;
	private String secession_Flag;
	
}