public class ActionKick extends Action {



    @Override
    public void effect(Player player) {
        player.minusLife(1);
        System.out.println(player.getName() + " has, " + player.getLife() + " life left.");
      Soundeffects.playSound("Kick");
    }

    @Override
    public String getName() {
        return "Kick";
    }


    

}
