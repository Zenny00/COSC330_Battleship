//Name: Joshua Comfort & Justin Conklin
//Description: Allows for the sending of text between the server and clientmport java.io.EOFException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
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

public class Server extends JPanel implements Role 
{
   private JTextArea displayArea; // display information to user
   private BufferedReader br; //Input from client
   private PrintWriter pw; //Output to client
   private ServerSocket server; // server socket
   private Socket connection; // connection to client
   private int counter = 1; // counter of number of connections
   private int index = 0;
   
   // set up GUI
   public Server()
   {
      super();
      
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
   } // end Server constructor

   public void resetField()
   {
	//Reset the output field
	displayArea.setText("");
	displayMessage("Game restarted\n");
	
	//Close and restart connection
	closeConnection();
	run();
   }

   // set up and run server 
   public void run()
   {

      try // set up server to receive connections; process connections
      {
         server = new ServerSocket( 12345 + index, 100 + index++); // create ServerSocket
	 waitForConnection();
	 getStreams();
      } // end try
      catch ( IOException ioException ) 
      {
         ioException.printStackTrace();
      } // end catch
   } // end method runServer

   // wait for connection to arrive, then display connection info
   public void waitForConnection() throws IOException
   {
      displayMessage( "Waiting for connection\n" );
      connection = server.accept(); // allow server to accept connection            
      displayMessage( "Connection " + counter + " received from: " +
         connection.getInetAddress().getHostName() + "\n");
   } // end method waitForConnection
   
   public void writeStatus(String str)
   {
	   //write message on display
	displayMessage(str + "\n");
   }

   // get streams to send and receive data
   public void getStreams() throws IOException
   {
	   pw = new PrintWriter(connection.getOutputStream(), true);
	   br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
   } // end method getStreams
 
   // close streams and socket
   public void closeConnection() 
   {
      displayMessage( "\nTerminating connection\n" );

      try 
      {
         pw.close(); // close output stream
         br.close(); // close input stream
         connection.close(); // close socket
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
	//Holds message from client
	String line = ""; 
	try
	{
		line = br.readLine();  
	}
	catch ( IOException ioException )
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
               displayArea.append( messageToDisplay ); // append message
            } // end method run
         } // end anonymous inner class
      ); // end call to SwingUtilities.invokeLater
   } // end method displayMessage
} // end class Server

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
