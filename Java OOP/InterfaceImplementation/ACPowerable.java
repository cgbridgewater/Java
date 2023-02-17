

public interface ACPowerable{
    Integer voltage = 120;
    Integer frequence = 60;

    abstract void unPlug();
    abstract Boolean checkPluggedIn();

    public default void hasPower(){
        String message = "this device is ";
        if(!checkPluggedIn()) {
            message += "not ";
        }
        System.out.println(message + "plugged in.");
    }
}