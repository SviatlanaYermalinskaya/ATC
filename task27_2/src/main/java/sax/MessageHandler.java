package sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import model.Message;

public class MessageHandler extends DefaultHandler
{
    private List<Message> messages;
    private Message message;
    boolean bTo = false;
    boolean bSubject = false;
    boolean bMsgbody = false;

    public List<Message> getMessages()
    {
        return messages;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        if (qName.equalsIgnoreCase("message"))
        {
            message = new Message();
            if (messages == null)
            {
            	messages = new ArrayList<>();
            }
        }
        else if (qName.equalsIgnoreCase("to"))
        {
            bTo = true;
        }
        else if (qName.equalsIgnoreCase("subject"))
        {
            bSubject = true;
        }
        else if (qName.equalsIgnoreCase("msgbody"))
        {
            bMsgbody = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        if (qName.equalsIgnoreCase("message"))
        {
            messages.add(message);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException
    {
        if (bTo)
        {
            message.setTo(new String(ch, start, length));
            bTo = false;
        }
        else if (bSubject)
        {
            message.setSubject(new String(ch, start, length));
            bSubject = false;
        }
        else if (bMsgbody)
        {
            message.setMsgbody(new String(ch, start, length));
            bMsgbody = false;
        }
    }
}
