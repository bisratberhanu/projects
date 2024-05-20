package reminderApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class Listeners extends JFrame  {
	// a class that holds many of the  action listeners  
	

	
	
	
 class MonthListener extends JFrame implements ItemListener{
	 public Date date =  new Date();
	
	public  void itemStateChanged(ItemEvent e) {
		
		if (e.getStateChange()==ItemEvent.SELECTED) {
			
			date.setMonth((ProjectGui.monthbox.getSelectedIndex()+1));
			DateList.getValidDays(date);}
		ProjectGui.field.setText("write your to do list");
		

	}
 }
 class DayListener implements ItemListener{

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		ProjectGui.field.setText("write your to do list");

		
	}
	 
 }
 class YearListener implements ItemListener{

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange()==ItemEvent.SELECTED) {
		ProjectGui.field.setText("write your to do list");}
		
	}
	 
 }
 

 ArrayList datestore= new ArrayList();
 ArrayList notestore= new ArrayList();
 class AddNoteListener implements ActionListener{
	 String s="";

	@Override
	public void actionPerformed(ActionEvent e) {
		String tempstr=(ProjectGui.yearbox.getSelectedItem()).toString()+(ProjectGui.monthbox.getSelectedItem()).toString()+(ProjectGui.daybox.getSelectedItem()).toString();
	    try {
		if(datestore.contains(tempstr)) {
	    	int x = datestore.indexOf(tempstr);
	    	notestore.set(x,ProjectGui.field.getText() );
	    }
	    else datestore.add(tempstr);
		
		String texttostore= ProjectGui.field.getText(); /// exception could be thrown.
		
		notestore.add(texttostore);}
		catch(Exception E) { notestore.add(" ");}
	}
 }
 
 class GetNoteListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String currdate= (ProjectGui.yearbox.getSelectedItem()).toString()+(ProjectGui.monthbox.getSelectedItem()).toString()+(ProjectGui.daybox.getSelectedItem()).toString();
		if(datestore.contains(currdate)) {
			int currnote= datestore.indexOf(currdate);
			ProjectGui.field.setText((String) notestore.get(currnote));
		}
	}
	 
 }   
 
 
}
 
		
		
		
		
	
	 
	 
 
