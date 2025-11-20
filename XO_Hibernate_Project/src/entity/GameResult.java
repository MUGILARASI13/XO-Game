
package entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="game_result")
public class GameResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String playerX;
    private String playerO;
    private String winner;
    private LocalDateTime playedOn;

    public GameResult() {}

    public GameResult(String playerX, String playerO, String winner, LocalDateTime playedOn) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.winner = winner;
        this.playedOn = playedOn;
    }

    // getters and setters omitted for brevity
}
