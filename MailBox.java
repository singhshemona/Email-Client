// Project 7: Email Client 2
// CSE1102 Spring 2015
// Shemona Singh
// May 3, 2015
// TA: Zigeng Wang
// Section: 005
// Instructor: Jeffrey A. Meunier

package client;

import java.util.ArrayList;

public class MailBox {
	private ArrayList<Message> _messages = new ArrayList<Message>();
	
	public void add(Message message)
	{
		_messages.add(message);
	}
	
	public Message remove(int n)
	{
		Message message = getMessage(n);
		
		if (message != null)
		{
			_messages.remove(message);
			return message;
		}
		else
		{
			return null;
		}
	}
	
	public int count()
	{
		return _messages.size();
	}
	
	public boolean messageExists(int n)
	{
		return n >= 0 && n < this.count();
	}
	
	public Message getMessage(int n)
	{
		if (this.messageExists(n))
		{
			return _messages.get(n);
		}
		else
		{
			return null;
		}
	}
	
	public void show()
	{
		for (int i = 0; i < this.count(); i++)
		{
			System.out.println((i + 1) + ". " + _messages.get(i));
		}
	}

	public void load(String string) {
		// TODO Auto-generated method stub
		
	}
	
}
