import java.util.ArrayList;
import java.util.List;

public class Player {
    int life;
    String name;
    
    public int getLife() {
        return life;
    }
    public String getName() {
        return name;
    }
    public void setLife(int life) {
        this.life = life;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Player(int life, String name) {
        this.life = life;
        this.name = name;
    }

    List<Action> actions = new ArrayList<>();

    
    




}