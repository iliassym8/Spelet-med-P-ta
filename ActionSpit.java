public class ActionSpit extends Action {

    @Override
    public void effect(Player player) {
        System.out.println("You just spit " + player.getName() + ", not damage though!");
        Soundeffects.playSound("Spit");

    }

    @Override
    public String getName() {
        return "Spit";
    }
    
}
