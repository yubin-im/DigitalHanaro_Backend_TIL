package com.study.ex04lombok;

import jakarta.annotation.Nullable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Member {
    private String name;
    @NonNull
    private String phone;
    @Nullable
    private String email;

}
