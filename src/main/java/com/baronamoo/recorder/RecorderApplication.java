package com.baronamoo.recorder;

import com.baronamoo.recorder.gui.BaronamooGui;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class RecorderApplication {

	public static void main(String[] args) {
		BaronamooGui gui = new BaronamooGui();

		while (!gui.isWindowClosed()){
			try{
				Thread.sleep(100);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
        }
		try{
			SpringApplication.run(RecorderApplication.class, args);
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "잘못된 입력입니다. 데이터 베이스의 아이디와 비밀번호를 다시 확인해주세요", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

}
