
 public class Singleton{
    
    private static Singleton instance;
    public String str;
    
    //cannot instantiate
    private Singleton(){
        //str = "";
    }
    
    public static Singleton getSingleInstance(){
        if (instance == null){
            instance = new Singleton();
            return instance;
        } else {
            return instance;
        }
    }

}
