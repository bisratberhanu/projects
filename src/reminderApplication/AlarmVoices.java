package reminderApplication;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class AlarmVoices   {
	public static  String[] voiceslist= {"voice 1", "voice 2","voice 3","voice 4","voice 5"};
	
	public static String[] voiceGetter(){
		return voiceslist;
	}
	static AudioInputStream audioSI;
	static Clip clip;
	public static void  alarmSound(String voicelocation) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		File file= new File(voicelocation);
		audioSI= AudioSystem.getAudioInputStream(file);
		clip= AudioSystem.getClip();
		clip.open(audioSI);
		clip.start();
		JOptionPane.showMessageDialog(null,"you have selected your voice sucessfully");
	}
	}


class VoiceListener extends AlarmVoices implements ItemListener{
	public  void itemStateChanged(ItemEvent e) {
		if (e.getStateChange()==ItemEvent.SELECTED) {
			try {
			if(ProjectGui.alarmvoicebox.getSelectedItem().toString().equals("voice 1") ) {
				AlarmVoices.alarmSound("1.wav");
				clip.close();}
			else if(ProjectGui.alarmvoicebox.getSelectedItem().toString().equals("voice 2")) {
				AlarmVoices.alarmSound("2.wav");
				clip.close();}
			else if(ProjectGui.alarmvoicebox.getSelectedItem().toString().equals("voice 3")) {
				AlarmVoices.alarmSound("3.wav");
				clip.close();}
			else if(ProjectGui.alarmvoicebox.getSelectedItem().toString().equals("voice 4")) {
				AlarmVoices.alarmSound("4.wav");
				clip.close();}
			else if(ProjectGui.alarmvoicebox.getSelectedItem().toString().equals("voice 5")) {
				AlarmVoices.alarmSound("5.wav");
				clip.close();}
			
			}
				
			catch (UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		
	}
	 
		
	
	

