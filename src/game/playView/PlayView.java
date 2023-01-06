package game.playView;

import game.GameView;
import objects.GameObject;
import utilities.Vector2D;
import game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayView extends JPanel {
    Game model;

    public PlayView(Game model) {
        this.model = model;

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(GameView.XResolution, GameView.YResolution - 240));
        this.setBackground(Color.orange);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        GameObject[] gameObjects = model.GetGameObjects();

        for (GameObject gameObject : gameObjects) {
            BufferedImage image = gameObject.GetGameObjectImage();
            Vector2D pos = gameObject.getCurrentPosition();
            
            g.drawImage(image, (int)pos.x, (int)pos.y, null);
        }
    }
}
