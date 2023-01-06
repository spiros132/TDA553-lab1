package game;

import javax.swing.*;
import java.awt.*;

import game.controlPanel.ControlPanelView;
import game.playView.PlayView;

public class GameView extends JFrame {
    public static final int XResolution = 800;
    public static final int YResolution = 800;

    Game model;
    ControlPanelView controlPanelView;
    PlayView playView;

    public GameView(Game model) {
        this.model = model;
        
        initializeComponents();
    }

    private void initializeComponents() {
        initializeMainWindow();

        setupControlPanel();
        setupPlayView();

        openWindow();
    }

    private void initializeMainWindow() {
        this.setTitle("Car Game");
        this.setSize(new Dimension(XResolution, YResolution));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    }

    private void setupControlPanel() {
        controlPanelView = new ControlPanelView(model.getControlPanel());

        this.add(controlPanelView);
    }

    private void setupPlayView() {
        playView = new PlayView(model);

        this.add(playView);
    }

    private void openWindow() {
        // Make the frame pack all the components
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void draw() {
        playView.repaint();
    }
}
