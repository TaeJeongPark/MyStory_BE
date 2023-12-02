package supporty.info.mystory.content.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import supporty.info.mystory.common.utils.Msg;
import supporty.info.mystory.content.dto.ContentRequestDto;
import supporty.info.mystory.content.service.ContentService;
import supporty.info.mystory.user.dto.UserDto;

/**
 * packageName    : supporty.info.mystory.content.controller
 * fileName       : ContentController
 * author         : TaeJeongPark
 * date           : 2023-12-02
 * description    : Content Controller
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-02        TaeJeongPark       최초 생성
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/content")
public class ContentController {

    private final ContentService contentService;    // Content Business Logic

    @PostMapping("/save")
    public ResponseEntity<Msg> saveContent(@RequestBody ContentRequestDto contentRequestDto) throws Exception {

        log.info(String.valueOf(contentRequestDto));
        boolean result = contentService.saveContent(contentRequestDto);

        return ResponseEntity.ok().body(new Msg(result ? "Success" : "Failed", result));

    }

}
