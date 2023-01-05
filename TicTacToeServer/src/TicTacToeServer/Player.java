package TicTacToeServer;

public class Player {
    private int player_id;
    private String name;
    private int score;
    private String email;
    private String password;


    public Player(String name, String email, String password) {
        this.player_id = 0;
        this.name = name;
        this.score = 0;
        this.email = email;
        this.password = password;
    }

    public Player(int player_id, String name, int score, String email) {
        this.player_id = player_id;
        this.name = name;
        this.score = score;
        this.email = email;
        this.password = "null";
    }

    public int getPlayer_id() {
        return player_id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
