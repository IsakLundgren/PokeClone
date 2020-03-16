import java.util.*;

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

    public String printOptions(){
        String opt;
        if(obj.length != 0){
            for(int i = 0; i < obj.length; i++){

            }
        }
        return null;
    }

    public int[] getAccess(){
        return access;
    }
}
