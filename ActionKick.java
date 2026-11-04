public class ActionKick extends Action {



    @Override
    public void effect(Player player) {
        player.minusLife(-1);
      
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Kick";
    }


    

}
