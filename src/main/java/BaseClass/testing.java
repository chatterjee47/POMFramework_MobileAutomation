package BaseClass;

import java.io.File;

public class testing {

	public static void main(String[] args) {
		
		File filePath = new File(System.getProperty("user.dir"));
		File appDir = new File(filePath, "/app");
		File app = new File(appDir, "Turnkey_ceeaa872-7331-4190-bccd-111cd935e23e.apk");
		
		
		
		 
		  
          // Get the absolute path of file f 
          String absolute = app.getAbsolutePath(); 
          System.out.println("Absolute  path: "+ absolute); 

	}

}
