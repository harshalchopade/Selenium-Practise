package filepermission;

import java.io.File;

public class SetPermissionOnFile {

	public static void main(String[] args) {
		File file = new File("./src/filepermission/Test.java");
		file.setExecutable(true);
		file.setReadable(false);
		file.setWritable(true);


	}
}