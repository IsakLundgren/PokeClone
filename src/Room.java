public class Room {

    protected RoomName name;
    protected int[] access;
    protected Object[] obj;

    Room(RoomName name, int[] access, Object[] obj){
        this.name = name;
        this.access = access;
        this.obj = obj;
    }

    public RoomName getName() {
        return name;
    }

    public void printOptions(){
        if(obj.length != 0){
            for(int i = 0; i < obj.length; i++){
                System.out.println("inspect" + i + ": inspect the " + obj[i].getName() + ".");
            }
        }
        for (int value : access) {
            System.out.println("move" + value + ": go to " + RoomName.values()[value] + ".");
        }
    }

    public void inspect(Player player, int objectNumber){
        try{
            //TODO Make inner loop for inspection. Fighting etc.
            System.out.println(name + obj[objectNumber].getName() + player.getName());
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("No, that can't be right.");
        }
    }

    public int[] getAccess(){
        return access;
    }

    public Object[] getObj() {
        return obj;
    }
}
