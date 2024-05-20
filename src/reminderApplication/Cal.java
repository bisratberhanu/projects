package reminderApplication;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Cal extends JFrame {
	 
	
    private JLabel  date;
    private JButton title;
    //private JDateChooser calendar;
    private JDateChooser dateChooser;

    public Cal(){
        setSize(400,200);
        setTitle("alarm Calander");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(null);
        title = new JButton("done");
        date = new JLabel("Date : ");
        Font font = new Font("Arial", Font.ITALIC , 10);
        title.setFont(font);
        title.setForeground(Color.black);
        title.setBounds(200 , 50 , 100, 20);
        date = new JLabel("Date : ");
       
        
         dateChooser =new JDateChooser();
        dateChooser.setBounds(200 , 90 , 100 , 20);
        add(title);
        add(date);
        add(dateChooser);
        title.addActionListener(new listener());
        
        
        
    }
    static String dateString;
        public class listener   implements ActionListener{
        	
        	
			public void actionPerformed(ActionEvent e) {
				  dateString="";
				
				if(e.getSource() == title) {
        			Date  date = dateChooser.getDate();
        			
  
        			String year = new String();
        			String month = new String();
        			String day = new String();
        			
        			year = Integer.toString(date.getYear() + 1900);
        			if(date.getMonth()+1<10) {
        			String tempmonth = Integer.toString(date.getMonth()+1);
        			month="0"+tempmonth;}
        			else { month=Integer.toString(date.getMonth()+1);
        			}
        			if(date.getDate()<10) {
        				String tempday= Integer.toString(date.getDate());
        				day="0"+tempday;
        			}
        			else {
        				day=Integer.toString(date.getDate());
        			}
        			//day = Integer.toString(date.getDate());
        			
        			dateString += year + "-" + month + "-" + day;
        			
        			
        			
        		}
				
				
			}
			 static String getdateString() { return dateString;}
        }

					







    
    public static void main(String[]args) {
    	new Cal();
    }


}
