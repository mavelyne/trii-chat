package triichat;

import com.google.appengine.api.datastore.Entity;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.cmd.Loader;

/* Usage

 * Get the ofy() object
 Objectify objectify = OfyService.ofy();

 * Saving
 objectify.save().entity(greeting).now();

 * Loading
 List<Greeting> msgs = objectify.load().type(Greeting.class).list();

 * Filters
 Iterable<Key<Greeting>> keys = objectify.load().type(Greeting.class).filter("email", user.getEmail()).keys();

 * Deleting
 objectify.delete().keys(keys);

 */
/**
 * 
 * Objectify adapter used to register all classes that will be stored.
 * @author Matthew Zhan, Margret Tumbokon
 *
 */
public class OfyService {
	/*
	 * Adapter pattern or facade?
	 */
    static {
        // register all classes here
        ObjectifyService.register(triichat.Group.class);
        ObjectifyService.register(triichat.Message.class);
        ObjectifyService.register(triichat.Trii.class);
        ObjectifyService.register(triichat.User.class);
    }

    /**
     * Use in place of ObjectifyService.ofy()
     */
    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }
    /**
     * Use in place of ObjectifyService.factory()
     */
    public static ObjectifyFactory factory(){
        return ObjectifyService.factory();
    }
    
    /**
     * Saves an entity.
     * @param entity
     * @return true if successful save
     */
    public static boolean save(Object entity){
    	try{
    		OfyService.ofy().save().entity(entity).now();
    		return true;
    	}catch(Exception e){
    		return false;
    	}
    }
   
}
