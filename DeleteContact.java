// Project 7: Email Client 2
// CSE1102 Spring 2015
// Shemona Singh
// May 3, 2015
// TA: Zigeng Wang
// Section: 005
// Instructor: Jeffrey A. Meunier

package client.cmd;

import java.util.Scanner;

import client.MailClient;

public class DeleteContact implements ICommand {
	private Scanner _keyboard = new Scanner(System.in);
	@Override
	public void run(MailClient client) 
	{
		System.out.print("Nick name to delete: ");
		String nick = _keyboard.nextLine();
		
		if (client.getAddressBook().remove(nick) == null)
		{
			System.out.println("Contact with given nick name not found.");
		}
		
	}


}
