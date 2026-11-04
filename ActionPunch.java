public class ActionPunch extends Action {

    @Override
    public void effect(Player player) {
            player.minusLife(1);
            System.out.println(player.getName() + " has, " + player.getLife() + " life left.");
            Soundeffects.playSound("Punch");

    }

    @Override
    public String getName() {
     return "Punch";
    }
    
}
