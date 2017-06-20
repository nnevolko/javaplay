import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class ParenthesisStack {
	
	  public void checkBalanced(String input){

        if (input.length()%2 != 0){
        	 System.out.println(false);
        	 return;
        }
        

       Stack<Character> charStack = new Stack<>();      
       for (int i = 0; i< input.length(); i++){
           boolean putOnStack = true;
           if (i!=0 && !charStack.isEmpty()){
               if (charStack.peek() == '{' && input.charAt(i) == '}'){
                   charStack.pop();
                   putOnStack = false;
               } else if (charStack.peek() == '(' && input.charAt(i) == ')'){
                   charStack.pop();
                   putOnStack = false;
               } else if (charStack.peek() == '[' && input.charAt(i) == ']'){
                    charStack.pop();
                   putOnStack = false;
               }
           }
           if (putOnStack){
               charStack.push(input.charAt(i));
           }
       }

       if (charStack.isEmpty()){
           System.out.println(true);
       } else {
           System.out.println(false);
       }
    }



public void testBalanced(){
	
	List<String> inputStrings = new ArrayList<>();
	inputStrings.add("{}()");
	inputStrings.add("({()})");
	inputStrings.add("{}(");
	inputStrings.add("[]");

	for (String input: inputStrings){
		checkBalanced(input);
	}

}

}
