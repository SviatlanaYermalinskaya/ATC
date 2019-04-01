package homework;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class VkMessage {
	private String access_token;
	private HttpClient client;
	
	public VkMessage(String token)
	{
		this.access_token = token;
		client = HttpClientBuilder.create().build();
	}	
	
	public String sendMessage(String owner, String message) // return response result or error message
	{
		try
		{
            URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.post?");
            builder.setParameter("access_token", access_token)
            .setParameter("owner_id", owner)
            .setParameter("message", message)
            .setParameter("v", "5.92");
            HttpGet request = new HttpGet(builder.build());
            HttpResponse response = client.execute(request);           
          
            return EntityUtils.toString(response.getEntity());                   	
		}
		catch (URISyntaxException ex)
		{
			return "error: ".concat(ex.getMessage());
		}
		catch (ClientProtocolException ex)
		{
			return "error: ".concat(ex.getMessage());
		}
		catch (IOException ex)
		{
			return "error: ".concat(ex.getMessage());
		}
	}
	
	public String sendMessage(String owner, String message, String attachment) // return response result or error message
	{
		try
		{
            URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.post?");
            builder.setParameter("access_token", access_token)
            .setParameter("owner_id", owner)
            .setParameter("message", message)
            .setParameter("attachments", attachment)
            .setParameter("v", "5.92");
            HttpGet request = new HttpGet(builder.build());
            HttpResponse response = client.execute(request);           
          
            return EntityUtils.toString(response.getEntity());                   	
		}
		catch (URISyntaxException ex)
		{
			return "error: ".concat(ex.getMessage());
		}
		catch (ClientProtocolException ex)
		{
			return "error: ".concat(ex.getMessage());
		}
		catch (IOException ex)
		{
			return "error: ".concat(ex.getMessage());
		}
	}
	
	public String editMessage(String owner, String post_id, String message) // return response result or error message
	{
		try
		{
            URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.edit?");
            builder.setParameter("access_token", access_token)
            .setParameter("owner_id", owner)
            .setParameter("post_id", post_id)
            .setParameter("message", message)
            .setParameter("v", "5.92");
            HttpGet request = new HttpGet(builder.build());
            HttpResponse response = client.execute(request);           
          
            return EntityUtils.toString(response.getEntity());                   	
		}
		catch (URISyntaxException ex)
		{
			return "error: ".concat(ex.getMessage());
		}
		catch (ClientProtocolException ex)
		{
			return "error: ".concat(ex.getMessage());
		}
		catch (IOException ex)
		{
			return "error: ".concat(ex.getMessage());
		}
	}
	
	
	public String deleteMessage(String owner, String post_id) // return response result or error message
	{
		try
		{      
            URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.delete?");
            builder.setParameter("access_token", access_token)
            .setParameter("owner_id", owner)
            .setParameter("post_id", post_id)
            .setParameter("v", "5.92");
            HttpGet request = new HttpGet(builder.build());
            HttpResponse response = client.execute(request);
            
             return EntityUtils.toString(response.getEntity()); 		
		}
		catch (URISyntaxException ex)
		{
			return "error: ".concat(ex.getMessage());
		}
		catch (ClientProtocolException ex)
		{
			return "error: ".concat(ex.getMessage());
		}
		catch (IOException ex)
		{
			return "error: ".concat(ex.getMessage());
		}
	}
	
	public boolean isPostedTextEqualsMsg(String owner, String post_id, String msg)
	{
		String[] msg_parts;
		String msg_part;
		
		try
		{      
            URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.getById?");
            builder.setParameter("access_token", access_token)
            .setParameter("posts", owner+"_"+post_id)
            .setParameter("v", "5.92");
            HttpGet request = new HttpGet(builder.build());
            HttpResponse response = client.execute(request);
            
            msg_part = EntityUtils.toString(response.getEntity()); 		
		}
		catch (URISyntaxException ex)
		{
			return false;
		}
		catch (ClientProtocolException ex)
		{
			return false;
		}
		catch (IOException ex)
		{
			return false;
		}

		msg_parts = msg_part.split("\"text\":\"");
		msg_parts = msg_parts[1].split("\",\"can_edit\"");
		
		return msg.equals(msg_parts[0]);
	}
	
	public boolean isMessageDeleted(String owner, String post_id)
	{
		String msg_part;
		
		try
		{      
            URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.getById?");
            builder.setParameter("access_token", access_token)
            .setParameter("posts", owner+"_"+post_id)
            .setParameter("v", "5.92");
            HttpGet request = new HttpGet(builder.build());
            HttpResponse response = client.execute(request);
            
            msg_part = EntityUtils.toString(response.getEntity()); 		
		}
		catch (URISyntaxException ex)
		{
			return false;
		}
		catch (ClientProtocolException ex)
		{
			return false;
		}
		catch (IOException ex)
		{
			return false;
		}
		
		return "{\"response\":[]}".equals(msg_part);
	}

	public boolean isPostedPhotoEquals(String owner, String post_id, String photo_owner, String photo_id)
	{
		String[] msg_parts;
		String msg_part;
		
		try
		{      
            URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.getById?");
            builder.setParameter("access_token", access_token)
            .setParameter("posts", owner+"_"+post_id)
            .setParameter("v", "5.92");
            HttpGet request = new HttpGet(builder.build());
            HttpResponse response = client.execute(request);
            
            msg_part = EntityUtils.toString(response.getEntity()); 		
		}
		catch (URISyntaxException ex)
		{
			return false;
		}
		catch (ClientProtocolException ex)
		{
			return false;
		}
		catch (IOException ex)
		{
			return false;
		}
		msg_parts = msg_part.split("\"attachments\":");
		msg_parts = msg_parts[1].split("\"id\":");
		msg_parts = msg_parts[1].split(",\"sizes\":");
		msg_parts = msg_parts[0].split(",\"album_id\":");
		if (!photo_id.equals(msg_parts[0]))
		{
			return false;
		}
		msg_parts = msg_parts[1].split("\"owner_id\":");
		return photo_owner.equals(msg_parts[1]);
	}

}
