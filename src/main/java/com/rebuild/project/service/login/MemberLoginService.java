package com.rebuild.project.service.login;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rebuild.project.dao.login.*;
import com.rebuild.project.dao.point.PointDAO;
import com.rebuild.project.dao.profileImg.ProfileImgDAO;
import com.rebuild.project.vo.login.MemberInfoVO;
import com.rebuild.project.vo.login.MemberLoginVO;
import com.rebuild.project.vo.point.PointVO;
import com.rebuild.project.vo.profileImg.ProfileImgVO;

@Service
public class MemberLoginService{
	@Autowired
	private MemberLoginDAO mld;
	
	@Autowired
	private MemberInfoDAO mid;
	
	@Autowired
	private PointDAO pd;
	
	@Autowired
	private ProfileImgDAO pid;
	
	//아이디 중복확인
	public MemberLoginVO idCheck(HashMap<String, Object> hm) {
		return mld.idCheck(hm);
	}
	//카카오 유저 확인
	public MemberLoginVO kakaoIdCheck(HashMap<String, Object> hm) {
		return mld.kakaoIdCheck(hm);
	}
	//전체 아이디 확인
	public List<MemberLoginVO> allIdCheck(HashMap<String, Object> hm) {
		return mld.allIdCheck(hm);
	}
	//현재 비밀번호 일치 여부 확인
	public MemberLoginVO checkPwd(HashMap<String, Object> hm) {
		return mld.checkPwd(hm);
	}
	//현재 비밀번호, 아이디로 비밀번호 업데이트
	public int changePwd(HashMap<String, Object> hm) {
		return mld.changePwd(hm);
	}
	//a 올취페이지 통해 회원가입시 트랜잭션 처리를 위해 인터페이스 상속
	@Transactional
	public int joinMember(HttpSession session, MemberLoginVO mlv, MemberInfoVO miv) throws Exception{
//		인터페이스로 상속을 받아 진행한 상황에서 발생(캐스팅 오류 발생)
//		a Object data 타입을 hashmap으로 변환시 cast 경고 발생 / dto클래스를 따로 만들거나
//		a 방법이 없을 경우 @supresswarning 어노테이션 추가하여 경고창만 없앰(실질적인 해결방법은 아님..)
//		HashMap<String, Object> hm = (HashMap<String, Object>) data;
		//a 받아온 아이디와 비밀번호를 vo에 넣어서 필요한 정보와 같이 DB에 저장
		MemberLoginVO imlv = new MemberLoginVO(0, mlv.getId(), mlv.getPwd(), 0, 0, null, 'n', "n");
		int a = mld.join(imlv);
		//a 회원가입시 1000포인트 적립 / s => save[적립]
		PointVO pv = new PointVO(0, imlv.getMl_num(), 1000, "회원가입적립", null, 's');
		int a1 = pd.insert(pv);
		
		//a 실제 업로드 경로를 변수에 담기
		String realPath = session.getServletContext().getRealPath("/resources/img/profile-defaultImg.jpg");
		//a 기본 이미지 파일 읽어와 DB에 저장하기
		File file = new File(realPath);
//		File file = new File("C:/Users/JHTA/git/Allchwi_final/FinalProject_Allchwi/src/main/webapp/resources/img/profile-defaultImg.jpg");
		String fileName = file.getName();
		byte[] imageByte = null;
		try {
			//a 파일을 바이트 배열로 저장하기
			imageByte = Files.readAllBytes(file.toPath());
		} catch (IOException e) {
			//a 오류시 
			e.printStackTrace();
		}
		//session을 통해 이미지를 바이트 배열로 받고, 해당 파일 이름을 넣어서 DB에 저장
		ProfileImgVO piv = new ProfileImgVO(0, imageByte, fileName, null);
		int a2 = pid.insert(piv);
		
		//a 참조키를 받아야하므로 제일 마지막에 저장, 이름을 vo에 넣고 DB에 저장
		MemberInfoVO imiv = new MemberInfoVO(0, imlv.getMl_num(), piv.getPro_num(), miv.getMb_name(), null, null, null, 0, null, null);
		int a3 = mid.SignIn(imiv);
		
		int result = a + a1 + a2 + a3;
		return result;
	}
	//a 올취페이지로 회원가입한 회원의 현재 비밀번호 일치 여부 확인
	public int loginCheck(MemberLoginVO mlv) {
		MemberLoginVO result = mld.loginCheck(mlv);
		//a 아이디 비밀번호 일치시
		if(result != null) {
			//a 회원탈퇴 여부 확인
			int loginAuth = result.getLogin_auth();
			if(loginAuth == 0) {
				//a 로그인 성공
				return 1;
			} else {
				//a 탈퇴처리된 아이디 
				return 2;
			}
		} else {
			//a 아이디 및 비밀번호 불일치
			return 3;
		}
	}
	//a 로그인정보 - vo로 리턴
	public MemberLoginVO sessionInfo(MemberLoginVO mlv) {
		return mld.loginCheck(mlv);
	}
	//a 로그아웃(올취 회원가입 유저)
	public void logout(HttpSession session) {
		session.removeAttribute("ml_num");
	    session.removeAttribute("tutor_auth");
	    session.removeAttribute("access_Token");
		//a 세션무효화 -> 세션에 담긴 값들을 모두 초기화
		session.invalidate();
	}
	public MemberLoginVO loginInfo(HashMap<String, Object> hm) {
		return mld.loginInfo(hm);
	}
	//kakao 로그인 후 미가입 회원 가입시 트랜잭션 처리
		@Transactional
		public int kakaoJoinMember(HttpSession session, MemberLoginVO mlv, MemberInfoVO miv) throws Exception{
			//a 받아온 아이디와 비밀번호, 카카오고유아이디를  vo에 넣어서 필요한 정보와 같이 DB에 저장
			MemberLoginVO imlv = new MemberLoginVO(0, mlv.getId(), null, 0, 0, null, 'n', mlv.getKakaoUser());
			int a = mld.join(imlv);
			//a 회원가입시 1000포인트 적립 / s => save[적립]
			PointVO pv = new PointVO(0, imlv.getMl_num(), 1000, "회원가입적립", null, 's');
			int a1 = pd.insert(pv);
			
			//a 실제 업로드 경로를 변수에 담기
			String realPath = session.getServletContext().getRealPath("/resources/img/profile-defaultImg.jpg");
			//a 기본 이미지 파일 읽어와 DB에 저장하기
			File file = new File(realPath);
//			File file = new File("C:/Users/JHTA/git/Allchwi_final/FinalProject_Allchwi/src/main/webapp/resources/img/profile-defaultImg.jpg");
			String fileName = file.getName();
			byte[] imageByte = null;
			try {
				//a 파일을 바이트 배열로 저장하기
				imageByte = Files.readAllBytes(file.toPath());
			} catch (IOException e) {
				//a 오류시 
				e.printStackTrace();
			}
			//session을 통해 이미지를 바이트 배열로 받고, 해당 파일 이름을 넣어서 DB에 저장
			ProfileImgVO piv = new ProfileImgVO(0, imageByte, fileName, null);
			int a2 = pid.insert(piv);
			
			//a 참조키를 받아야하므로 제일 마지막에 저장, 이름을 vo에 넣고 DB에 저장
			MemberInfoVO imiv = new MemberInfoVO(0, imlv.getMl_num(), piv.getPro_num(), miv.getMb_name(), null, miv.getMb_nickname(), null, 0, null, null);
			int a3 = mid.SignIn(imiv);
			
			int result = a + a1 + a2 + a3;
			return result;
		}
		public void tutorAuth(int ml_num) {
			mld.tutorAuth(ml_num);
		}
}
