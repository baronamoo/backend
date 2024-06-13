package com.baronamoo.recorder.gui;

import lombok.Getter;

import javax.swing.*;

@Getter
public class BaronamooGui extends JFrame {

    private static BaronamooGui instance;

    public BaronamooGui() {

        JPanel panel = new JPanel();
        JLabel idL = new JLabel("ID : ");
        JLabel pwL = new JLabel("PASSWORD : ");
        JTextField id = new JTextField(10);
        JPasswordField pw = new JPasswordField(10);
        JButton loginBtn = new JButton("LOGIN");

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

            JOptionPane.showMessageDialog(panel, "Credentials set successfully!");
        });
        add(panel);

        setVisible(true);	//창을 눈에 보이도록 함
        setSize(640, 480);	//사이즈는 640*480
        setResizable(false);	//사이즈 재조정 불가능
        setLocationRelativeTo(null);	//창이 가운데에 뜨도록 함
        setDefaultCloseOperation(EXIT_ON_CLOSE);	//창을 끄면 프로그램을 종료
    }

    public static synchronized BaronamooGui getInstance() {
        if (instance == null) {
            instance = new BaronamooGui();
        }
        return instance;
    }
}
