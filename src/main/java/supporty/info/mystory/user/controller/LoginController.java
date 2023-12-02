package supporty.info.mystory.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import supporty.info.mystory.common.utils.Msg;
import supporty.info.mystory.user.dto.UserDto;
import supporty.info.mystory.user.service.LoginService;

/**
 * packageName    : supporty.info.mystory.user.controller
 * fileName       : LoginController
 * author         : TaeJeongPark
 * date           : 2023-12-01
 * description    : 로그인 Controller
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-01        TaeJeongPark       최초 생성
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/kakao")
    public ResponseEntity<Msg> kakaoCallback(@RequestBody UserDto userDto) throws Exception {

        log.info(String.valueOf(userDto.getUserId()));
        log.info(userDto.getAccessToken());

        boolean result = loginService.join(Long.valueOf(userDto.getUserId()), userDto.getAccessToken());

        return ResponseEntity.ok().body(new Msg(result ? "Success" : "Failed", result));

    }

    @PostMapping("/update")
    public ResponseEntity<Msg> updateUserInfo(@RequestBody UserDto userDto) throws Exception {

        log.info(String.valueOf(userDto.getUserId()));
        log.info(userDto.getAccessToken());

        boolean result = loginService.updateUserInfo(Long.valueOf(userDto.getUserId()), userDto.getAccessToken());

        return ResponseEntity.ok().body(new Msg(result ? "Success" : "Failed", result));

    }

}
