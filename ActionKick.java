public class ActionKick extends Action {



    @Override
    public void effect(Player player) {
        player.minusLife(1);
      Soundeffects.playSound("Kick");
    }

    @Override
    public String getName() {
        return "Kick";
    }


    

}
