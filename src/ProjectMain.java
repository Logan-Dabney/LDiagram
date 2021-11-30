import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * Written by Logan Dabney 11/13/18
 * Project2 extends JFrame to create a GUI specified for the L-system
 */
public class ProjectMain extends JFrame {
    public ProjectMain() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("L-System");
    }
    public static void main(String[] args){
        ProjectMain background = new ProjectMain();

        // Panels that holds all the buttons, etc.
        JPanel contentPanel = new JPanel();
        contentPanel.setPreferredSize(new Dimension(1100, 950));
        contentPanel.setLayout(new GridBagLayout());
        GridBagConstraints placement = new GridBagConstraints();
        Border blackLine = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);

        // Title Label
        JLabel titleLabel = new JLabel("Project 2:");
        titleLabel.setFont(new Font("Serif",Font.BOLD, 25));
        placement.insets = new Insets(0, 0, 0, 10);
        placement.gridwidth = 2;
        placement.gridx = 0;
        placement.gridy = 0;
        contentPanel.add(titleLabel, placement);

        // Rule 1 TextField and Label
        JLabel rule1Label = new JLabel("Rule 1:");
        rule1Label.setFont(new Font("Serif",Font.PLAIN, 20));
        placement.fill = GridBagConstraints.HORIZONTAL;
        placement.insets = new Insets(10, 0, 2, 2);
        placement.gridwidth = 1;
        placement.gridx = 0;
        placement.gridy = 1;
        contentPanel.add(rule1Label, placement);

        JTextField rule1Text = new JTextField();
        rule1Text.setPreferredSize(new Dimension(100,25));
        placement.gridx = 1;
        placement.gridy = 1;
        contentPanel.add(rule1Text, placement);

        // Rule 2 TextField and Label
        JLabel rule2Label = new JLabel("Rule 2:");
        rule2Label.setFont(new Font("Serif",Font.PLAIN, 20));
        placement.insets = new Insets(2, 0, 2, 2);
        placement.gridx = 0;
        placement.gridy = 2;
        contentPanel.add(rule2Label, placement);

        JTextField rule2Text = new JTextField();
        rule2Text.setPreferredSize(new Dimension(100,25));
        placement.gridx = 1;
        placement.gridy = 2;
        contentPanel.add(rule2Text, placement);

        // Rule 3 TextField and Label
        JLabel rule3Label = new JLabel("Rule 3:");
        rule3Label.setFont(new Font("Serif",Font.PLAIN, 20));
        placement.gridx = 0;
        placement.gridy = 3;
        contentPanel.add(rule3Label, placement);

        JTextField rule3Text = new JTextField();
        rule3Text.setPreferredSize(new Dimension(100,25));
        placement.gridx = 1;
        placement.gridy = 3;
        contentPanel.add(rule3Text, placement);

        // Rule 4 TextField and Label
        JLabel rule4Label = new JLabel("Rule 4:");
        rule4Label.setFont(new Font("Serif",Font.PLAIN, 20));
        placement.gridx = 0;
        placement.gridy = 4;
        contentPanel.add(rule4Label, placement);

        JTextField rule4Text = new JTextField();
        rule4Text.setPreferredSize(new Dimension(100,25));
        placement.gridx = 1;
        placement.gridy = 4;
        contentPanel.add(rule4Text, placement);

        // Rule 5 TextField and Label
        JLabel rule5Label = new JLabel("Rule 5:");
        rule5Label.setFont(new Font("Serif",Font.PLAIN, 20));
        placement.gridx = 0;
        placement.gridy = 5;
        contentPanel.add(rule5Label, placement);

        JTextField rule5Text = new JTextField();
        rule5Text.setPreferredSize(new Dimension(100,25));
        placement.gridx = 1;
        placement.gridy = 5;
        contentPanel.add(rule5Text, placement);

        // Combobox for the starting positions
        String[] startPos = {"Center", "Bottom Left", "Top Left", "Left Center", "Bottom Center"};
        JComboBox<String> startPosComboBox = new JComboBox<>(startPos);
        placement.insets = new Insets(2, 0, 2, 15);
        placement.gridx = 8;
        placement.gridy = 35;
        contentPanel.add(startPosComboBox, placement);

        // Angle's Label and TextField
        JLabel angleLabel = new JLabel("Enter Angle:");
        placement.insets = new Insets(2, 0, 2, 2);
        angleLabel.setFont(new Font("Serif",Font.PLAIN, 20));
        placement.gridx = 2;
        placement.gridy = 35;
        contentPanel.add(angleLabel, placement);

        JTextField angleText = new JTextField();
        placement.insets = new Insets(2, 2, 2, 15);
        angleText.setPreferredSize(new Dimension(50,25));
        placement.gridx = 3;
        placement.gridy = 35;
        contentPanel.add(angleText, placement);

        // Label and Spinner for iteration selection
        JLabel runtimeLabel = new JLabel("Enter iterations:");
        placement.insets = new Insets(2, 2, 2, 2);
        runtimeLabel.setFont(new Font("Serif",Font.PLAIN, 20));
        placement.gridx = 4;
        placement.gridy = 35;
        contentPanel.add(runtimeLabel, placement);

        JSpinner runtimeSpinner = new JSpinner();
        placement.insets = new Insets(2, 2, 2, 15);
        runtimeSpinner.setPreferredSize(new Dimension(40,30));
        placement.gridx = 5;
        placement.gridy = 35;
        contentPanel.add(runtimeSpinner, placement);

        // Starting letter for L-System Label and TextField
        JLabel startFnLabel = new JLabel("Starting Letter:");
        placement.insets = new Insets(2, 2, 2, 2);
        startFnLabel.setFont(new Font("Serif",Font.PLAIN, 20));
        placement.gridx = 6;
        placement.gridy = 35;
        contentPanel.add(startFnLabel, placement);

        JTextField startFnText = new JTextField();
        placement.insets = new Insets(2, 2, 2, 15);
        startFnText.setPreferredSize(new Dimension(100,25));
        placement.gridx = 7;
        placement.gridy = 35;
        contentPanel.add(startFnText, placement);

        // Button used to start operations
        JButton create = new JButton("Start");
        placement.insets = new Insets(2, 2, 2, 2);
        placement.gridx = 9;
        placement.gridy = 35;
        placement.gridwidth = 1;
        placement.fill = GridBagConstraints.HORIZONTAL;
        contentPanel.add(create, placement);

        // Panel that holds the canvas when created
        JPanel canvasPanel = new JPanel();
        canvasPanel.setPreferredSize(new Dimension(900,900));
        placement.insets = new Insets(0, 2, 2,0) ;
        placement.gridx = 2;
        placement.gridy = 0;
        placement.gridwidth = 34;
        placement.gridheight = 34;
        canvasPanel.setBorder(blackLine);
        canvasPanel.setBackground(Color.white);
        contentPanel.add(canvasPanel, placement);

        background.add(contentPanel);
        background.pack();
        background.setLocationRelativeTo(null);
        background.setVisible(true);
/**
 *
 */
        create.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                canvasPanel.removeAll();
                LDiagram info = null;
                try {
                    info = new LDiagram(rule1Text.getText(), rule2Text.getText(), rule3Text.getText(),
                            rule4Text.getText(),rule5Text.getText(), startFnText.getText().toUpperCase(),
                            (int)runtimeSpinner.getValue());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                CanvasFrame canvasTest = null;
                try {
                    canvasTest = new CanvasFrame(info.getEndFunction(), Double.valueOf(angleText.getText()),
                            (String)Objects.requireNonNull(startPosComboBox.getSelectedItem()));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                canvasTest.setPreferredSize(new Dimension(900,900));
                canvasPanel.add(canvasTest);
                canvasPanel.revalidate();
                background.revalidate();
                contentPanel.revalidate();
            }
            }
        );
    }
}
