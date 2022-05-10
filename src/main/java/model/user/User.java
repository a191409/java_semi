package model.user;

import model.Default;

import java.sql.Timestamp;

public class User extends Default {
    private String email;
    private String pass;

    public User(
            Integer id,
            String email,
            String pass,
            Timestamp createdAt,
            Timestamp updatedAt
    ){
        //親クラス(Default)のコンストラクタを呼び出す
        super(id, createdAt, updatedAt);
        this.email = email;
        this.pass = pass;
    }

    //setメソッド
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    //getメソッド
    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }
}
