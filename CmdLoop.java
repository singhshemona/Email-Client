// Project 7: Email Client 2
// CSE1102 Spring 2015
// Shemona Singh
// May 3, 2015
// TA: Zigeng Wang
// Section: 005
// Instructor: Jeffrey A. Meunier

package client;

import java.util.Hashtable;
import java.util.Scanner;

import client.cmd.ICommand;

public class CmdLoop {
	
	private MailClient _mailclient;
	private Scanner _keyboard = new Scanner(System.in);
	
	private Hashtable<String, ICommand> _commands = new Hashtable<String, ICommand>();
	
	public CmdLoop(MailClient mailclient)
	{
		_mailclient = mailclient;
		_commands.put("h", new client.cmd.Help());
		_commands.put("la", new client.cmd.ContactList());
		_commands.put("li", new client.cmd.InboxList());
		_commands.put("lo", new client.cmd.OutboxList());
		_commands.put("aa", new client.cmd.AddContact());
		_commands.put("da", new client.cmd.DeleteContact());
		_commands.put("cm", new client.cmd.ComposeMessage());
		_commands.put("ro", new client.cmd.ReadOutbox());
		_commands.put("do", new client.cmd.DeleteOutbox());
		_commands.put("sr", new client.cmd.Transfer());
		_commands.put("ri", new client.cmd.ReadInbox());
		_commands.put("di", new client.cmd.DeleteInbox());
		_commands.put("sv", new client.cmd.Save());
		_commands.put("ld", new client.cmd.Load());
		
	}
	
	public void run()
	{		
		
		while (true)
		{
			System.out.print("Mail: ");
			String input = _keyboard.nextLine();
			
			if (input.equals("q"))
			{
				break;
			}
			else if (input.equals("la"))
			{
				this.cmdListAddressBook();
			}
			else if (input.equals("li"))
			{
				this.cmdListInbox();
			}
			else if (input.equals("lo"))
			{
				this.cmdListOutbox();
			}
			else if (input.equals("aa"))
			{
				this.cmdAddToAddressBook();
			}
			else if (input.equals("da"))
			{
				this.cmdDeleteFromAddressBook();
			}
			else if (input.equals("cm"))
			{
				this.cmdComposeMessage();
			}
			else if (input.equals("ro"))
			{
				this.cmdReadOutboxMessage();
			}
			else if (input.equals("do"))
			{
				this.cmdDeleteFromOutbox();
			}
			else if (input.equals("sr"))
			{
				this.cmdSendAndReceive();
			}
			else if (input.equals("ri"))
			{
				this.cmdReadInboxMessage();
			}
			else if (input.equals("di"))
			{
				this.cmdDeleteFromInbox();
			}
			else if (input.equals(""))
			{
				continue;
			}
			else
			{
				ICommand c = _commands.get(_keyboard);
				if (c != null)
				{
					c.run(_mailclient);
				}
				else
				{
					System.out.println(_keyboard + " not understood, type h for help");
				}
				
			}
		}
	}
	
	public void cmdHelp()
	{
		String[] lines = {
			"h	Show this help menu",
			"q	Quit",
			"la	List address book",
			"li	List inbox",
			"lo	List outbox",
			"aa	Add to address book",
			"da	Delete from address book",
			"cm	Compose message",
			"ro	Read outbox message",
			"do	Delete from outbox",
			"sr	Send and receive",
			"ri	Read inbox message",
			"di	Delete from inbox"
		};
		
		for (String line : lines)
			System.out.println(line);
	}
	
	public void cmdListAddressBook()
	{
		_mailclient.getAddressBook().show();
	}
	
	public void cmdListInbox()
	{
		_mailclient.getInBox().show();
	}
	
	public void cmdListOutbox()
	{
		_mailclient.getOutBox().show();
	}
	
	public void cmdAddToAddressBook()
	{
		System.out.print("Email: ");
		String email = _keyboard.nextLine();

		System.out.print("Full Name: ");
		String name = _keyboard.nextLine();
		
		System.out.print("Nick Name: ");
		String nick = _keyboard.nextLine();
		
		_mailclient.getAddressBook().add(new Contact(email, name, nick));
	}
	
	public void cmdDeleteFromAddressBook()
	{
		System.out.print("Nick name to delete: ");
		String nick = _keyboard.nextLine();
		
		if (_mailclient.getAddressBook().remove(nick) == null)
		{
			System.out.println("Contact with given nick name not found.");
		}
	}
	
	public void cmdComposeMessage()
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
				contact = _mailclient.getAddressBook().search(email_or_nick);
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
		
		Message message = new Message(_mailclient.getMyAddress(), contact, subject, body);
		_mailclient.addToOutBox(message);
	}
	
	public void cmdReadOutboxMessage()
	{
		if (_mailclient.getOutBox().count() > 0)
		{
			System.out.print("Message #: ");
			int n = _keyboard.nextInt();
			int n_real = n - 1;
			
			Message message = _mailclient.getOutBox().getMessage(n_real);
			
			if (message != null)
			{
				message.show();
			}
			else
			{
				System.out.println("Message number " + n + " can't be found.");
			}
		}
		else
		{
			System.out.println("Outbox empty.");
		}
	}
	
	public void cmdDeleteFromOutbox()
	{
		if (_mailclient.getOutBox().count() > 0)
		{
			System.out.print("Message #: ");
			int n = _keyboard.nextInt();
			int n_real = n - 1;
			
			Message message = _mailclient.getOutBox().remove(n_real);
			
			if (message == null)
			{
				System.out.println("Message number " + n + " can't be found.");
			}
		}
		else
		{
			System.out.println("Outbox empty.");
		}
	}
	
	public void cmdSendAndReceive()
	{
		// [temporary solution]
		
		int count = _mailclient.getOutBox().count();
		
		for (int i = 0; i < count; i++)
		{
			// remove message from outgoing and add to incoming
			Message message = _mailclient.getOutBox().remove(i);
			_mailclient.getInBox().add(message);
		}
	}
	
	public void cmdReadInboxMessage()
	{
		if (_mailclient.getInBox().count() > 0)
		{
			System.out.print("Message #: ");
			int n = _keyboard.nextInt();
			int n_real = n - 1;
			
			Message message = _mailclient.getInBox().getMessage(n_real);
			
			if (message != null)
			{
				message.show();
			}
			else
			{
				System.out.println("Message number " + n + " can't be found.");
			}
		}
		else
		{
			System.out.println("Inbox empty.");
		}
	}
	
	public void cmdDeleteFromInbox()
	{
		if (_mailclient.getInBox().count() > 0)
		{
			System.out.print("Message #: ");
			int n = _keyboard.nextInt();
			int n_real = n - 1;
			
			Message message = _mailclient.getInBox().remove(n_real);
			
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
