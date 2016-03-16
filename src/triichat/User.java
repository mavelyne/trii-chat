package triichat;

import java.util.Set;
import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.cmd.Query;
/**
 * Created by Margret on 3/8/2016.
 */
@Entity
public class User {
	/*
	 * Adapter for com.google.appending.api.users.User to add our functionality
	 */
	@Id private String id;	//Objectify id uses user id from com.google.appengine.api.users
    private String name;
    private String email;
    private Set<Ref<User>> contacts;
    private Set<Ref<Group>> groups;

    /**
     * Creates and saves user
     * @param user
     * @return the newly instantiated and stored User
     */
    public static User createUser(com.google.appengine.api.users.User user) {
        User made = new User();
        made.id = user.getUserId();
        made.email = user.getEmail();
        made.name = user.getNickname();
        OfyService.ofy().save().entity(made);
        return made;
    }
    
    public void setName(String name){
    	this.name = name;
    	OfyService.ofy().save().entities(this);
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		OfyService.ofy().save().entities(this);
	}

	public String getName() {
		return name;
	}
    
	public static User findUser(com.google.appengine.api.users.User user){
		String toFind = user.getUserId();
		Ref<User> found = OfyService.ofy().load().type(User.class).id(toFind);
		if(found == null){ 
			return null;
		}else{
			return found.get();
		}
	}
}
