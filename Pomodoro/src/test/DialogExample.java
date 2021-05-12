package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DialogExample extends JFrame
{
    private final static String DIALOG_TITLE = "Warning Dialog";
    private final static int DIALOG_ICON = JOptionPane.WARNING_MESSAGE;
    private final JButton openPopupBtn;

    public DialogExample()
    {
        this.openPopupBtn = new JButton("Open Dialog");

        this.openPopupBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(DialogExample.this, "You just opened a dialog.", DIALOG_TITLE, DIALOG_ICON);
            }
        });

        this.setTitle("Dialog Example");
        this.setSize(640,480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(this.openPopupBtn);
        this.setResizable(false);
    }

    public static void main(String[] args) {
        JFrame dialogExample = new DialogExample();
        dialogExample.setVisible(true);
    }
}