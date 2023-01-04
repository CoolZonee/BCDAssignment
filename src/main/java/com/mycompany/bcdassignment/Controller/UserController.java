package com.mycompany.bcdassignment.Controller;

import com.mycompany.bcdassignment.Constant;
import com.mycompany.bcdassignment.Entities.User;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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

    public void addUser(User user) throws Exception {
        userList = getUserList();
        if (userList.stream().anyMatch(u -> u.getUsername().equals(user.getUsername()))) {
            throw new Exception ("Username existed!");
        } else {
            userList.add(user);
            put();
        }
    }

    public void put()  {
        StringBuilder input = new StringBuilder();

        for(User user: userList) {
            input.append(user.toString()).append("\n");
        }

        try {
            Files.writeString(Paths.get(Constant.USER_TEXT_PATH), input, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
