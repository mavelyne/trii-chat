package triichat;

import java.util.HashSet;
import java.util.Set;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Load;
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
    @Load private Set<Ref<User>> contacts;
    @Load private Set<Ref<Group>> groups;

    private User(){
    	this.contacts = new HashSet<Ref<User>>();
        this.groups = new HashSet<Ref<Group>>();
    }
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
        OfyService.ofy().save().entity(made).now();
        return made;
    }
    
    public void setName(String name){
    	this.name = name;
    	OfyService.ofy().save().entities(this).now();
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		OfyService.ofy().save().entities(this).now();
	}

	public String getName() {
		return name;
	}
	
	public Set<Group> getGroups(){
		Set<Group> retval = new HashSet<Group>();
		for(Ref<Group> r : this.groups){
			retval.add(r.get());
		}
		return retval;
	}
	
	public Set<User> getContacts(){
		Set<User> retval = new HashSet<User>();
		for(Ref<User> r : this.contacts){
			retval.add(r.get());
		}
		return retval;
	}
	
	public void addGroup(Group group){
		this.groups.add(Ref.create(group));
		OfyService.ofy().save().entity(this).now();
	}
	
	public void addContact(User contact){
		this.contacts.add(Ref.create(contact));
		OfyService.ofy().save().entity(this).now();
	}
	
	/**
	 * Returns User id which is same as com.google.appengine.api.users.User.getUserId()
	 * @return
	 */
	public String getId(){
		return this.id;
	}
    
	/**
	 * Finds a user in datastore 
	 * @param user
	 * @return User
	 */
	public static User findUser(com.google.appengine.api.users.User user){
		String toFind = user.getUserId();
		Ref<User> found = OfyService.ofy().load().type(User.class).id(toFind);
		if(found == null){ 
			return null;
		}else{
			return found.get();
		}
	}
	
	/**
	 * INCOMPLETE
	 * Finds user in datastore by name. Very expensive operation.
	 * @param name
	 * @return Set of users since multiple users can have same name
	 */
	public static Set<User> findUserByName(String name){
		Set<User> retval = new HashSet<User>();
		//TODO : finish this
		return retval;
	}
	
}
