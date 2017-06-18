import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.Date;

class NextPage extends JFrame{
	NextPage(){
		JLabel label1=new JLabel("welcome");
		JPanel panel=new JPanel(new GridLayout(1,1));
		panel.add(label1);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("welcome");
		setSize(400,200);
	}
}

class SecuritySystem2 extends JFrame implements ActionListener{
	JButton SUBMIT;
	JPanel panel;
	JComboBox combo;
	JLabel l1;
	String class1[]={"Authority","Non-Authority"};
	
	SecuritySystem2(){
		l1=new JLabel();
		l1.setText("choose one");
		combo=new JComboBox(class1);
		combo.setBackground(Color.gray);
		combo.setForeground(Color.red);	
		SUBMIT=new JButton("save");
		panel=new JPanel(new GridLayout(2,2));
		panel.add(l1);	
		panel.add(combo);
		panel.add(SUBMIT);
		add(panel,BorderLayout.CENTER);
		SUBMIT.addActionListener(this);
		setTitle("choose one");
	}
	
	public void actionPerformed(ActionEvent ae){
		String class1=(String)combo.getSelectedItem();
		
		if(class1=="Authority"){
			SecuritySystem1 page1=new SecuritySystem1();
				page1.setVisible(true);
		}	
		else if(class1=="Non-Authority"){
			SecuritySystem3 page2=new SecuritySystem3();
				page2.setVisible(true);
		}
	}
}

class SecuritySystem1 extends JFrame implements ActionListener{
	JButton SUBMIT;
	JButton SUBMIT1;
	JPanel panel;
	JLabel label1,label2;
	JTextField text1,text2;
	public JLabel label3;
	public JTextField text3;
	String otp;
    
	static String OTP(){
      		int randomPin   =(int)(Math.random()*9000)+1000;
		String otp1  =String.valueOf(randomPin);
		return otp1;
    	}
	
	SecuritySystem1(){
		label1=new JLabel();
		label1.setText("username");
		text1=new JTextField(15);
		label2=new JLabel();
		label2.setText("password");
		text2=new JTextField(15);
		label3=new JLabel();
		label3.setText("Enter the otp");
		text3=new JTextField(15);
		SUBMIT1=new JButton("getotp");
		SUBMIT=new JButton("save");
		panel=new JPanel(new GridLayout(4,1));
		panel.add(label1);
		panel.add(text1);
		panel.add(label2);
		panel.add(text2);
		panel.add(label3);
		panel.add(text3);
		panel.add(SUBMIT1);
		panel.add(SUBMIT);
		add(panel,BorderLayout.CENTER);
		SUBMIT1.addActionListener(this);
		SUBMIT.addActionListener(this);
		setSize(400,200);
		setTitle("login form");
	}

	public void actionPerformed(ActionEvent ae){
		String value1=text1.getText();
		String value2=text2.getText();
		String value3=text3.getText();
		Date date = new Date();
		String value4=date.toString();
		
		if(ae.getSource()==SUBMIT){
			if(value3.equals(otp)!=false){
			Connection con=null;
			try{
				String url="jdbc:odbc:credit";
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con=DriverManager.getConnection(url);
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from Table4 where username='"+value1+"' and password='"+value2+"'");
				if(rs.next()){
					int i=st.executeUpdate("INSERT into Table1 values ('"+value1+"','"+value3+"','"+value4+"','"+value4+"')");
					NextPage page1=new NextPage();
					page1.setVisible(true);
					JLabel label= new JLabel("welcome "+value1);
					page1.getContentPane().add(label);
				}
				else{
					System.out.println("enter valid otp and username and password");
					JOptionPane.showMessageDialog(this,"incorrect otp","error",JOptionPane.ERROR_MESSAGE);
				}
				st.close();
				con.close();
			}
			catch(ClassNotFoundException cnfex){
				cnfex.printStackTrace();
			}
			catch(SQLException sqlex){
				sqlex.printStackTrace();
			}
			catch(Exception excp){
				excp.printStackTrace();
			}	
			text1.setText("");
			text2.setText("");
			text3.setText("");	
			}
			else{
				JOptionPane.showMessageDialog(this,"incorrect otp","error",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(ae.getSource()==SUBMIT1){
			otp=(OTP());
			System.out.print(otp); 
		}
	}
	
}
class SecuritySystem3 extends JFrame implements ActionListener{
	JButton SUBMIT;
	JButton SUBMIT1;
	JPanel panel;
	JLabel label1,label2,label3,label4;
	JTextField text1,text2,text3,text4;
	String otp;
   	static String OTP(){
      		int randomPin   =(int)(Math.random()*9000)+1000;
		String otp1  =String.valueOf(randomPin);
		return otp1;   
    	}
	
	SecuritySystem3(){
		label1=new JLabel();
		label1.setText("username");
		text1=new JTextField(15);
		label2=new JLabel();
		label2.setText("name");
		text2=new JTextField(15);
		label3=new JLabel();
		label3.setText("Enter the otp");
		text3=new JTextField(15);
		label4=new JLabel();
		label4.setText("reason for visit");
		text4=new JTextField(15);
		SUBMIT1=new JButton("getotp");
		SUBMIT=new JButton("save");
		panel=new JPanel(new GridLayout(5,1));
		panel.add(label1);
		panel.add(text1);
		panel.add(label2);
		panel.add(text2);
		panel.add(label3);
		panel.add(text3);
		panel.add(label4);
		panel.add(text4);
		panel.add(SUBMIT1);
		panel.add(SUBMIT);
		add(panel,BorderLayout.CENTER);
		SUBMIT1.addActionListener(this);
		SUBMIT.addActionListener(this);
		setSize(400,200);
		setTitle("login form");
	}

	public void actionPerformed(ActionEvent ae){
		String value1=text1.getText();
		String value2=text2.getText();
		String value3=text3.getText();
		String value5=text4.getText();
		Date date = new Date();
		String value4=date.toString();
		
		if(ae.getSource()==SUBMIT){
			if(value3.equals(otp)!=false){
			Connection con=null;
			
			try{
				String url="jdbc:odbc:credit";
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con=DriverManager.getConnection(url);
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from Table4 where username='"+value1+"'");
				if(rs.next()){
					int i=st.executeUpdate("INSERT into Table2 values ('"+value1+"','"+value2+"','"+value3+"','"+value5+"','"+value4+"','"+value4+"')");
					NextPage page1=new NextPage();
					page1.setVisible(true);
					JLabel label= new JLabel("welcome "+value2);
					page1.getContentPane().add(label);
				}
				else{
					System.out.println("enter valid otp and username and password");
					JOptionPane.showMessageDialog(this,"incorrect otp","error",JOptionPane.ERROR_MESSAGE);
				}
				st.close();
				con.close();
			}
		
			catch(ClassNotFoundException cnfex){
				cnfex.printStackTrace();
			}
			catch(SQLException sqlex){
				sqlex.printStackTrace();
			}
			catch(Exception excp){
				excp.printStackTrace();
			}
			text1.setText("");
				text2.setText("");
				text3.setText("");	
				text4.setText("");	
			}
			else{
				JOptionPane.showMessageDialog(this,"incorrect otp","error",JOptionPane.ERROR_MESSAGE);
			}
		}
	
		if(ae.getSource()==SUBMIT1){
			 otp=(OTP());
			System.out.print(otp);
	     	}	
	}
	
}

class SecuritySystem{
	public static void main(String args[]){
		try{
			SecuritySystem2 frame=new SecuritySystem2();
			frame.setSize(500,200);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
}
