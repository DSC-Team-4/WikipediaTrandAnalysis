package DCS4.kafka.dto;

import lombok.*;

@Getter // 필드에 대한 getter 자동 생성
@Builder // 빌더 패턴 자동 생성
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestDTO {

    private String name;
    private String age;
    private String id;
    private String department;

    // 기존 생성자는 제거하거나 주석 처리하세요.
    // public TestDTO(String test, int age) {
    //     this.test = test;
    //     this.age = age;
    // }
}
