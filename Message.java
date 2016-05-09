// Project 7: Email Client 2
// CSE1102 Spring 2015
// Shemona Singh
// May 3, 2015
// TA: Zigeng Wang
// Section: 005
// Instructor: Jeffrey A. Meunier

package client;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
	private Contact _from;
	private Contact _to;
	private String _subject;
	private String _body;
	private Date _timestamp;
	
	public Message(Contact from, Contact to, String subject, String body)
	{
		_from = from;
		_to = to;
		_subject = subject;
		_body = body;
		_timestamp = new Date();
	}
	
	public void show()
	{		
		System.out.println("Date: " + this.dateToString());
		System.out.println("From: " + _from);
		System.out.println("Subj: " + _subject);
		System.out.println(_body);
	}
	
	public String dateToString() // [not in pdf]
	{
		SimpleDateFormat datef = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return datef.format(_timestamp);
	}
	
	public String toString()
	{
		return "FROM: " + _from + ", TO: " + _to + ", SUBJ: " + _subject + ", DATE: " + this.dateToString();
	}
}
