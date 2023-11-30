package supporty.info.mystory.content.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import supporty.info.mystory.common.utils.Msg;


/**
 * packageName    : supporty.info.mystory.content.controller
 * fileName       : contentController
 * author         : TaeJeongPark
 * date           : 2023-11-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-30        TaeJeongPark       최초 생성
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/content")
public class contentController {

    @GetMapping("/correctSentence")
    public ResponseEntity<Msg> correctSentence() {
        
    }

}
