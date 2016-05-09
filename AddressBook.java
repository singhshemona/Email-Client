// Project 7: Email Client 2
// CSE1102 Spring 2015
// Shemona Singh
// May 3, 2015
// TA: Zigeng Wang
// Section: 005
// Instructor: Jeffrey A. Meunier

package client;

import java.util.ArrayList;

public class AddressBook {
	private ArrayList<Contact> _contacts = new ArrayList<Contact>();
	
	public void add(Contact contact)
	{
		_contacts.add(contact);
	}
	
	public Contact remove(String nick)
	{
		Contact contact = this.search(nick);
		
		if (contact != null)
		{
			_contacts.remove(contact);
			return contact;
		}
		else
		{
			return null;
		}
	}
	
	public Contact search(String nick)
	{
		for (Contact contact : _contacts)
		{
			String testnick = contact.getNick();
			
			if (testnick != null && testnick.equals(nick))
			{
				return contact;
			}
		}
		
		return null;
	}
	
	public void show()
	{
		for (int i = 0; i < _contacts.size(); i++)
		{
			System.out.println((i + 1) + ". " + _contacts.get(i));
		}
	}

	public void load(String string) {
		// TODO Auto-generated method stub
		
	}
}
