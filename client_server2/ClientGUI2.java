package client_server2;//create name space that organize a set related classes & interfaces

import java.net.InetAddress;//import the class which is include in Java input 
import java.net.Socket;//import classes for create and manage GUI layout
import java.awt.BorderLayout;//layout manage to arrange components
import java.awt.Color;//import for setting colors
import java.awt.Dimension;//import for specify the size
import java.awt.event.ActionEvent;//import to represent action event
import java.awt.event.ActionListener;//import to handle action
import java.awt.event.ItemEvent;//used to represents item state changes
import java.awt.event.ItemListener;//used to handle item events
import java.io.*;//import classes for input/output operations and provide class for readings/writing data
import java.util.ArrayList;//use to resize the array
import java.util.List;//use for list data structures
import java.util.Scanner;		//us for reading input, from console

import javax.swing.ButtonGroup;	//set a group of buttons
import javax.swing.JButton;//create clickable buttons in GUI
import javax.swing.JFrame;//create frame for GUI application
import javax.swing.JLabel;//display text in GUI
import javax.swing.JPanel;//set container that group up for better layout
import javax.swing.JRadioButton;//set button that can be select
import javax.swing.JToggleButton;//create button that toggles between two states

//define ClientGUI2 class that import ActionListener actions
//so class will handle action events
public class ClientGUI2 implements ActionListener {

	JFrame window = new JFrame("Event listener");//create main window with Jframe

	JPanel panel = new JPanel();//create panel to hold components
	JButton buttonAverage = new JButton("Get Average");//create button to get average
	JButton buttonMax = new JButton("Get Maximum");//create button to get maximum
	JButton buttonMin = new JButton("Get Minimum");//create button to get minimum
	JLabel label = new JLabel("No button Pressed");//display selection status for new code run
    //New for ToggleButton
    JToggleButton toggleButton = new JToggleButton("Temperature");
    String menu = "1";
    //end New


	public ClientGUI2() {

		buttonAverage.setPreferredSize(new Dimension(300, 100));
		buttonMin.setPreferredSize(new Dimension(300, 100));
		buttonMax.setPreferredSize(new Dimension(300, 100));
		label.setPreferredSize(new Dimension(200, 100));
		
		buttonAverage.addActionListener(this);
		buttonMin.addActionListener(this);
		buttonMax.addActionListener(this);
		
	    //New for ToggleButton
		toggleButton.setLabel("Temperature");
        toggleButton.addItemListener(itemListener);
        //end New

		panel.add(buttonAverage);
		panel.add(buttonMin);
		panel.add(buttonMax);
		panel.add(label);
		
        window.add(toggleButton, BorderLayout.NORTH);
		window.getContentPane().add(panel);
		window.setSize(500, 700);
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) throws Exception, InterruptedException {

		ClientGUI2 client = new ClientGUI2();

	}
    //New for ToggleButton
	ItemListener itemListener = new ItemListener() {
		 

        public void itemStateChanged(ItemEvent itemEvent)
        {

            // event is generated in button
            int state = itemEvent.getStateChange();

            // if selected set value for temperature
            if (state == ItemEvent.SELECTED) {
            	toggleButton.setLabel("Temperature");
            	menu = "1";
                //Optional print to console
                System.out.println("Temperature");
                
            } // else set value for humidity
            else {
            	toggleButton.setBackground(Color.red);
            	toggleButton.setLabel("Humidity");
                menu = "2";
                //Optional print to console
                System.out.println("Humidity");
            }
        }
    };
    // end New
	
	@Override
	public void actionPerformed(ActionEvent e ) {

		// When button pressed, get value from server according to button pressed
		// "1" means getAverage
		// "2" means getMaximum
		// "3" means getMinimum ... not coded yet
		

		if (e.getSource().equals(buttonAverage)) {

			try {
				label.setText("Average button was pressed");
				System.out.println("In Try");
				
				
				Socket s = connectToServer();
				String[] data = correspondWithServer(s, menu);

				
				double average = getAvg(data);
				if (average < 5) {
					panel.setBackground(Color.blue);
				} else if (average > 30) {
					panel.setBackground(Color.red);
				} else if ((average > 5) & (average < 30)) {
					panel.setBackground(Color.green);
				}
				System.out.println("Average:"+ average);


			} catch (IOException | InterruptedException e1) {
				e1.printStackTrace();
			}

		} else if (e.getSource().equals(buttonMax)) {
			label.setText("Maximum button was pressed");

			try {
				Socket s = connectToServer();
				String[] data = correspondWithServer(s, menu);
				double max = getMax(data);
				if (max < 5) {
					panel.setBackground(Color.blue);
				} else if (max > 30) {
					panel.setBackground(Color.red);
				} else if ((max > 5) & (max < 30)) {
					panel.setBackground(Color.green);
				}
				System.out.println("Maximum: "+ max);
				//end replace

			} catch (IOException | InterruptedException e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource().equals(buttonMin)) {
			// Replace the following code with code for Minimum
			label.setText("Minimum button was pressed");
			
			try {
				Socket s = connectToServer();
				String[] data = correspondWithServer(s, menu);
				double min = getMin(data);
				if (min < 5) {
					panel.setBackground(Color.blue);
				} else if (min > 30) {
					panel.setBackground(Color.red);
				} else if ((min > 5) & (min < 30)) {
					panel.setBackground(Color.green);
				}
				System.out.println("Minimum:" + min);

			} catch (IOException | InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static Socket connectToServer() throws IOException, InterruptedException {
		// Use ipconfig (Windows) or ifconfig(Linux) to find the IP address
		// Change the IP address to that of your computer.
		InetAddress inet = InetAddress.getByName("192.168.147.88");// set up address of server
		// create socket using server ip address and port....
		Socket s = new Socket(inet, 2003);
		// wait patiently....
		Thread.sleep(200);
		// input from the socket (s)
		return s;

	}

	public static String[] correspondWithServer(Socket s, String menu) throws IOException {
		// String menu = "1";
		DataOutputStream writeToServer = new DataOutputStream(s.getOutputStream());
		writeToServer.writeBytes(menu);
		// input from the socket (s)
		InputStream in = s.getInputStream();
		// scanner object to access the input
		Scanner scanner = new Scanner(in);
		// inputLine is the next (only) line in our "document"
		String inputLine = scanner.nextLine();

		System.out.println(inputLine);// print entire line

		String[] data = inputLine.split(" ");// create array that splits on the space

		disconnectFromServer(scanner,s);  // disconnect Socket and Scanner
		return data;
	}
	public static double getAvg(String[] data) {
		double total = 0.0;
		for (String item : data) {
			total += Double.valueOf(item);
		}
		return total / data.length;

	}	
	public static double getMin(String[] data) {
		double min=900;
		for (String item : data) {
			double value = Double.valueOf(item);
			if(value < min) {
				min = value;
			}
		}
		return min;
	}
	public static double getMax(String[] data) {
		double max = 0;
		for (String item : data) {
			double value = Double.valueOf(item);
			if(value > max) {
				max = value;
			}
		}
		return max;
	}

	public static void disconnectFromServer(Scanner scanner, Socket s) throws IOException {
		scanner.close();
		s.close();
	}
}