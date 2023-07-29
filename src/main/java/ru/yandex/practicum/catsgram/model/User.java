package ru.yandex.practicum.catsgram.model;

import java.time.LocalDate;

public class User {
    private String email;
    private String nickname;
    private LocalDate birthdate;

    public User(String email, String nickname, LocalDate birthdate) {
        this.email = email;
        this.nickname = nickname;
        this.birthdate = birthdate;
    }



    public String getNickname() {
        return nickname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    @Override
    public int hashCode() {
            int result = email == null ? 0 : email.hashCode();
        return result*29;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass() !=obj.getClass()) return false;
        User user = (User) obj;
        return  email == user.email ;
    }

    public String getEmail() {
        return email;
    }
}