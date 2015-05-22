/*
Manish Kumar
S.Gopinath (Group head)
S.Vinay Kumar
Shashi Roshan
*/

package examples.proj;
import com.ibm.aglet.*;
import com.ibm.aglet.event.*;
import com.ibm.aglet.util.*;
import java.lang.InterruptedException;

import com.ibm.agletx.util.SimpleItinerary;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
public class KO extends Aglet  
{
FileInputStream fiss =null;
boolean remote=false;

int numfile=5;
String first="";
		int idx=0;
String ab="dodn";
String home = null;
	String changed="";
/*String message = null;
SimpleItinerary itinerary = null;

public void atHome(Message msg) {
		setText("I'm back.");		// greetings
		waitMessage(2 * 1000);		// show message, 2 seconds
		dispose();					// dispose it self
	}
public boolean handleMessage(Message msg) {
		if (msg.sameKind("atHome")) {
			atHome(msg);
		} else {
			return false;
		} 
		return true;
	}*/


public void onCreation(Object args)
	{
	      	addMobilityListener( new MobilityAdapter()
		{
			public void onArrival(MobilityEvent eq)
			{	
				System.out.println("onArrival() : HELLO");
				
				System.out.println(ab); 

 			if(!remote){
 				int s=0;
		int e=0;
		int sindex=0;

		int second[]=new int[numfile];

		for(int i = 0; i < first.length(); i++)
			{
			   char c = first.charAt(i);
			   
			   if(c=='*') 
			   	{
			   		e=i;
			   		//System.out.println(i);
			   if(s<first.length()-1) 
			   	{
			   		//System.out.println(s + " " + e);
			   		second[sindex++]=Integer.parseInt(first.substring(s,e));
			   	}
			   s=i+1;
				}
			   	
			}

		for(int i=0;i<numfile;i++)
			{

			System.out.println(second[i]);
			}


				System.out.println("Comparing old size with new file's size :");

			

		for(int i=1;i<=numfile;i++)
		{	
		    Integer temp=i;
		    String filename="/home/gggopi/" + temp.toString();
		    filename=filename.concat(".html");

			File file =new File(filename);
			if(file.exists())
			{
	 		
				long bytes1 = file.length();
				int bytes = (int)bytes1;
				
	 
				
				System.out.print("File "+i+ ": " + bytes);
				
				
				if(bytes!=second[i-1])
					{
						System.out.print(" , not equal");
						/*changed=changed.concat(i+"*");*/
						changed=changed.concat(temp.toString()+"*(");
				String ss="";
                        //BufferedReader br = null;
                        
                        //DataInputStream dis null;

                        try{
                            File filee = new File(filename);
                            FileInputStream fis = new FileInputStream(filee);
                            byte[] data = new byte[(int)filee.length()];
                            fis.read(data);
                            fis.close();
                            //
                            ss = new String(data, "UTF-8");
                            //System.out.println(s);  
                            }

                        catch(IOException ex){
                               ex.printStackTrace();
                            }

                        changed= changed.concat(ss+")");
                    }
				System.out.println();

			
			}
			else
			{
				 System.out.println("File does not exists!");
			}

		}
		/*try {
			setText("I'll go back to.. " + home);
			waitMessage(3000);		// 1 second
			// Go back home and Send "atHome" message to owner this
dispatch(new URL(home));
			//itinerary.go(home, "atHome");

		} catch (IOException es) {
			es.printStackTrace();
		}*/

remote=true;

		}
		else
		{
			int changedidx[]=new int[10000];
			int ch=0;

			System.out.println(changed);
			int ss=0;
			int ee=0;
			setText("I'm back.");		// greetings
			waitMessage(2 * 1000);		// show message, 2 seconds
		
			System.out.println("\nIndex of files which got modified : \n");


			for(int i = 0; i < changed.length(); i++)
				{
					char c = changed.charAt(i);
				   
				   if(c=='*') 
				   		{
				   			/*ee=i;
				   			System.out.println(changed.substring(ss,ee));
				   			changedidx[ch++]=Integer.parseInt(changed.substring(ss,ee));
				   			ss=i+1;*/
				   			ee=i;
                           System.out.println(changed.substring(ss,ee));
                           String newname="new_";
                           newname=newname.concat(changed.substring(ss,ee)+".html");
                           System.out.println("Creating new updated file : " + newname+"\n");
                           //changedidx[ch++]=Integer.parseInt(changed.substring(ss,ee));
                           //ss=i+1;

                           for(int j =i; j < changed.length(); j++)
                             {
                                char cc=changed.charAt(j);
                                if(cc==')') 
                                    { 
                                        //System.out.println(j);

                                        //System.out.println(changed.substring(i+2,j));
                                        String towrite=changed.substring(i+2,j);

                                        ss=j+1;
                                        i=j;

                                        
                                        try{
                                            PrintWriter out = new PrintWriter("/home/gggopi/"+newname);
                                            out.println(towrite);
                                            out.close();
                                            }
                                        catch(IOException ex){
                                               ex.printStackTrace();
                                            }

                                        break;
                                    }
                            }
                            //if(ss>=changed.length()) break;;

				   		}


				}
				dispose();					// dispose it self

		}

	}

			public void onDispatching(MobilityEvent e) 
			{
	      			System.out.println("onDispatching() : HELLO");
   			}


		});
	System.out.println("onCreation  : HELLO");
		

		try{
		      //use buffering
			String sCurrentLine;
		    InputStream fi = new FileInputStream("/home/gggopi/file.txt");
	    	InputStream buffer = new BufferedInputStream(fi);
	    	DataInputStream input = new DataInputStream (buffer);
	    	try{
		        	/*while ((sCurrentLine = input.readLine()) != null) 
					{
						System.out.println(sCurrentLine);
					}*/

					while ((sCurrentLine = input.readLine()) != null) 
					{
						System.out.println(sCurrentLine);
						first=first.concat(sCurrentLine);
						first=first.concat("*");
					}
	    		}
		      
		        finally{
		        	if (input != null)input.close();
		      	}
		    }
		    catch(IOException ex){
		       ex.printStackTrace();
		    }

System.out.println(ab);
		System.out.println("Initial file sizes in bytes are ( as read from file.txt ) ");
	
		
	//	itinerary = new SimpleItinerary(this);
		// Initialize the variable.
	//	home = getAgletContext().getHostingURL().toString();
	

		System.out.println("done dona done");
	  	}
public void run()
	{
		System.out.println(" run() : HELLO "); 
	}
	

	public void onDisposing()
	{
	      System.out.println("onDisposing() : HELLO");
   	}
	

}
