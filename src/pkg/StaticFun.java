package pkg;

public class StaticFun {
	
	public static  void func(){};
	public static final StaticFun a = new StaticFun(3);
	public int var = 42;
	
	public static enum PLANT{ GREEN, DEAD};
	
	public StaticFun(int a){
		var = a;
	}
	
	public void setVar (int a){
		var = a;
	}
	
}
