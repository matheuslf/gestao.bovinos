package lucas.tcc.gestao.bovinos.web.error;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ApiError(
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        String path
) {
    public static ApiError of(HttpStatus status, String message, String path){
        return new ApiError(LocalDateTime.now(), status.value(), status.getReasonPhrase(), message, path);
    }
}
