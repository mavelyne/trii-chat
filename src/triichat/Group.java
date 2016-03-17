package triichat;

import java.util.List;
import java.util.Set;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by Margret on 3/8/2016.
 */
@Entity
public class Group {
	@Id private Long id;
	String name;
    Set<User> users;
    Set<Trii> triis;

    private Group(){}
    public void addUser(String name){
        //TODO
    }

    public Trii addTrii(String name, Message first){
        //TODO
        return null;
    }

    public Set<Trii> getTriis(){
        //TODO
        return null;
    }

    public Trii getTrii(String name){
        //TODO
        return null;
    }

    public Set<User>  getUsers(){
        //TODO
        return null;
    }

}
