package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListener implements ActionListener {
    Game game;
    GameView view;

    public TimerListener(Game game, GameView view) {
        this.game = game;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Where all the updates are called
        game.update();
        view.draw();
    }
}
