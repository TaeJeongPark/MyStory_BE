package supporty.info.mystory.common.utils;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * packageName    : supporty.info.mystory.common.entity
 * fileName       : BaseTimeEntity
 * author         : TaeJeongPark
 * date           : 2023-11-30
 * description    : 일시 관리 추상 클래스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-30        TaeJeongPark       최초 생성
 */
@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
@Getter
@Setter
public abstract class BaseTimeEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

}
