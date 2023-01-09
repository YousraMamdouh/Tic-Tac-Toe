package tictactoeclient;

public class Player {

    private int player_id;
    private String user_name;
    private String full_name;
    private int score;
    private String email;
    private String password;

    public Player(int player_id, String user_name, int score, String email, String password) {
        this.player_id = player_id;
        this.user_name = user_name;
        this.full_name = full_name;
        this.score = score;
        this.email = email;
        this.password = password;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
