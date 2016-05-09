package client.cmd;

import java.util.Scanner;

import client.MailBox;
//Project 7: Email Client 2
//CSE1102 Spring 2015
//Shemona Singh
//May 3, 2015
//TA: Zigeng Wang
//Section: 005
//Instructor: Jeffrey A. Meunier

import client.MailClient;
import client.Message;

public class DeleteInbox implements ICommand {
	private Scanner _keyboard = new Scanner(System.in);
	@Override
	public void run(MailClient client) 
	{
		if (client.getInBox().count() > 0)
		{
			System.out.print("Message #: ");
			int n = _keyboard.nextInt();
			int n_real = n - 1;
			
			Message message = client.getInBox().remove(n_real);
			
			if (message == null)
			{
				System.out.println("Message number " + n + " can't be found.");
			}
		}
		else
		{
			System.out.println("Inbox empty.");
		}
		
	}

}