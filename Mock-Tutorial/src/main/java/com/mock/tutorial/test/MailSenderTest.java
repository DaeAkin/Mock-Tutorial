package com.mock.tutorial.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.mock.tutorial.dao.MemberDao;
import com.mock.tutorial.dto.MemberDto;
import com.mock.tutorial.service.MailSender;
import com.mock.tutorial.service.MemberServiceImpl;

public class MailSenderTest {

	@Test
	public void mockMailSenderTest() {

		MemberServiceImpl memberServiceImpl = new MemberServiceImpl();
		//MemberDao 목 생성 
		MemberDao mockMemberDao = mock(MemberDao.class);
		//MailSender 목 생성
		MailSender mockMailSender = mock(MailSender.class);
		
		memberServiceImpl.setMailSender(mockMailSender);
		
		memberServiceImpl.setMemberDao(mockMemberDao);
	
		MemberDto member = new MemberDto("foo", "1234");
		//스텁 생성 
		//Dao의 insertMember가 호출되면 0을 리턴하라는 뜻
		when(mockMemberDao.insertMember(member)).thenReturn(1);
		
		//foo라는 유저 회원가입
		memberServiceImpl.insertMember(member);
		
		// sendMail() 함수가 1번 호출되었는지 확인
		verify(mockMailSender, times(1)).sendMail("foo");
	}
	
}

