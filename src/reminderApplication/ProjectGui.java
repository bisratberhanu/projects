package reminderApplication;
import java.time.LocalDate;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import reminderApplication.Cal.listener;

public  class   ProjectGui extends Alarm implements ActionListener {
	// this class implements the graphics user interface of the application
	static String myAlarm;
	static ArrayList alarmStore= new ArrayList<String>();
	ImageIcon image = new ImageIcon("remi.jpg");
	
	 
	JPanel panel1= new JPanel();
	
	JPanel panel2= new JPanel();
	JPanel panels1= new JPanel();  // s shows that the panel is a smaller panel
	JPanel panels2= new JPanel();
	JPanel panels3= new JPanel();
	JPanel panels4= new JPanel();
	JPanel panelss1= new JPanel();
	JPanel panelss2= new JPanel();
	JPanel panelss3= new JPanel();// ss4 and ss5 ar3e for panel2
	JPanel panelss4= new JPanel();
	
	
	JLabel year= new JLabel("year");
	JLabel month= new JLabel("month");
	JLabel day= new JLabel("day");
	JLabel alarmvoices= new JLabel("alarm voices ");
	
	JButton savebutton= new JButton("add note(save)");
	JButton alarmbutton= new JButton("alarm");
	JButton getnotebutton = new JButton("getnote");
	
	
	static JComboBox yearbox= new JComboBox();
	static JComboBox monthbox= new JComboBox();
	static JComboBox daybox= new JComboBox();
	static JComboBox alarmvoicebox= new JComboBox(AlarmVoices.voiceGetter());
	
	static JTextArea field = new JTextArea("write your text here");
	
	ProjectGui(){
		setIconImage(image.getImage());
		
		setTitle("Reminder Application");
		setSize(700,700);
		Container c= getContentPane();
		c.setLayout(new GridLayout(2,1));
		//yearbox.addItem();
		field.setLineWrap(true);
		
		
		panels1.add(year);
		panels1.add(yearbox);
		panels2.add(month);
		panels2.add(monthbox);
		panels3.add(day);
		panels3.add(daybox);
		panelss1.add(alarmbutton);
		panelss2.add(alarmvoices);
		panelss2.add(alarmvoicebox);
		panels4.setLayout(new GridLayout(2,1));
		panels4.add(panelss1);
		panels4.add(panelss2);
		panelss3.setLayout(new GridLayout(1,1));
		panelss3.add(field);
		panelss4.setLayout(new GridLayout(2,1));
		panelss4.add(getnotebutton);
		panelss4.add(savebutton);
		panel1.setLayout(new GridLayout(1,4));
		panel1.add(panels1);
		panel1.add(panels2);
		panel1.add(panels3);
		panel1.add(panels4);
		//panels1.setBackground(Color.green);
		
		panel2.setLayout(new GridLayout(1,2));
		panel2.add(panelss3);
		panel2.add(panelss4);
		// coloring
		 panel2.setBackground(Color.LIGHT_GRAY); 
		 panels1.setBackground(Color.LIGHT_GRAY); 
		 panels2.setBackground(Color.LIGHT_GRAY); 
		 panels3.setBackground(Color.LIGHT_GRAY);   
		 panels4.setBackground(Color.LIGHT_GRAY); 
		 panelss1.setBackground(Color.LIGHT_GRAY); 
		 panelss2.setBackground(Color.LIGHT_GRAY); 
		 panelss3.setBackground(Color.LIGHT_GRAY); // ss4 and ss5 ar3e for panel2
		 panelss4.setBackground(Color.LIGHT_GRAY); 
		
		 
		 yearbox.setBackground(Color.WHITE);
		 monthbox.setBackground(Color.WHITE);
		 daybox.setBackground(Color.WHITE);
		 alarmvoicebox.setBackground(Color.WHITE);
		 
		 savebutton.setBackground(Color.lightGray);
		 alarmbutton.setBackground(Color.WHITE);

		 getnotebutton.setBackground(Color.DARK_GRAY);
		 getnotebutton.setForeground(Color.WHITE);


		 

		
		// action listener implementation
		alarmbutton.addActionListener(this);
		alarmvoicebox.addItemListener(new VoiceListener());
		monthbox.addItemListener(new Listeners.MonthListener());
		 savebutton.addActionListener(new AddNoteListener() );
		 getnotebutton.addActionListener(new GetNoteListener());
		 daybox.addItemListener(new DayListener());
		 yearbox.addItemListener(new YearListener());
		//filling the Jcomboboxes
		for(int year=0;year < DateList.getYears().size();year++) {
			yearbox.addItem(DateList.getYears().get(year));
		}
		for(int month=0;month < DateList.getMonths().size();month++) {
			monthbox.addItem(DateList.getMonths().get(month));
		}
		
		Date date = new Date();
		for(int day=0;day < DateList.getValidDays(date).size();day++) {
			daybox.addItem(DateList.getValidDays(date).get(day));
		}
		yearbox.setSelectedItem(date.getYear());	
		monthbox.setSelectedIndex(date.getMonth()-1);
		daybox.setSelectedItem(date.getDay());
		
		
		
		
	
		
		
		c.add(panel1);
		c.add(panel2);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		
		
		}
	
