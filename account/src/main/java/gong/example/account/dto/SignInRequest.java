package gong.example.account.dto;

import gong.example.account.entity.Role;
import lombok.Data;

@Data
public class SignInRequest {
    private final String email;
    private final String phoneNo;
    private final String userId;
    private final String password;
    private final Role role;
    private final String nickName;
}
