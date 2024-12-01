package ru.naumen.collection.task2;

import java.util.Arrays;
import java.util.Objects;

/**
 * Пользователь
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class User {
    private String username;
    private String email;
    private byte[] passwordHash;

    public String getUsername() {
        return username;
    }

    public String getEmail(){return email;}

    public byte[] getPasswordHash(){return passwordHash;}

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(!(obj instanceof User other)) {
            return false;
        }
        if(other.hashCode() == this.hashCode()){
            return Objects.equals(this.username, other.getUsername()) &&
                    Objects.equals(this.email, other.getEmail()) &&
                    Arrays.equals(this.passwordHash, other.getPasswordHash());
        }
        return false;
    }

    @Override
    public int hashCode(){
        int hash = username.hashCode() * 31;
        hash += email.hashCode() * 31;
        hash += Arrays.hashCode(passwordHash);
        return hash;
    }
}