	static JTextField field1= new JTextField("h");
	
	ProjectGui(String x){
		ImageIcon image = new ImageIcon("logo.jpg");
		setIconImage(image.getImage());
		
		setTitle("My Alarm");
		
		panel1.setLayout(new GridLayout(1,1));
		panel1.add(field1);
		 panel2s1.add(hour);
		 panel2s1.add(hourbox);
		 
		 //COLORING FOR ALARM COMPONENTS
		 hourbox.setBackground(Color.WHITE);
		 minbox.setBackground(Color.WHITE);
		 
		 
		 setalarm.setBackground(Color.LIGHT_GRAY);
		 datebutton.setBackground(Color.LIGHT_GRAY);

		 
		 panel2s2.add(minutes);
		 panel2s2.add(minbox);
		 
		 panel2s.add(panel2s1);
		 panel2s.add(panel2s2);
		 panel2s.add(setalarm);
		panel2s.setLayout(new GridLayout(1,3));
		panel2.setLayout(new GridLayout(1,2));
		panel2.add(datebutton);
		panel2.add(panel2s);
		
		
		
		 //action listeners
		listen l = new listen() ;
		hourbox.addActionListener( l );
		minbox.addActionListener( l );
		setalarm.addActionListener( l );
		
		
		
		setSize(400,400);
		Container c= getContentPane();
		c.setLayout(new GridLayout(2,1));
		c.add(panel1);
		c.add(panel2);
		//setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//adding listeners
		datebutton.addActionListener(new datebuttonlistener());
		setVisible(true);
		
	}
		

		static String monthCheck = Integer.toString((Calendar.getInstance().MONTH));
		static String dayCheck = Integer.toString((Calendar.getInstance().DATE));
		
		 
		 
		
		public static  void setTime() {
			
			while(true) {
				String today = LocalDate.now().toString();
				
				myTime = timeFormat.format(Calendar.getInstance().getTime());
					
		        field1.setText(myTime);
		        System.out.println(Cal.dateString);
		        System.out.println(today);
		        
		        
		        
		        if((alarmStore.contains(field1.getText())) && (Cal.dateString.equals(today))){  
		        	
		        		try {
		        			if(ProjectGui.alarmvoicebox.getSelectedItem().toString().equals("voice 1") ) {
		        				alarmSoundforalarm("1.wav");
		        				clip.close();
		        				
		        			}
		        			
		        			else if(ProjectGui.alarmvoicebox.getSelectedItem().toString().equals("voice 2")) {
		        				alarmSoundforalarm("2.wav");
		        				clip.close();
		        					
		        			}
		        			else if(ProjectGui.alarmvoicebox.getSelectedItem().toString().equals("voice 3")) {
		        				alarmSoundforalarm("3.wav");
		        				clip.close();
		        				
		        			}
		        			else if(ProjectGui.alarmvoicebox.getSelectedItem().toString().equals("voice 4")) {
		        				alarmSoundforalarm("4.wav");
		        				clip.close();}
		        			else if(ProjectGui.alarmvoicebox.getSelectedItem().toString().equals("voice 5")) {
		        				alarmSoundforalarm("5.wav");
		        				clip.close();
		        				}
						} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
		    	}
		        try {
		        	Thread.sleep(1000);
		        }
		        catch(InterruptedException e){
		        	 e.printStackTrace();
		        }}
			}
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==alarmbutton) {
				new ProjectGui("foralarm");
				
				}
				}
		 class listen implements ActionListener{
			 

				String alstr;
				String hostr;
				String minstr="00:00";
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(e.getSource()==hourbox){
		            	alstr = "";
		            	hostr = "";
		            	hostr += (hourbox.getSelectedItem() + ":" );
		            	alstr += hostr + minstr;
		            }
		            
		            if(e.getSource() == minbox){
		            	alstr = "";
		            	minstr = "";
		            	minstr = (minbox.getSelectedItem() + ":00");
		            	alstr += hostr + minstr;
		            	
		        		}
		            
		            if(e.getSource() == setalarm) {
		            	myAlarm = alstr;
		            	alarmStore.add(myAlarm);
		            	//for(int i=0;i<alarmStore.size();i++) {
		            		//System.out.println(alarmStore.get(i));
		            	//}
		            	
		            	
		        		
		            }
				}
		}
		 
		 
		 // main method 
		 
public static void main(String[]args) {
		
		new ProjectGui();
		setTime();
		
	}
	//
}


