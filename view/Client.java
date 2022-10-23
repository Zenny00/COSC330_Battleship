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

public class Client extends JPanel implements Role
{
   private JTextField enterField; // enters information from user
   private JTextArea displayArea; // display information to user
   private ObjectOutputStream output; // output stream to server
   private ObjectInputStream input; // input stream from server
   private String message = ""; // message from server
   private String chatServer; // host server for this application
   private Socket client; // socket to communicate with server

   // initialize chatServer and set up GUI
   public Client( String host )
   {
      super();

      chatServer = host; // set server to which this client connects
      
      enterField = new JTextField(); // create enterField
      enterField.setPreferredSize(new Dimension(200, 25));
      enterField.setEditable( false );
      enterField.addActionListener(
         new ActionListener() 
         {
            // send message to client
            public void actionPerformed( ActionEvent event )
            {
               sendData( event.getActionCommand() );
               enterField.setText( "" );
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener

      add( enterField, BorderLayout.NORTH );

      displayArea = new JTextArea(); // create displayArea
      displayArea.setPreferredSize(new Dimension(200, 250));
      add( new JScrollPane( displayArea ), BorderLayout.CENTER );

      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      //setSize( 300, 150 ); // set size of window
      setPreferredSize(new Dimension(300, 300));
      setVisible( true ); // show window
   } // end Client constructor

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

	/*
      try // connect to server, get streams, process connection
      {
         connectToServer(); // create a Socket to make connection
         getStreams(); // get the input and output streams
         processConnection(); // process connection
      } // end try
      catch ( EOFException eofException ) 
      {
         displayMessage( "\nClient terminated connection" );
      } // end catch
      catch ( IOException ioException ) 
      {
         ioException.printStackTrace();
      } // end catch
         //closeConnection(); // close connection
      */
   } // end method runClient

   // connect to server
   public void connectToServer() throws IOException
   {      
      displayMessage( "Attempting connection\n" );

      // create Socket to make connection to server
      client = new Socket( InetAddress.getByName( chatServer ), 12345 );

      // display connection information
      displayMessage( "Connected to: " + 
         client.getInetAddress().getHostName() );
   } // end method connectToServer

   // get streams to send and receive data
   public void getStreams() throws IOException
   {
      // set up output stream for objects
      output = new ObjectOutputStream( client.getOutputStream() );      
      output.flush(); // flush output buffer to send header information

      // set up input stream for objects
      input = new ObjectInputStream( client.getInputStream() );

      displayMessage( "\nGot I/O streams\n" );
   } // end method getStreams

   // process connection with server
   public void processConnection() throws IOException
   {
      // enable enterField so client user can send messages
      setTextFieldEditable( true );
     
     /* 
      do // process messages sent from server
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

      } while ( !message.equals( "SERVER>>> TERMINATE" ) );
      */
   } // end method processConnection

   // close streams and socket
   public void closeConnection() 
   {
      displayMessage( "\nClosing connection" );
      //setTextFieldEditable( false ); // disable enterField

      try 
      {
         output.close(); // close output stream
         input.close(); // close input stream
         client.close(); // close socket
      } // end try
      catch ( IOException ioException ) 
      {
         ioException.printStackTrace();
      } // end catch
   } // end method closeConnection

   public void sendMessage( String str )
   {
	try
	{
		output.writeBytes(str);
	}
	catch ( IOException ioException )
	{
		displayArea.append( "\nError writing object" );
	}
   }

   public String readMessage()
   {
	   String line = ""; 
	   
	   try
	   { 
		   line = input.readLine(); // read new point
	   }
	   //Bitwise operation to catch multiple exceptions
	   catch ( IOException e ) 
	   {
		   displayArea.append( "\nError writing object" );
	   }

	   return line;
   }

   // send message to server
   public void sendData( Object obj )
   {
	String message = obj.toString();
      try // send object to server
      {
         output.writeObject( "CLIENT>>> " + message );
         output.flush(); // flush data to output
         displayMessage( "\nCLIENT>>> " + message );
      } // end try
      catch ( IOException ioException )
      {
         displayArea.append( "\nError writing object" );
      } // end catch
   } // end method sendData

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

   // manipulates enterField in the event-dispatch thread
   private void setTextFieldEditable( final boolean editable )
   {
      SwingUtilities.invokeLater(
         new Runnable() 
         {
            public void run() // sets enterField's editability
            {
               enterField.setEditable( editable );
            } // end method run
         } // end anonymous inner class
      ); // end call to SwingUtilities.invokeLater
   } // end method setTextFieldEditable
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
