package supporty.info.mystory.content.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import supporty.info.mystory.common.utils.Msg;
import supporty.info.mystory.content.dto.SentenceRequestDto;
import supporty.info.mystory.content.service.ChatGptService;

/**
 * packageName    : supporty.info.mystory.content.controller
 * fileName       : ChatGptController
 * author         : TaeJeongPark
 * date           : 2023-11-30
 * description    : ChatGPT Controller
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-30        TaeJeongPark       최초 생성
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/content")
public class ChatGptController {

    private final ChatGptService chatGptService;

    @PostMapping("/correctSentence")
    public ResponseEntity<Msg> correctSentence(@RequestBody SentenceRequestDto request) {

        log.info(request.getSentence());

        String result = chatGptService.getChatGpt(request.getSentence());

        log.info(result);

        if (result == null) {
            return ResponseEntity.ok().body(new Msg("AI 첨삭에 실패했습니다.", "failed"));
        } else {
            return ResponseEntity.ok().body(new Msg("AI 첨삭에 성공했습니다.", result));
        }

    }

}
