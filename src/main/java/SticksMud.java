import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * 
 (Throwable t) { }
 (Exception e) { }
 (NullPointerException np) { }
 (ClassCastException cc) { }
 (RuntimeException rt) { }
 (IllegalArgumentException arg) { }
 (FileNotFoundException fnf) { }

 */
/*Given that File.createNewFile() throws IOException, and thatFileNotFoundException extends IOException, 
use the following fragments to fill in the blanks so that the code compiles.
You must use all the fragments, and each fragment can be used only once.
Note: As in the real exam, some drag-and-drop style questions might have several correct answers. 
You will receive full credit for ANY one of the correct answers.*/

public class SticksMud {

	public void testSticksMud() {
		try {
			File dir = new File("dir");
			dir.createNewFile();
		} catch (IllegalArgumentException arg) {
		} catch (NullPointerException np) {
		} catch (FileNotFoundException fnf) {
		} catch (IOException io) {
		} catch (ClassCastException cc) {
		} catch (RuntimeException rt) {
		} catch (Exception e) {
		} catch (Throwable t) {
		}
	}
}