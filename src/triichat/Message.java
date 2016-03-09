package triichat;

import java.util.Date;
import java.util.Set;

/**
 * Created by Margret on 3/8/2016.
 */
public class Message {

    private String content;
    private Set<Message> parents;
    private Set<Message> replies;
    private Date timestamp;
    
    
    public Message(String content, Set<Message> parents){
    	this.content = content;
    	this.parents = parents;
    }
    
	public String getContent() {
		return content;
	}
	public Set<Message> getParents() {
		return parents;
	}
	public Set<Message> getReplies() {
		return replies;
	}
	public Date getTimeStamp() {
		return timestamp;
	}

   
    
}
