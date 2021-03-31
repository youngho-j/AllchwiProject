package com.rebuild.project.service.login;

import java.util.HashMap;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.rebuild.project.dao.login.MemberLoginDAO;
import com.rebuild.project.vo.login.MemberLoginVO;

@Service
public class MailSenderService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private MemberLoginDAO mld;

	//난수를이용해 비밀번호를 재생성하기
	private boolean lowerCheck;
	private int size;

	//비밀번호 난수 만들기 -> 메소드 있음.
	private String init() {
		Random rd = new Random();
		StringBuffer sb = new StringBuffer();
		int num = 0;
		do {
			num = rd.nextInt(89) + 33;
			// 범위 : 영어 -  소문자/대문자 숫자 -  1 ~ 9 / 특수문자 - !@#$%^&*()
			if ( num == 33 || (num >= 35 && num <= 38) || (num >= 40 && num <= 42) || (num >= 48 && num <= 57) || (num >= 64 && num <= 90) || (num >= 97 && num <= 122)) {
				//아스키코드로 변환 특문, 숫자, 대문자, 소문자
				sb.append((char) num);
			} else {
				continue;
			}

		} while (sb.length() < size);
		//9글자 만들고 나서 마지막에 특수문자 하나 추가해주기
		sb.append("!");
		//대소문자 구분 할건지 체크
		if (lowerCheck) {
			return sb.toString().toLowerCase();
		}
		return sb.toString();
	}
	//메소드 이용하여 변경된 비밀번호생성
	public String getKey(boolean lowerCheck, int size) {
		this.lowerCheck = lowerCheck;
		this.size = size;
		return init();
	}
	
	//비밀번호 변경하여 이메일 발송
	public void mailSendWithpassword(MemberLoginVO mlv, String sendEmail, Model model, HttpServletRequest req) {
		//아이디와 비밀번호를 담기 위한 hashmap 객체 생성
		HashMap<String, Object> hm = new HashMap<String, Object>();
		//변경된 비밀번호(9자리 + !추가 하여 10자리)
		String key = getKey(true, 9);
		//해쉬맵에 값 담아주기
		hm.put("id", mlv.getId());
		hm.put("pwd", key);
		//비밀번호 새로 생성하여 업데이트 
		int result = mld.searchPwd(hm);
		if(result == 1) {
			//비밀번호 변경 완료후 메일보내기
			MimeMessage mail = mailSender.createMimeMessage();
			String htmlStr = "<h2>Allchwi 비밀번호 인증메일입니다!</h2><br>" 
					+ "<h3>" + hm.get("id") + "님</h3>" 
					+ "<p> 회원님의 임시 비밀번호는 [ " + hm.get("pwd") + " ] 입니다.<br>" 
					+ "<a href='http://localhost:8084" + req.getContextPath() + "'>홈페이지 바로가기</a></p>";
			try {
				//제목
				mail.setSubject("[비밀번호 재발급] Allchwi 임시비밀번호 메일입니다", "utf-8");
				//내용
				mail.setText(htmlStr, "utf-8", "html");
				//입력한 메일주소로 이메일 보낼 주소 지정
				mail.addRecipient(RecipientType.TO, new InternetAddress(sendEmail));
				//메일 보내기
				mailSender.send(mail);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void sendMsg(String msg,String email) {
		MimeMessage mail = mailSender.createMimeMessage();
		String htmlStr = msg +"의 사유로 수업 거절되었습니다.";
		
		try {
			//제목
			mail.setSubject("[수업신청결과 입니다]","utf-8");
			//내용
			mail.setText(htmlStr,"utf-8","html");
			//입력한 메일주소로 이메일 보낼 주소 지정
			mail.addRecipient(RecipientType.TO, new InternetAddress(email));
			//메일보내기
			mailSender.send(mail);
		}catch(MessagingException e) {
			e.printStackTrace();
		}
	}
	
	
}
