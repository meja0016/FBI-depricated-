public class JNI { 
	static { 
		System.loadLibrary("jni"); 
	} 
	private native void sayHello(); 

	public static void main(String[] args) { 
		new JNI().sayHello(); 
	} 
}