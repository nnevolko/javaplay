import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

/*
 * nnevolko
 */

public class ReflectStudent {

	public void reflectOnSTudent() {

		Class student;
		try {
			student = Class.forName("Student");

			Method[] methods = student.getDeclaredMethods();

			ArrayList<String> methodList = new ArrayList<>();
			for (Method method: methods){
				methodList.add(method.getName());
			}
			
			Collections.sort(methodList);
			for (String name : methodList) {
				System.out.println(name);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
