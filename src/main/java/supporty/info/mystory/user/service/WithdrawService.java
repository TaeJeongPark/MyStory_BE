package supporty.info.mystory.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import supporty.info.mystory.user.repository.UserRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * packageName    : supporty.info.mystory.user.service
 * fileName       : WithdrawService
 * author         : TaeJeongPark
 * date           : 2023-12-03
 * description    : 회원탈퇴 Service
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-03        TaeJeongPark       최초 생성
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class WithdrawService {

    private final UserRepository userRepository;                                // 사용자 Repository

    private final static String KAKAO_API_URI = "https://kapi.kakao.com";

    // 액세스 토큰으로 카카오 연결 해제
    public boolean kakaoWithdraw(String accessToken, Long id) throws Exception {

        if(accessToken == null || accessToken.length() < 1) throw new Exception("Failed get accessToken");

        int responseCode = 0;

        try {
            URL url = new URL(KAKAO_API_URI + "/v1/user/unlink");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + accessToken);

            responseCode = conn.getResponseCode();
            log.info("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String result = "";
            String line = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }

            log.info(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
//        return deleteUserInfo(id);

    }

    // 액세스 토큰으로 사용자 정보 가져오기
//    private Long getUserInfoWithToken(String accessToken) throws Exception {
//
//        if(accessToken == null || accessToken.length() < 1) throw new Exception("Failed get accessToken");
//
//        return userRepository.findByAccessToken(accessToken).getId();
//
//    }

    private boolean deleteUserInfo(Long id) throws Exception {

        if(id == null) throw new Exception("Failed get id");

        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
