// Project 7: Email Client 2
// CSE1102 Spring 2015
// Shemona Singh
// May 3, 2015
// TA: Zigeng Wang
// Section: 005
// Instructor: Jeffrey A. Meunier


import client.*;

public class Main {
	public static void main(String[] args)
	{		
		Contact me = new Contact("Ab.Cd@uconn.edu", "Ab Cd", "Abcd");
		
		MailClient mc = new MailClient(me);
		
		CmdLoop cmd = new CmdLoop(mc);
		cmd.run();
	}
}
