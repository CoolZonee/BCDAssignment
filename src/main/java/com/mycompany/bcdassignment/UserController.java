package com.mycompany.bcdassignment;

import com.mycompany.bcdassignment.Entities.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    private List<User> userList;
    private static UserController instance;

    private UserController() {}

    public static UserController getInstance () {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }

    public List<User> getUserList() {
        getUsersFromTxt();
        return userList;
    }

    private void getUsersFromTxt () {
        List<User> users = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(Constant.USER_TEXT_PATH));
            lines.forEach(line -> {
                String[] user = line.split(",");
                users.add(new User(
                        user[0],
                        user[1],
                        user[2].charAt(0),
                        user[3],
                        user[4],
                        user[5],
                        user[6],
                        user[7]
                        ));
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        userList = users;
    }
}
