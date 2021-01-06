package com.sujit.builder;

public class User {

    private String name;
    private String email;
    private int age;

    //public User(){}
    private User(UserBuilder userBuilder){
        this.name = userBuilder.name;
        this.email = userBuilder.email;
        this.age = userBuilder.age;

    }
    public String toString(){
        return "USER  " + this.name +"  " + this.email + "  " + this.age;
    }

    public static class UserBuilder {
        private String name;
        private String email;
        private int age;

        public UserBuilder(String name){
            this.name = name;
        }

        public UserBuilder email(String email){
            this.email = email;
            return this;
        }
        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            User user = new User(this);
            return user;
        }
    }
}
