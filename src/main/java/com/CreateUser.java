package com;

import org.apache.commons.lang3.RandomStringUtils;

public class CreateUser {
    private static String name;
    private static String password;
    private static String email;
    private static String invalidPassword;

    public static String getName(){
        return name = RandomStringUtils.randomAlphabetic(10);
    }

    public static String getPassword(){
        return password = RandomStringUtils.randomAlphabetic(10);
    }

    public static String getInvalidPassword(){
        return invalidPassword = RandomStringUtils.randomAlphabetic(5);
    }

    public static String getEmail(){
        return email = RandomStringUtils.randomAlphabetic(6) + "@yandex.ru";
    }
}
