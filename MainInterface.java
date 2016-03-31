package medProgram;

import java.sql.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.util.*; 
import javax.swing.*; 
import javax.swing.border.*; 

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class MainInterface extends JFrame implements ActionListener { 
	
	JDesktopPane gui = new JDesktopPane();
	
	JMenuBar mb = new JMenuBar();  
	JMenu  ManaSystem,appoViewer,checkIn,medRecord,headspace,usersetting,GetHelp; 
	JMenuItem  outsystem,patientinfo,patientinfo1,addHospital,dropHospital,space_2,changepwd,adduser,aboutauthor,aboutsystem,space_1,usehelp,background,color1,manspace_1, 
 color2,color3,usetspace, openApptViewer, openCheckIn;  
	JMenu backcolor;  
	JPanel jp=new JPanel(); 
	Container cp=getContentPane();
	String username; 
	boolean isLoggedIn = false;
	
	MainInterface(String username) { 
//		if (isLoggedIn = false)
//		{
//			new Login();
//			this.setEnabled(false);
//		}
//		else
//		{
//			this.setEnabled(true);
//		}
		
		this.username=username; 
		cp.add(mb,"North"); 
		/*
		 * Menu 
		 */
		//System management
		ManaSystem=new JMenu("System Setting");  
		//ManaSystem.setMnemonic('S'); 
		//Check in
		checkIn=new JMenu("Check In"); 
		//Appointment viewer
		appoViewer=new JMenu("Appointment Viewer");   
		//Medical record
		medRecord=new JMenu("Medical  Record");  
		//Space leaved for later function 
		headspace=new JMenu("Headspace");  
		//User setting
		usersetting=new JMenu("User Setting");       
		//Help
		GetHelp=new JMenu("Help");     
		/*
		 * Menu items 
		 */
		//Background color in 'System Setting'
		backcolor=new JMenu("Background Color");   
		background=new JMenuItem("Backgrond Color");      
		color1=new JMenuItem("White");      
		color2=new JMenuItem("Gray");      
  		color3=new JMenuItem("Black");
  		openApptViewer=new JMenuItem("Open Appointment Viewer");
  		openCheckIn=new JMenuItem("Open Check In");
		background.add(backcolor);     
		backcolor.add(color1);         
		backcolor.add(color2);         
		backcolor.add(color3);   
		
		//Log out in 'System Setting'
		outsystem=new JMenuItem("Log Out");   
		space_1=new JMenuItem("space"); 
		space_2=new JMenuItem("space");
		
		//Change password in 'User Setting'
		changepwd=new JMenuItem("ChangePassword");  
		
		//Add user
		adduser=new JMenuItem("AddUser");   
		
		//Space leaved for later function in 'User Setting'
		usetspace=new JMenuItem("space");
		//Info about author and system
		
		aboutauthor=new JMenuItem("About Author");      
		aboutsystem=new JMenuItem("About System"); 
		
		//User guide
		usehelp=new JMenuItem("User Guide"); 
		
		//Assemble properly
		mb.add(ManaSystem);  
		mb.add(checkIn);   
		mb.add(appoViewer);   
		mb.add(medRecord); 
		mb.add(headspace); 
		mb.add(usersetting);  
		mb.add(GetHelp);
		ManaSystem.add(backcolor);   
		ManaSystem.add(outsystem);     
		headspace.add(space_2); 
		headspace.add(space_1);
		checkIn.add(openCheckIn);
		appoViewer.add(openApptViewer);
		usersetting.add(changepwd);        
		usersetting.add(usetspace);    
		GetHelp.add(aboutauthor);    
		GetHelp.add(aboutsystem);       
		GetHelp.add(usehelp); 
		color1.addActionListener(this);        
		color2.addActionListener(this);     
		color3.addActionListener(this);  
		
		//Add action listerner
		outsystem.addActionListener(this);     
		changepwd.addActionListener(this);
		adduser.addActionListener(this);
		usetspace.addActionListener(this);       
		aboutauthor.addActionListener(this);      
		aboutsystem.addActionListener(this);   
		usehelp.addActionListener(this);
		openApptViewer.addActionListener(this);
		openCheckIn.addActionListener(this);		
		
		jp.setLayout(new BorderLayout());       
		JLabel label1 = new JLabel();   
		jp.add(label1); 
		JLabel  JL=new JLabel("<html><font color=#4F4F4F size='14'><i>Group 6  Medical Program<br><hr>"  + 
          "</i></font>",SwingConstants.CENTER);  
		jp.add(JL); 
		JScrollPane scrollpane=new JScrollPane(jp);  
		cp.add(scrollpane); 
		setTitle("Group 6  Medical Program");  
		jp.setBackground(Color.lightGray);    
		setSize(1100,600);       
		setVisible(true); 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		
		this.setLocationRelativeTo(getParent());
	}
	public void actionPerformed(ActionEvent e)  { 
		if (e.getSource()==color3){ 
			jp.setBackground(Color.BLACK);   
		} 
		if (e.getSource()==color2){ 
			jp.setBackground(Color.lightGray);   
		} 
		if (e.getSource()==color1){ 
			jp.setBackground(Color.white);   
		} 
		if (e.getSource()==outsystem){ 
			new Login();
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			
		} 
		if (e.getSource()==changepwd){ 
			//null;
		} 
		if (e.getSource()==adduser){ 
			//null;   
		} 
		if (e.getSource()==aboutauthor){ 
			JOptionPane.showMessageDialog(this,"This feature has not been implemented yet.");   
		}
		if (e.getSource()==aboutsystem){ 
			JOptionPane.showMessageDialog(this,"This feature has not been implemented yet."); 
		} 
		if (e.getSource()==usehelp){ 
			JOptionPane.showMessageDialog(this,"This feature has not been implemented yet.");   
		}

		//CHECK IN
		if (e.getSource()==openCheckIn){ 
			
			Search patient = new Search();
			patient.main();
		} 
   
		//APPONTMENT VIEW
		if (e.getSource()==openApptViewer){ 
			AppointmentViewer av = new AppointmentViewer();
			av.main();
		} 
   
		//MEDICAL RECORD
		if (e.getSource()==medRecord){ 
			JOptionPane.showMessageDialog(this,"This feature has not been implemented yet.");
		} 
	}

	public static void main(String[]args) { 
		new MainInterface("");   
	} 
	
}
