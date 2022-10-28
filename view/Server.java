import java.io.EOFException;
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
   //private ObjectOutputStream output; // output stream to client
   //private ObjectInputStream input; // input stream from client
   private BufferedReader br;
   private PrintWriter pw;
   private ServerSocket server; // server socket
   private Socket connection; // connection to client
   private int counter = 1; // counter of number of connections
   
   // set up GUI
   public Server()
   {
      super();
      
      displayArea = new JTextArea(); // create displayArea
      displayArea.setEditable(false);
      displayArea.setPreferredSize(new Dimension(200, 100));
      add( new JScrollPane( displayArea ), BorderLayout.CENTER );
      
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      //setSize( 300, 150 ); // set size of window
      setPreferredSize(new Dimension(300, 300));
      setVisible( true ); // show window
   } // end Server constructor

   // set up and run server 
   public void run()
   {

      try // set up server to receive connections; process connections
      {
         server = new ServerSocket( 12345, 100 ); // create ServerSocket
	 waitForConnection();
	 getStreams();
	 
	 /*
         while ( true ) 
         {
            try 
            {
               waitForConnection(); // wait for a connection
               getStreams(); // get input & output streams
               processConnection(); // process connection
            } // end try
            catch ( EOFException eofException ) 
            {
               displayMessage( "\nServer terminated connection" );
            } // end catch
            //finally 
            //{
            //   closeConnection(); //  close connection
            //   counter++;
            //} // end finally
         } // end while
	 */
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
         connection.getInetAddress().getHostName() );
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
	/*
     	   // set up output stream for objects
      output = new ObjectOutputStream( connection.getOutputStream() );
      output.flush(); // flush output buffer to send header information

      // set up input stream for objects
      input = new ObjectInputStream( connection.getInputStream() );

      displayMessage( "\nGot I/O streams\n" );
      */
   } // end method getStreams

   // process connection with client
   public void processConnection() throws IOException
   {
      String message = "Connection successful";
      //sendData( message ); // send connection successful message

      // enable enterField so server user can send messages

      /*
      do // process messages sent from client
      {
         try // read message and display it
         {
            message = ( String ) input.readObject(); // read new message
            displayMessage( "\n" + message ); // display message
         } // end try
         catch ( ClassNotFoundException classNotFoundException ) 
         {
            displayMessage( "\nUnknown object type received" );
         } // end catch
	 
      	} while ( !message.equals( "CLIENT>>> TERMINATE" ) );
	*/
   } // end method processConnection

   // close streams and socket
   public void closeConnection() 
   {
	System.out.println("CLOSED");
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
	System.out.println(str);
	pw.println(str);
	pw.flush();
   }

   public String readMessage()
   {	
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
   
   /*
   // send message to client
   public void sendData( Object obj )
   {
	String message = obj.toString();
      try // send object to client
      {
         output.writeObject( "SERVER>>> " + message );
         output.flush(); // flush output to client
         displayMessage( "\nSERVER>>> " + message );
      } // end try
      catch ( IOException ioException ) 
      {
         displayArea.append( "\nError writing object" );
      } // end catch
   } // end method sendData
*/
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
