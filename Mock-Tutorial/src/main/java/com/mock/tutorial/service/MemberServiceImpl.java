package com.mock.tutorial.service;

import com.mock.tutorial.dao.MemberDao;
import com.mock.tutorial.dto.MemberDto;

public class MemberServiceImpl implements MemberService{

	MailSender mailSender;
	
	MemberDao memberDao;
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	
	@Override
	public void insertMember(MemberDto member) {
		//dao를 통해 DB에 해당 member Insert
		memberDao.insertMember(member);
		//가입 축하 메일 보내기
		mailSender.sendMail(member.getId());
	}

}
