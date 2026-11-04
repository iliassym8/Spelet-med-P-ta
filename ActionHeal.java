public class ActionHeal extends Action{

    @Override
    public void effect(Player player) {
       GameManager.getCurrentPlayer().addLife(1);
       System.out.println(GameManager.getCurrentPlayer().getName() + " has, " + GameManager.getCurrentPlayer().getLife() + " life left.");
       Soundeffects.playSound("Heal");

    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Heal";
    }
    

}
