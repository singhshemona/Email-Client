// Project 7: Email Client 2
// CSE1102 Spring 2015
// Shemona Singh
// May 3, 2015
// TA: Zigeng Wang
// Section: 005
// Instructor: Jeffrey A. Meunier

package client.cmd;

import java.util.Scanner;

import client.Contact;
import client.MailClient;

public class AddContact implements ICommand {
	private Scanner _keyboard = new Scanner(System.in);
	@Override
	public void run(MailClient client) 
	{
		System.out.print("Email: ");
		String email = _keyboard.nextLine();

		System.out.print("Full Name: ");
		String name = _keyboard.nextLine();
		
		System.out.print("Nick Name: ");
		String nick = _keyboard.nextLine();
		
		client.getAddressBook().add(new Contact(email, name, nick));
		
	}

}