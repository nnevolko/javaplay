package main.java;

/*
 * nnevolko
 */
 public class Singleton{
    
    private static Singleton instance;
    public String str;
    
    //cannot instantiate
    private Singleton(){
        //str = "";
    }
    
    // this needs to be synchronized for multithreading
    public static Singleton getSingleInstance(){
        if (instance == null){
            instance = new Singleton();
            return instance;
        } else {
            return instance;
        }
    }

}
