package hello.exception.api;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class RegisterDto {

    @NotBlank(message = "이메일은 공백일 수 없습니다")
    @Email(message = "이메일 형식을 지켜주세요")
    private String email;

    @NotEmpty(message = "패스워드를 입력해주세요")
    private String password;

    @NotEmpty(message = "이름을 입력해주세요")
    private String name;

}
