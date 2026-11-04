public class ActionPunch extends Action {

    @Override
    public void effect(Player player) {
            player.setLife(-1);
    }

    @Override
    public String getName() {
     return "Kick";
    }
    
}
