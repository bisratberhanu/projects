package reminderApplication;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.sound.sampled.*;
import javax.swing.*;


public class Alarm extends Listeners  {
	
	static String myTime;
	String[] s = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20",
			"21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45",
			"46","47","48","49","50","51","52","53","54","55","56","57","58","59",};
	String[] s2= {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20",
			"21","22","23"};
	
	JPanel panel1= new JPanel();
	JPanel panel2= new JPanel();
	JPanel panel2s= new JPanel();

	JPanel panel2s1= new JPanel();
	JPanel panel2s2= new JPanel();

	
	
	
	JButton setalarm= new JButton("set alarm");
	JButton datebutton= new JButton("date");
	JLabel hour= new JLabel("hour");
	JLabel minutes= new JLabel("min");
	
	JComboBox hourbox= new JComboBox(s2);
	JComboBox minbox= new JComboBox(s);
	
	
	Calendar calendar;
	
	static SimpleDateFormat timeFormat=  new SimpleDateFormat("HH:mm:ss");
	 
	static AudioInputStream audioSI;
	static Clip clip;
	
	public static void  alarmSoundforalarm(String voicelocation) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		File file= new File(voicelocation);
		audioSI= AudioSystem.getAudioInputStream(file);
		clip= AudioSystem.getClip();
		clip.open(audioSI);
		clip.start();
		clip.loop(5);
		JOptionPane.showMessageDialog(null,"alarm alarm");
	}
	
		
	
	 
class datebuttonlistener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		Cal calander= new Cal();
		if(e.getSource()==datebutton) {
			
			calander.setVisible(true); }
	}
	
	

}
}
