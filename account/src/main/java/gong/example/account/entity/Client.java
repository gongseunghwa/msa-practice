package gong.example.account.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Columns;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

//@Document(collation = "client")
@Getter
@AllArgsConstructor
@Builder
@Document(collection = "client")
public class Client {
    @Enumerated(EnumType.STRING)
    @Setter
    private Role role;

    @Id
    private String email;

    private String userId;
    @Setter
    private String password;
    private String userName;
    private String nickName;
    private String phoneNo;
    private boolean isAuthPhone;
    private boolean isAgreeCondition;
}
