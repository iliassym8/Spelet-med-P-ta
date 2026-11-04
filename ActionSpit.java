public class ActionSpit extends Action {

    @Override
    public void effect(Player player) {
        System.out.println("You just spit the other player, not damage though!");

    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Spit";
    }
    
}
