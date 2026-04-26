package lab11.timus;

import java.io.PrintWriter;
import java.util.*;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=2002">2002. Тестовое задание</a>
 */
public class t2002 {
    private static final Scanner in = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);
    private static final List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        try {
            run();
        } finally {
            in.close();
            out.flush();
        }
    }

    static void run(){
        in.nextLine();
        while(in.hasNextLine()){
            String[] command = in.nextLine().split(" ");
            switch(command[0]){
                case "register": register(command[1], command[2]); break;
                case "login": login(command[1], command[2]); break;
                case "logout": logout(command[1]); break;
            }
        }
    }

    static void register(String login, String password) {
        User user = search(login);
        if(user != null) { System.out.println("fail: user already exists"); return; }

        users.add(new User(login, password));
        System.out.println("success: new user added");
    }

    static void login(String login, String password) {
        User user = search(login);
        if(user == null) { System.out.println("fail: no such user"); return; }
        user.login(login, password);
    }

    static void logout(String login) {
        User user = search(login);
        if(user == null) { System.out.println("fail: no such user"); return; }
        user.logout();
    }

    static User search(String login) {
        for (User user : users) {
            if(login.equals(user.getLogin())) {
                return user;
            }
        }
        return null;
    }

    private static class User {
        public User(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public void login(String login, String password) {
            if(!login.equals(this.login)) System.out.println("fail: no such user");
            else if(!password.equals(this.password)) System.out.println("fail: incorrect password");
            else if(state == 1) System.out.println("fail: already logged in");
            else { System.out.println("success: user logged in"); state = 1; }
        }

        public void logout() {
            if(state == 0) {
                System.out.println("fail: already logged out");
                return;
            }

            state = 0;
            System.out.println("success: user logged out");
        }

        public String getLogin() {
            return login;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(login, user.login);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(login);
        }

        private final String login;
        private int state = 0; //not logged
        private final transient String password;
    }
}
