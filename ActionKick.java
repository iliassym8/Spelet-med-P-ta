public class ActionKick extends Action {



    @Override
    public void effect(Player player) {
        player.setLife(-1);
      
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Kick";
    }


    

}
