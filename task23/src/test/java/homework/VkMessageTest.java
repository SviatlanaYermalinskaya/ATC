package homework;

import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;



public class VkMessageTest {
	private String access_token_offline = "942c59c509078e2614334eae0664a27dcecbe85589d8f5e519e968a91ac98cf3ae487966146284b8553c1";
	private String owner_id = "538134391";
	private String photo_owner_id = "357942467";
	private String photo_id = "433264631";
	private String msg1 = "Hello! It's a test!";
	private String msg2 = "This message is replaced.";
	private String msg3 = "Test photo attachment.";
	private String response_msg = "";
	private String msg_number = null;
	private VkMessage vkMessage = new VkMessage(access_token_offline);
	
	@Test
	public void test()
	{	
		// send post
		response_msg = vkMessage.sendMessage(owner_id, msg1);
		Assert.assertFalse(response_msg.contains("error"));		
		msg_number = response_msg.replaceAll("\\D", "");
		//check posted message
        Assert.assertTrue(vkMessage.isPostedTextEqualsMsg(owner_id, msg_number, msg1));
        
        // edit post
        response_msg = vkMessage.editMessage(owner_id, msg_number, msg2);
        Assert.assertFalse(response_msg.contains("error"));
		//check edited message
        Assert.assertTrue(vkMessage.isPostedTextEqualsMsg(owner_id, msg_number, msg2));
		
        // delete post
        response_msg = vkMessage.deleteMessage(owner_id, msg_number);
        Assert.assertFalse(response_msg.contains("error"));
        // check deletion
        Assert.assertTrue(vkMessage.isMessageDeleted(owner_id, msg_number));  
	}
	
	
	@Test
	public void testPostWithPhoto()
	{	
		// send post with photo
		response_msg = vkMessage.sendMessage(owner_id, msg3, "photo" + photo_owner_id + "_" + photo_id);
		Assert.assertFalse(response_msg.contains("error"));		
		msg_number = response_msg.replaceAll("\\D", "");
		//check posted message and attachment
        Assert.assertTrue(vkMessage.isPostedTextEqualsMsg(owner_id, msg_number, msg3));
        Assert.assertTrue(vkMessage.isPostedPhotoEquals(owner_id, msg_number, photo_owner_id, photo_id));
        
        // delete post
        response_msg = vkMessage.deleteMessage(owner_id, msg_number);
        Assert.assertFalse(response_msg.contains("error"));
        // check deletion
        Assert.assertTrue(vkMessage.isMessageDeleted(owner_id, msg_number));  
	}  

}
