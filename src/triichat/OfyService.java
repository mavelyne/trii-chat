package triichat;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.Objectify;

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

public class OfyService {
    static {
        // register all classes here
        //ObjectifyService.register(Greeting.class);
        //ObjectifyService.register(Subscriber.class);
    }

    // use OfyService.ofy() in place of ofy()
    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }
	
    public static ObjectifyFactory factory(){
        return ObjectifyService.factory();
    }
}
