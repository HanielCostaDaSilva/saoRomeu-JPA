package model;

public class Usuario {

    private String nickname;
    private String password;

    public Usuario(String nickName, String password) {
        this.nickname = nickName;
        this.password = password;
    }

    public void setNickName(String newNickname) {
        this.nickname = newNickname;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getPassword() {
        return this.password;
    }

    public String toString() {
        return "nickname:" + this.nickname + ", password:" + this.password;
    }

}
