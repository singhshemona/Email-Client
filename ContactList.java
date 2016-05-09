// Project 7: Email Client 2
// CSE1102 Spring 2015
// Shemona Singh
// May 3, 2015
// TA: Zigeng Wang
// Section: 005
// Instructor: Jeffrey A. Meunier

package client.cmd;

import client.MailClient;

public class ContactList implements ICommand
{
	
	@Override
	public void run(MailClient client) 
	{
		client.getAddressBook().show();
	}
}