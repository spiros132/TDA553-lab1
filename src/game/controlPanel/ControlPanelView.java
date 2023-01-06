package game.controlPanel;

import game.GameView;
import game.controlPanel.listeners.*;

import javax.swing.*;
import java.awt.*;

public class ControlPanelView extends JPanel {
    private ControlPanel model;

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Turbo on");
    JButton turboOffButton = new JButton("Turbo off");
    JButton liftBedButton = new JButton("Raise Bed");
    JButton lowerBedButton = new JButton("Lower Bed");

    JButton startAllEngineButton = new JButton("Start All Cars");
    JButton stopAllEngineButton = new JButton("Stop All Cars");
    
    public ControlPanelView(ControlPanel model) {
        this.model = model;

        setupUI();
    }

    private void setupUI(){
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new GasSpinnerChangeListener(this.model));

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        // Setup the grid layout of the buttons
        this.setLayout(new GridLayout(2,4));

        this.add(gasButton, 0);
        this.add(turboOnButton, 1);
        this.add(liftBedButton, 2);
        this.add(brakeButton, 3);
        this.add(turboOffButton, 4);
        this.add(lowerBedButton, 5);
        this.setPreferredSize(new Dimension((GameView.XResolution/2)+4, 200));
        this.setBackground(Color.YELLOW);

        startAllEngineButton.setBackground(Color.blue);
        startAllEngineButton.setForeground(Color.green);
        startAllEngineButton.setPreferredSize(new Dimension(GameView.XResolution/5-15,200));
        startAllEngineButton.addActionListener(new StartAllEngineButtonListener(model));
        this.add(startAllEngineButton);

        stopAllEngineButton.setBackground(Color.red);
        stopAllEngineButton.setForeground(Color.black);
        stopAllEngineButton.setPreferredSize(new Dimension(GameView.XResolution/5-15,200));
        stopAllEngineButton.addActionListener(new StopAllEngineButtonListener(model));
        this.add(stopAllEngineButton);

        // Setup all the different listeners / controllers for the buttons
        gasButton.addActionListener(new GasButtonListener(model));
        turboOnButton.addActionListener(new TurboOnButtonListener(model));
        liftBedButton.addActionListener(new LiftBedButtonListener(model));
        brakeButton.addActionListener(new BrakeButtonListener(model));
        turboOffButton.addActionListener(new TurboOffButtonListener(model));
        lowerBedButton.addActionListener(new LowerBedButtonListener(model));
    }
}
