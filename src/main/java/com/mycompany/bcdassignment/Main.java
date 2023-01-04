package com.mycompany.bcdassignment;

import com.mycompany.bcdassignment.Entities.User;
import com.mycompany.bcdassignment.GUI.LoginPage;

public class Main {
    public static User currentUser;
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new LoginPage().setVisible(true));
    }
}
