package supporty.info.mystory.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * packageName    : com.pip.picks.common.entity
 * fileName       : Msg
 * author         : TaeJeongPark
 * date           : 2023-11-30
 * description    : Front에 전달할 데이터를 담는 메시지 엔티티
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-04        TaeJeongPark       최초 생성
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Msg {

    private String msg;
    private Object result;

    public Msg(String msg, Object result) {
        this.msg = msg;
        this.result  = result;
    }

}
