package supporty.info.mystory.content.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import supporty.info.mystory.common.utils.Msg;
import supporty.info.mystory.content.dto.ContentDto;
import supporty.info.mystory.content.dto.ContentListResponseDto;
import supporty.info.mystory.content.service.ContentService;

import java.util.List;

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
    public ResponseEntity<Msg> saveContent(@RequestBody ContentDto contentDto) throws Exception {

        log.info(String.valueOf(contentDto));
        boolean result = contentService.saveContent(contentDto);

        return ResponseEntity.ok().body(new Msg(result ? "Success" : "Failed", result));

    }

    @GetMapping("/list")
    public ResponseEntity<Msg> getContentList(@RequestParam Long id) throws Exception {

        List<ContentListResponseDto> result = contentService.getContentList(id);

        return ResponseEntity.ok().body(new Msg((result != null) ? "Success" : "Failed", result));

    }

    @GetMapping("/detail")
    public ResponseEntity<Msg> getContentDetail(@RequestParam Long id) throws Exception {

        ContentDto result = contentService.getContentDetail(id);

        return ResponseEntity.ok().body(new Msg((result != null) ? "Success" : "Failed", result));

    }

}
