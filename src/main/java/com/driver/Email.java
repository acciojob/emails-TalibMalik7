package com.driver;

import java.util.HashSet;

public class Email {

    private String emailId;
    private String password;

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(this.password.equals(oldPassword)){
           if(isValid(newPassword)){
               this.password = newPassword;
           }
        }
    }
    public boolean isValid(String s){
        boolean len = false;
       boolean digit = false;
       boolean lower = false;
       boolean upper = false;
       boolean special = false;
       int n = s.length();
       if(n>=8) len =true;
       else return false;
        for(int i  = 0;i<n;i++){
            char ch = s.charAt(i);

            if(Character.isLowerCase(ch)) lower = true;
            if(Character.isUpperCase(ch)) upper =true;
            if(Character.isDigit(ch)) digit = true;
            else special = true;

        }
       if(digit && lower && upper && special && len) return true;
       return false;
    }
}
