package list_jlabels_in_jpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.Border;

public class Test {

    public Test() {
        createAndShowUI();
    }

    private void createAndShowUI() {
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents(frame);

        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    private void initComponents(final JFrame frame) {

        final JPanel panel = new JPanel();

        JButton button = new JButton("Add label");

        button.addActionListener(new ActionListener() {
            int count = 1;

            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel _lbl = new JLabel("Label " + count);//make label and assign text in 1 line
                _lbl.setName("Label " + count);
                Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
                _lbl.setBorder(border);
                _lbl.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("Cliquei na label "+ e.getComponent().getName());
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                    }
                });
                panel.add(_lbl);//add label we made

                panel.revalidate();
                panel.repaint();

                frame.pack();//so our frame resizes to compensate for new components

                count++;
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test();
            }
        });
    }
}