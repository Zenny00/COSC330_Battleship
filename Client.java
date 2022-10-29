//Name: Joshua Comfort & Justin Conklin
//Description: Allows for the sending of text between the server and client

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

//Import required libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Point;

import java.io.*;

public class Client extends JPanel implements Role
{
   private JTextArea displayArea; // display information to user
   private BufferedReader br; //Input from server
   private PrintWriter pw; //Output to server
   private String message = ""; // message from server
   private String chatServer; // host server for this application
   private Socket client; // socket to communicate with server
   private int index = 0;

   // initialize chatServer and set up GUI
   public Client( String host )
   {
      super();

      chatServer = host; // set server to which this client connects
      
      displayArea = new JTextArea(); // create displayArea
      
      //Setup scroll panel
      displayArea.setEditable(false);
	JScrollPane scroll = new JScrollPane( displayArea );
      scroll.setPreferredSize(new Dimension(200, 100));
      add(scroll);

      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      setSize( 300, 150 ); // set size of window
      setPreferredSize(new Dimension(300, 300));
      setVisible( true ); // show window
   } // end Client constructor

   public void resetField()
   {
	//Reset the output field
	displayArea.setText("");
	displayMessage("Game restarted\n");

	//Close and restart the connection
   	closeConnection();
	run(); 
   }

   // connect to server and process messages from server
   public void run() 
   {
	try // connect to server, get streams, process connection
	{
		connectToServer();
		getStreams();
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
   } // end method runClient

   public void writeStatus(String str)
   {
	   //write message on display
	displayMessage(str + "\n");
   }

   // connect to server
   public void connectToServer() throws IOException
   {      
      displayMessage( "Attempting connection\n" );

      // create Socket to make connection to server
      client = new Socket( InetAddress.getByName( chatServer ), 12345 + index++ );

      // display connection information
      displayMessage( "Connected to: " + 
         client.getInetAddress().getHostName() + "\n");
   } // end method connectToServer

   // get streams to send and receive data
   public void getStreams() throws IOException
   {
	   //Get input and output stream
	   pw = new PrintWriter(client.getOutputStream(), true);
	   br = new BufferedReader(new InputStreamReader(client.getInputStream()));
   } // end method getStreams 

   // close streams and socket
   public void closeConnection() 
   {
      displayMessage( "\nClosing connection" );
      //setTextFieldEditable( false ); // disable enterField

      try 
      {
         pw.close(); // close output stream
         br.close(); // close input stream
         client.close(); // close socket
      } // end try
      catch ( IOException ioException ) 
      {
         ioException.printStackTrace();
      } // end catch
   } // end method closeConnection

   public void sendMessage( String str )
   {
	//Send message and flush output stream
	pw.println(str);
	pw.flush();	
   }

   public String readMessage()
   {
	   //Holds message from server
	   String line = ""; 
	   
	   try
	   { 
		   line = br.readLine();  
	   }
	   catch ( IOException e ) 
	   {
		   displayArea.append( "\nError writing object" );
	   }

	   return line;
   } 

   // manipulates displayArea in the event-dispatch thread
   private void displayMessage( final String messageToDisplay )
   {
      SwingUtilities.invokeLater(
         new Runnable()
         {
            public void run() // updates displayArea
            {
               displayArea.append( messageToDisplay );
            } // end method run
         }  // end anonymous inner class
      ); // end call to SwingUtilities.invokeLater
   } // end method displayMessage
} // end class Client

/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
