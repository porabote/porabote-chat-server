package user;

import auth.Auth;

import java.util.Scanner;

public class User implements IUser {

    private int id;
    private String name;
    private static boolean isAuth = false;


    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public static User login() {

        int userId = 0;
        String userName = "";

        Scanner scanner = new Scanner(System.in);

        while (!isAuth) {
            System.out.println("For enter to chat, please, enter your name:");
            userName = scanner.nextLine();

            userId = Auth.auth(userName, null);
            if (userId > 0) {
                isAuth = true;
            }
        }

        return new User(userId, userName);
    }
}
