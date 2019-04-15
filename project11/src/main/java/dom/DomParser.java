package dom;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.Message;

public class DomParser
{
    public List<Message> parse(Document document) throws FileNotFoundException, XMLStreamException
    {
        NodeList nodeList = document.getElementsByTagName("message");
        List<Message> messages = new ArrayList<Message>();
        for (int i = 0; i < nodeList.getLength(); i++)
        {
            messages.add(getMessage(nodeList.item(i)));
        }
        return messages;
    }

    private static Message getMessage(Node node)
    {
        Message message = new Message();
        Element element = (Element) node;
        message.setTo(getTagValue("to", element));
        message.setSubject(getTagValue("subject", element));
        message.setMsgbody(getTagValue("msgbody", element));
        return message;
    }

    private static String getTagValue(String tag, Element element)
    {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}
