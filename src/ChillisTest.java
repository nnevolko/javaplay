import java.util.HashMap;
import java.util.Map;


public class ChillisTest {

	
	public void testChilli(String[] args){
		
		/**
		 Fill in the blanks using the following fragments,
		  so that the code compiles and the invocation "java Enchilada green 4" 
		  produces the output "wow". Note: You might not need to fill in all of the blanks, 
		  you won’t use all of the fragments, and each fragment can be used more than once.
		 * 
		 */
		Map<Chilis, String> map = new HashMap<Chilis, String>();
		Chilis myC = new Chilis("green", 4);
		map.put(new Chilis("red", 4), "alarm");
		map.put(myC,  "wow");
		map.put(new Chilis("yellow", 2), "medium");
		// something here
		Chilis c = new Chilis(args[0], Integer.parseInt(args[1]));
		// print something to get "wow"
		System.out.println(map.get(c));
		
		for (Map.Entry<Chilis, String> entry: map.entrySet()){
			System.out.println(entry.getKey().getColor() +" " + entry.getKey().getHotness()+ " " + entry.getValue());
		}
	}
}


class Chilis{
	
	String color;
	int hotness;
	
	
	public Chilis(String color, int hotness) {
		super();
		this.color = color;
		this.hotness = hotness;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getHotness() {
		return hotness;
	}
	public void setHotness(int hotness) {
		this.hotness = hotness;
	}
	
	@Override
	 public boolean equals(Object o) {
		Chilis c = (Chilis)o;
         if(color.equals(c.color) &&   (hotness == c.hotness))  return true;
         return false;
	}
	@Override
       public int  hashCode() { return hotness; }
	
	/*
	
	Fragments:
		 //
		   m.put
		   args[2]
		   args[1]
		   boolean
		Chilis c
		m.add
		Integer.parseInt
		m.get(c)
		int
		1
		true
		false
		(hotness == c.hotness)
		Chilis c = (Chilis)o;
		-1
		color
		(this == c)
		Object o
		&&
		hotness               args[0]
		m.contains(c)         Integer.intValue
		void                  color.equals(c.color)
		String                0
		||
		*/
}