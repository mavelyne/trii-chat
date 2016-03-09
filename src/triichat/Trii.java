package triichat;

/**
 * Created by matthewzhan on 3/8/16.
 */
public class Trii {
    String name;
    Message root;

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
