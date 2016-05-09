// Project 7: Email Client 2
// CSE1102 Spring 2015
// Shemona Singh
// May 3, 2015
// TA: Zigeng Wang
// Section: 005
// Instructor: Jeffrey A. Meunier

package client.cmd;

import client.MailClient;

public class Save implements ICommand
{
	
private static String CONTACTS;
	
	@Override
	public void run(MailClient client) 
	{
	CONTACTS = "Contacts.txt";
	client.getAddressBook().save(CONTACTS);
	
	final String INBOX = "Inbox.txt";
	client.getInBox().save(INBOX, client.getAddressBook());
	
	final String OUTBOX = "Outbox.txt";
	client.getOutBox().save(OUTBOX, client.getAddressBook());
		
	}
	
	public static String getCONTACTS()
	{
		return CONTACTS;
	}
}
