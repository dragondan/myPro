import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.Arrays;

import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileManager.Location;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class DynamicPOJO {
	private static String classString = "/* hehha */" + "public class Student{                                  "
			+ "       private String  studentId;                      "
			+ "       public String getStudentId(){                   "
			+ "           return \"小明\";                      "
			+ "       }                                               "
			+ "}                                                    ";

	private static void createStudent() throws Exception {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager standardFileManager = compiler.getStandardFileManager(null, null, null);
		ClassJavaFileManager classJavaFileManager = new ClassJavaFileManager(standardFileManager);
		StringObject stringObject = new StringObject(new URI("Student.java"), JavaFileObject.Kind.SOURCE, classString);
		JavaCompiler.CompilationTask task = compiler.getTask(null, classJavaFileManager, null, null, null,
				Arrays.asList(stringObject));
		if (task.call()) {
			ClassJavaFileObject javaFileObject = classJavaFileManager.getClassJavaFileObject();
			ClassLoader classLoader = new MyClassLoader(javaFileObject);
			Object student = classLoader.loadClass("Student").newInstance();
			System.out.println("student-->" + student);// student对象
			Method getStudetnId = student.getClass().getMethod("getStudentId");
			Object invoke = getStudetnId.invoke(student);
			System.out.println("getStudentId-->" + invoke);
		}
	}

	/** *自定义fileManager */
	static class ClassJavaFileManager extends ForwardingJavaFileManager {
		private ClassJavaFileObject classJavaFileObject;

		public ClassJavaFileManager(JavaFileManager fileManager) {
			super(fileManager);
		}

		public ClassJavaFileObject getClassJavaFileObject() {
			return classJavaFileObject;
		}

		/** 这个方法一定要自定义 */
		@Override
		public JavaFileObject getJavaFileForOutput(Location location, String className, JavaFileObject.Kind kind,
				FileObject sibling) throws IOException {
			return (classJavaFileObject = new ClassJavaFileObject(className, kind));
		}
	}

	/** * 存储源文件 */
	static class StringObject extends SimpleJavaFileObject {
		private String content;

		public StringObject(URI uri, Kind kind, String content) {
			super(uri, kind);
			this.content = content;
		}

		@Override
		public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
			return this.content;
		}
	}

	/** * class文件（不需要存到文件中） */
	static class ClassJavaFileObject extends SimpleJavaFileObject {
		ByteArrayOutputStream outputStream;

		public ClassJavaFileObject(String className, Kind kind) {
			super(URI.create(className + kind.extension), kind);
			this.outputStream = new ByteArrayOutputStream();
		} // 这个也要实现

		@Override
		public OutputStream openOutputStream() throws IOException {
			return this.outputStream;
		}

		public byte[] getBytes() {
			return this.outputStream.toByteArray();
		}
	}

	/** 自定义classloader */
	static class MyClassLoader extends ClassLoader {
		private ClassJavaFileObject stringObject;

		public MyClassLoader(ClassJavaFileObject stringObject) {
			this.stringObject = stringObject;
		}

		@Override
		protected Class<?> findClass(String name) throws ClassNotFoundException {
			byte[] bytes = this.stringObject.getBytes();
			return defineClass(name, bytes, 0, bytes.length);
		}
	}

	public static void main(String[] args) throws Exception {
		createStudent();
	}
}
