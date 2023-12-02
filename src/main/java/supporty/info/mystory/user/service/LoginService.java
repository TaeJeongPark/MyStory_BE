package supporty.info.mystory.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;

import supporty.info.mystory.user.dto.UserDto;
import supporty.info.mystory.user.entity.User;
import supporty.info.mystory.user.repository.UserRepository;

/**
 * packageName    : supporty.info.mystory.user.service
 * fileName       : LoginService
 * author         : TaeJeongPark
 * date           : 2023-12-01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-01        TaeJeongPark       최초 생성
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    @Value("${kakao.client.id}")
    private String KAKAO_CLIENT_ID;

    @Value("${kakao.client.secret}")
    private String KAKAO_CLIENT_SECRET;

    @Value("${kakao.redirect.url}")
    private String KAKAO_REDIRECT_URL;

    private final static String KAKAO_AUTH_URI = "https://kauth.kakao.com";
    private final static String KAKAO_API_URI = "https://kapi.kakao.com";

    private final UserRepository userRepository;    // 사용자 레포지토리

    // 인가코드로 토큰 발급
    public Long getKakaoInfo(String code) throws Exception {

        if (code == null) throw new Exception("Failed get authorization code");

        String idToken = "";
        String accessToken = "";
        String refreshToken = "";
        Long expiresIn;
//        Long refreshTokenExpiresIn;

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-type", "application/x-www-form-urlencoded");

            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("grant_type"   , "authorization_code");
            params.add("client_id"    , KAKAO_CLIENT_ID);
            params.add("client_secret", KAKAO_CLIENT_SECRET);
            params.add("code"         , code);
            params.add("redirect_uri" , KAKAO_REDIRECT_URL);

            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    KAKAO_AUTH_URI + "/oauth/token",
                    HttpMethod.POST,
                    httpEntity,
                    String.class
            );

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObj = (JSONObject) jsonParser.parse(response.getBody());

            log.info(String.valueOf(jsonObj));

            idToken = (String) jsonObj.get("id_token");
            accessToken  = (String) jsonObj.get("access_token");
            refreshToken = (String) jsonObj.get("refresh_token");
            expiresIn = (Long) jsonObj.get("expires_in");
//            refreshTokenExpiresIn = (Long) jsonObj.get("refresh_token_expires_in");

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("KAKAO API call failed");
        }

        log.info("==========> accessToken : " + accessToken);

        return getUserInfoWithToken(accessToken);

    }

    // 액세스 토큰으로 사용자 정보 가져오기
    @Transactional(readOnly = true)
    public Long getUserInfoWithToken(String accessToken) throws Exception {

        //HttpHeader 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        //HttpHeader 담기
        RestTemplate rt = new RestTemplate();
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> response = rt.exchange(
                KAKAO_API_URI + "/v2/user/me",
                HttpMethod.POST,
                httpEntity,
                String.class
        );

        //Response 데이터 파싱
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObj    = (JSONObject) jsonParser.parse(response.getBody());
//        JSONObject account = (JSONObject) jsonObj.get("kakao_account");
//        JSONObject profile = (JSONObject) account.get("profile");

        Long id = (Long) jsonObj.get("id"); // 유니크 아이디 정보 가져오기
//        String email = String.valueOf(account.get("email"));
//        String nickname = String.valueOf(profile.get("nickname"));

        log.info("==========> id : " + id);

        // 사용자 존재 유무 조회
        User user = userRepository.findById(id)
                .orElseThrow(() -> new Exception("사용자 정보가 없습니다."));

        if(user == null) {
            UserDto userDto = UserDto.builder()
                    .userId(id)
                    .lastLoginAt(LocalDateTime.now())
                    .build();

            User newUser = userDto.dtoToEntity();

            userRepository.save(newUser);
        }

        return id;

    }

    // 회원가입
    @Transactional
    public boolean join(Long id, String accessToken) throws Exception {
        User check = userRepository.findAccessTokenById(id);

        log.info("==========> check : " + check);

        if(check == null) {
            UserDto userDto = UserDto.builder()
                    .userId(id)
                    .accessToken(accessToken)
                    .lastLoginAt(LocalDateTime.now())
                    .build();

            User newUser = userDto.dtoToEntity();
            userRepository.save(newUser);

            log.info("==========> 회원가입 성공");
        }

        return true;
    }

    // 사용자 정보 업데이트
    @Transactional
    public boolean updateUserInfo(Long id, String accessToken) throws Exception {

        if(id == null) throw new Exception("Failed get id");
        if(accessToken == null) throw new Exception("Failed get accessToken");

        // 사용자 조회
        User user = userRepository.findById(id)
                .orElseThrow(() -> new Exception("Failed get user"));

        log.info("==========> check : " + user);

        if(user != null) {
            user.setAccessToken(accessToken);
            user.setLastLoginAt(LocalDateTime.now());
            userRepository.save(user);

            log.info("==========> 사용자 정보 업데이트 성공");

            return true;
        }

        return false;

    }

}
