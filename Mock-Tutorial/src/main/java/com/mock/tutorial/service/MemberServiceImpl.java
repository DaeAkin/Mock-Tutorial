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
		memberDao.insertMember(member);
		mailSender.sendMail(member.getId());
	}

}
