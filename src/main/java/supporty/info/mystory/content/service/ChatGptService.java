package supporty.info.mystory.content.service;

import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * packageName    : supporty.info.mystory.content.service
 * fileName       : ChatGptService
 * author         : TaeJeongPark
 * date           : 2023-11-30
 * description    : ChatGPT Business Logic
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-30        TaeJeongPark       최초 생성
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ChatGptService {

    private final ChatgptService chatGptService;

    public String getChatGpt(String sentence) {

        sentence += "이 내용을 300자 정도의 글자 수로 첨삭 해줘.";
        String result = chatGptService.sendMessage(sentence);    // ChatGptService에서 sendMessage()를 호출하여 챗봇의 답변을 받아 옴
        result = result.replaceAll("\n", "");    // 개행 문자 제거

        return result;

    }

}
