public class ActionHeal extends Action{

    @Override
    public void effect(Player player) {
       player.addLife(1);
       Soundeffects.playSound("Heal");

    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "GetLife";
    }
    

}
