public class ActionPunch extends Action {

    @Override
    public void effect(Player player) {
            player.minusLife(1);
            Soundeffects.playSound("Punch");

    }

    @Override
    public String getName() {
     return "Punch";
    }
    
}
