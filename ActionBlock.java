public class ActionBlock extends Action {

    @Override
    public void effect(Player player) {
        System.out.println("You just blocked the others player attack!");

    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Block";
    }
    
}
