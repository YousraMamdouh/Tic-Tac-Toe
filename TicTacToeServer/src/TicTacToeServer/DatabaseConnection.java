package TicTacToeServer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    private static ResultSet resultSet;
    private static Connection connection;

    private static void startConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "41352");
        } catch (SQLException e) {
            System.out.println("Database Connection Failed!");
        }
    }

    static String playerAuth(Player player) throws SQLException {
        startConnection();
        String result = "Failed";
        PreparedStatement checkUser = connection.prepareStatement("select * from tic_tac_toe.player where email = ? and password = ?");
        checkUser.setString(1, player.getEmail());
        checkUser.setString(2, player.getPassword());
        resultSet = checkUser.executeQuery();
        if (resultSet.next()) {
            result = "Success";
        }
        endConnection();
        return result;
    }

    static void registerPlayer(Player player) throws SQLException {
        startConnection();
        PreparedStatement registerPlayer = connection.prepareStatement("insert into tic_tac_toe.player values(?, ?, ?, ?, ? ,?)");
        registerPlayer.setInt(1, player.getPlayer_id());
        registerPlayer.setString(2, player.getName());
        registerPlayer.setString(3, "Not Used In Game");
        registerPlayer.setInt(4, player.getScore());
        registerPlayer.setString(5, player.getEmail());
        registerPlayer.setString(6, player.getPassword());
        registerPlayer.executeUpdate();
        endConnection();
    }

    static void insertGame(GameHistory game) throws SQLException {
        startConnection();
        PreparedStatement insertGame = connection.prepareStatement("insert into tic_tac_toe.game values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now())");
        insertGame.setInt(1, 0);
        insertGame.setInt(2, game.getPlayerOne());
        insertGame.setInt(3, game.getPlayerTwo());
        insertGame.setInt(4, game.getOrder()[0]);
        insertGame.setInt(5, game.getOrder()[1]);
        insertGame.setInt(6, game.getOrder()[2]);
        insertGame.setInt(7, game.getOrder()[3]);
        insertGame.setInt(8, game.getOrder()[4]);
        insertGame.setInt(9, game.getOrder()[5]);
        insertGame.setInt(10, game.getOrder()[6]);
        insertGame.setInt(11, game.getOrder()[7]);
        insertGame.setInt(12, game.getOrder()[8]);
        insertGame.setInt(13, game.getWinnerName());

        insertGame.executeUpdate();
        endConnection();
    }

    private static void updateResultSet(String statement) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(statement, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultSet = preparedStatement.executeQuery();
    }

    public static Player getPlayer(String username) {
        startConnection();
        Player player = null;
        ResultSet rs;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from player where user_name = ?");
            preparedStatement.setString(1, username);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                player = new Player(rs.getInt("player_id"),
                        rs.getString("user_name"),
                        rs.getInt("score"),
                        rs.getString("email"));
            }
            endConnection();
        } catch (SQLException e) {
            System.out.println("Couldn't fetch player data");
        }

        return player;
    }

    public static List<Player> getPlayerList() {
        startConnection();
        List<Player> playerList = new ArrayList<>();
        try {
            updateResultSet("select * from tic_tac_toe.player");
            while (resultSet.next()) {
                playerList.add(new Player(resultSet.getInt("player_id"),
                        resultSet.getString("user_name"),
                        resultSet.getInt("score"),
                        resultSet.getString("email")));
            }
            endConnection();
        } catch (SQLException e) {
            System.out.println("Couldn't fetch players data");
        }
        return playerList;
    }

    public static List<GameHistory> getGameHistoryList() {
        startConnection();
        List<GameHistory> gameHistoryList = new ArrayList<>();
        try {
            updateResultSet("select * from tic_tac_toe.game");
            while (resultSet.next()) {
                gameHistoryList.add(new GameHistory(resultSet.getInt("game_id"),
                        resultSet.getInt("player1_id"),
                        resultSet.getInt("player2_id"),
                        new int[]{
                                resultSet.getInt("cell_zero"),
                                resultSet.getInt("cell_1"),
                                resultSet.getInt("cell_2"),
                                resultSet.getInt("cell_3"),
                                resultSet.getInt("cell_4"),
                                resultSet.getInt("cell_5"),
                                resultSet.getInt("cell_6"),
                                resultSet.getInt("cell_7"),
                                resultSet.getInt("cell_8")},
                        resultSet.getInt("winner"),
                        resultSet.getTimestamp("game_date")));
            }
            endConnection();
        } catch (SQLException e) {
            System.out.println("Couldn't fetch game data");
        }
        return gameHistoryList;
    }

    private static void endConnection() throws SQLException {
        connection.close();
    }
}
