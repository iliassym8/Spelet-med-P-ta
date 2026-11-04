public class ActionHeal extends Action{

    @Override
    public void effect(Player player) {
       player.addLife(+1);
        
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "GetLife";
    }
    

}
