// Project 7: Email Client 2
// CSE1102 Spring 2015
// Shemona Singh
// May 3, 2015
// TA: Zigeng Wang
// Section: 005
// Instructor: Jeffrey A. Meunier

package client;

public class Contact {
	
	private String _email;
	private String _name;
	private String _nick;
	
	public Contact(String email)
	{
		this(email, null, null);
	}
	
	public Contact(String email, String name, String nick)
	{
		_email = email;
		_name = name;
		_nick = nick;
	}
	
	@Override
	public String toString()
	{
		String rep = "<" + _email + ">";
		
		if (_name != null && _nick != null)
		{
			rep = _name + " (" + _nick + ") " + rep;
		}
		
		return rep;
	}
	
	public String getNick()
	{
		return _nick;
	}
}
