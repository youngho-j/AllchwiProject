package com.rebuild.project.service.login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class KakaoLoginService {
	//properties에 있는 값(clientid) 받아오기 위한 변수
	private String clientId;
	
	private String redirectUri;
	
	private String logOutUri;
	
	private String appKey;
	
	// setter로 변수에 값을 넣어줌
	@Value("${kl.clientid}")
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	// 받아온 값을 활용하기 위한 getter
	public String getClientId() {
		return clientId;
	}
	
	public String getRedirectUri() {
		return redirectUri;
	}

	@Value("${kl.redirecturi}")
	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}
	

	public String getLogOutUri() {
		return logOutUri;
	}
	
	@Value("${klo.redirecturi}")
	public void setLogOutUri(String logOutUri) {
		this.logOutUri = logOutUri;
	}
	
	public String getAppKey() {
		return appKey;
	}

	@Value("${map.appkey}")
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	// accessToken 받아오기
	public String getAccessToken(String authorize_code) {
		String access_Token = "";
		String refresh_Token = "";
		String reqURL = "https://kauth.kakao.com/oauth/token";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			// POST 요청을 위해 기본값이 false인 setDoOutput을 true로
			conn.setRequestMethod("POST");
			conn.setDoOutput(true); 

			// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=" + getClientId());
			sb.append("&redirect_uri=" + getRedirectUri());
			sb.append("&code=" + authorize_code);
			bw.write(sb.toString());
			bw.flush();

			// a 결과 코드가 200이라면 성공
			int responseCode = conn.getResponseCode();

			// a 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}

			// Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);

			access_Token = element.getAsJsonObject().get("access_token").getAsString();
			refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

			System.out.println("access_token : " + access_Token);
			System.out.println("refresh_token : " + refresh_Token);

			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return access_Token;
	}

	// a 카카오 회원정보 얻어오기
	public HashMap<String, Object> getUserInfo(String access_Token) {
		// 요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
		HashMap<String, Object> userInfo = new HashMap<>();
		String reqURL = "https://kapi.kakao.com/v2/user/me";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");

			// 요청에 필요한 Header에 포함될 내용
			conn.setRequestProperty("Authorization", "Bearer " + access_Token);

			int responseCode = conn.getResponseCode();

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}

			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
			JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
			//카카오 유저 구분을 위해 고유아이디값을 출력
			String kakaoId = element.getAsJsonObject().get("id").getAsString();
			//별명의 경우 필수 동의 이므로 가져올수 있음. 
			String nickname = properties.getAsJsonObject().get("nickname").getAsString();
			//이메일은 선택 동의 이므로 동의를 하지 않을 경우가 있을 수 있으므로 
			String email = "";
			//json의 이메일 정보가 담겨있는지 확인 후 담겨있을 경우
			if(kakao_account.getAsJsonObject().get("email") != null) {
				email = kakao_account.getAsJsonObject().get("email").getAsString();
			//이메일 정보가 없을 경우
			} else {
				email = "";
			}
			//map에 담아줌
			userInfo.put("nickname", nickname);
			userInfo.put("email", email);
			userInfo.put("kakaoUser", kakaoId);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return userInfo;
	}
}
