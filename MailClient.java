// Project 7: Email Client 2
// CSE1102 Spring 2015
// Shemona Singh
// May 3, 2015
// TA: Zigeng Wang
// Section: 005
// Instructor: Jeffrey A. Meunier

package client;

public class MailClient {
	private Contact _contact;
	private AddressBook _addressBook;
	private MailBox _incoming;
	private MailBox _outgoing;
	
	public MailClient(Contact contact)
	{
		_contact = contact;
		_addressBook = new AddressBook();
		_incoming = new MailBox();
		_outgoing = new MailBox();
		
		_addressBook.add(_contact);
	}
	
	public void addToInBox(Message message)
	{
		_incoming.add(message);
	}
	
	public void addToOutBox(Message message)
	{
		_outgoing.add(message);
	}
	
	public MailBox getInBox()
	{
		return _incoming;
	}
	
	public MailBox getOutBox()
	{
		return _outgoing;
	}
	
	public Contact getMyAddress()
	{
		return _contact;
	}
	
	public AddressBook getAddressBook()
	{
		return _addressBook;
	}
	
	public Contact searchForContact(String nick)
	{
		return _addressBook.search(nick);
	}
}
