package com.baronamoo.recorder.gui;

import lombok.Getter;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static java.lang.System.exit;

@Getter
public class BaronamooGui extends JFrame {

    private boolean isWindowClosed = false;

    public BaronamooGui() {

        JPanel panel = new JPanel();
        JLabel idL = new JLabel("DB ID : ");
        JLabel pwL = new JLabel("DB PASSWORD : ");
        JTextField id = new JTextField(10);
        JPasswordField pw = new JPasswordField(10);
        JButton loginBtn = new JButton("입력");

        panel.add(idL);
        panel.add(id);
        panel.add(pwL);
        panel.add(pw);
        panel.add(loginBtn);

        loginBtn.addActionListener(e -> {
            String databaseId = id.getText();
            String databasePwd = pw.getText();

            System.setProperty("BRONAMOO_DATASOURCE_ID", databaseId);
            System.setProperty("BRONAMOO_DATASOURCE_PASSWORD", databasePwd);

            JOptionPane.showMessageDialog(panel, "값이 입력되었습니다");
            isWindowClosed = true;
            dispose();
        });
        add(panel);

        setVisible(true);	//창을 눈에 보이도록 함
        setSize(540, 180);	//사이즈는 640*480
        setResizable(false);	//사이즈 재조정 불가능
        setLocationRelativeTo(null);	//창이 가운데에 뜨도록 함
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Custom close operation

        // Add a WindowListener to handle window closing event
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit(1);
            }
        });
    }

    public boolean isWindowClosed() {
        return isWindowClosed;
    }
}
