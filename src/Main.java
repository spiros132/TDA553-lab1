import javax.swing.*;

import game.GameView;
import game.Game;
import game.TimerListener;

public class Main {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private static final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private static Timer timer;

    public static void main(String[] args) {
        System.out.println ("Spelet börjar");
        
        Game model = new Game();
        GameView view = new GameView(model);
        TimerListener timerListener = new TimerListener(model, view);

        // Starting the update loop
        timer = new Timer(delay, timerListener);
        timer.start();
    }
}
