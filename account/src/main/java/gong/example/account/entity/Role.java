package gong.example.account.entity;

public enum Role {
    ADMIN("관리자"), CLIENT("사용자");
    private String name;

    Role(String s) {
        this.name = s;
    }
}
