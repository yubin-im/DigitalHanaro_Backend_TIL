package com.study.ex22tdd;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultDTO {
    // {"status": "ok", "message": "로그인 성공"}
    private String status;
    private String message;

}
