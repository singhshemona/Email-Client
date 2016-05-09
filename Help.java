// Project 7: Email Client 2
// CSE1102 Spring 2015
// Shemona Singh
// May 3, 2015
// TA: Zigeng Wang
// Section: 005
// Instructor: Jeffrey A. Meunier

package client.cmd;

import client.MailClient;

public class Help implements ICommand {

	@Override
	public void run(MailClient client) {
		// TODO Auto-generated method stub
		
		System.out.println("h: Displays the full list of commands");
		System.out.println("q: Quits the client");
		System.out.println("la: Lists the address book");
		System.out.println("li: Lists the inbox");
		System.out.println("lo: Lists the outbox");
		System.out.println("aa: Adds a contact to the address book");
		System.out.println("da: Deletes a contact from the address book");
		System.out.println("cm: Composes a message");
		System.out.println("ro: Reads a message from the outbox");
		System.out.println("do: Deletes a message from the outbox");
		System.out.println("ri: Reads a message from the inbox");
		System.out.println("di: Deletes a message from the inbox");
		System.out.println("sr: Sends messages from your outbox and receives messages to your inbox");
	}
		
	}


