package triichat;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
/**
 * Created by matthewzhan on 3/8/16.
 */
@Entity
public class Trii {
	@Id private Long id;
    String name;
    Message root;

    private Trii(){}
    public Trii(String name, Message firstMessage)
    {
        this.name = name;
        this.root = firstMessage;
    }

    public Message getRoot()
    {
        return root;
    }
}
