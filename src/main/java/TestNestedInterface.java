

interface Showable {
	void show();

	interface Message {
		void msg();
	}
}

class TestNestedInterface implements Showable.Message {
	public void msg() {
		System.out.println("Hello nested interface");
	}

}