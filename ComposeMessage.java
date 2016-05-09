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
import client.Message;

public class ComposeMessage implements ICommand 
{
	private Scanner _keyboard = new Scanner(System.in);
	@Override
	public void run(MailClient client) 
	{
		Contact contact;
		
		while (true)
		{
			System.out.print("Enter to email OR contact nick name: ");
			String email_or_nick = _keyboard.nextLine();
		
			if (email_or_nick.contains("@"))
			{
				// Input is an email; create new contact
				contact = new Contact(email_or_nick);
				break;
			}
			else
			{
				// Input is a nick name; search for contact
				contact = client.getAddressBook().search(email_or_nick);
				if (contact != null)
				{
					System.out.println("Found " + contact);
					break;
				}
				else
				{
					System.out.println("Unknown recipient " + email_or_nick);
				}
			}
		}
		
		System.out.print("Subject: ");
		String subject = _keyboard.nextLine();
		
		System.out.print("Message: ");
		String body = _keyboard.nextLine();
		
		Message message = new Message(client.getMyAddress(), contact, subject, body);
		client.addToOutBox(message);
		
	}

}
