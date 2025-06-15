package hello.mvc.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 공통 응답용 DTO
@Getter
@AllArgsConstructor
public class ApiResponse<T> {
    private int code;
    private String message;
    private T data;
}
