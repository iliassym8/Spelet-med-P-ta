public class ActionPunch extends Action {

    @Override
    public void effect(Player player) {
            player.minusLife(-1);
    }

    @Override
    public String getName() {
     return "Punch";
    }
    
}
