package springsideproject1.springsideproject1build.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private Long identifier;
    private String id;
    private String password;
    private String name;
    private Integer year;
    private Integer month;
    private Integer date;
    private String phoneNumber;
}
