package supporty.info.mystory.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import supporty.info.mystory.common.utils.Msg;
import supporty.info.mystory.user.dto.UserDto;
import supporty.info.mystory.user.service.WithdrawService;

/**
 * packageName    : supporty.info.mystory.user.controller
 * fileName       : WithdrawController
 * author         : TaeJeongPark
 * date           : 2023-12-03
 * description    : 회원탈퇴 Controller
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-03        TaeJeongPark       최초 생성
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/withdraw")
public class WithdrawController {

    private final WithdrawService withdrawService;  // 회원탈퇴 Business Logic

    @GetMapping("/kakao")
    public ResponseEntity<Msg> kakaoWithdraw(@RequestParam String accessToken, @RequestParam Long id) throws Exception {

        log.info(accessToken);

        boolean result = withdrawService.kakaoWithdraw(accessToken, id);

        return ResponseEntity.ok().body(new Msg(result ? "Success" : "Failed", result));

    }

}
