package TicTacToeServer;

import java.net.Socket;
public class Player {
    private int id;
    private final int status;
    private final String name;
    private int score;
    private String email;
    private final String password;
    private Socket socket;

    public Player(String name, String email, String password) {
        this.status = 1;
        this.id = 0;
        this.name = name;
        this.score = 0;
        this.email = email;
        this.password = password;
    }
    public Player(String name, int id, int status, int score, String email) {
        this.status = status;
        this.id = id;
        this.name = name;
        this.score = score;
        this.email = email;
        this.password = "N/A";
    }

    public Player(String name, String pswrd) {
        this.name = name;
        this.password = pswrd;
        this.status = 1;
    }

    public int getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}