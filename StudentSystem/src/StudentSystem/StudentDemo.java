package StudentSystem;
/*
 * @31号
 本人大一软件1班学生
 做的简单集合的学生管理系统练习
 */
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import javax.print.DocFlavor.STRING;
import javax.swing.event.SwingPropertyChangeSupport;
public class StudentDemo {
	// 创建ArrayList集合
	static ArrayList<Student> a = new ArrayList<Student>();
	public static void main(String[] args) {
		// 用while循环回到主界面
		while (true) {
			System.out.println("欢迎来到学生管理系统！");
			System.out.println("1-添加学生\t2-删除学生\t3-修改学生\t4-查看单个学生\t5-查看所有学生\t6-退出系统");
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入你的选择：");
			String s = scanner.nextLine();
			// 使用switch提供选择
			switch (s) {
			case "1": {
				addStu();
				break;
			}
			case "2": {
				deleteStu();
				break;
			}
			case "3": {
				updateStu();
				break;
			}
			case "4": {
				findStu();
				break;
			}
			case "5": {
				findAllStu();
				break;
			}
			case "6": {
				System.out.println("退出系统成功!");
				System.exit(0);// JVM虚拟机退出系统
				break;
			}
			default:
				System.out.println("输入的选择不存在!,请重新输入");
				break;
			}
		}
	}

	public static void addStu() {
		Scanner scanner = new Scanner(System.in);
		String id;
		//采用while语句，解决添加的学号重复问题
		while (true) {
			System.out.println("请输入要添加的学生学号:");
			id = scanner.nextLine();
			boolean flag = tianbu(id);
			if (flag) {
				System.out.println("输入的学号已存在!请重新输入");
			} else {
				break;
			}
		}
		// 创建学生对象，把键盘录入的学生的数据赋值给学生对象
		Student s = new Student();
		System.out.println("请输入要添加的学生姓名:");
		String name = scanner.nextLine();
		System.out.println("请输入要添加的学生班级:");
		String classStu = scanner.nextLine();
		System.out.println("请输入要添加的学生年龄:");
		short age = scanner.nextShort();
			if(age<=120&&age>=0) {
			s.setStuAge(age);  
			s.setStuId(id);
			s.setStuName(name);
			s.setStuClass(classStu);
			a.add(s);
			System.out.println("添加学生成功！");
			}else {
				System.out.println("添加失败，输入的年龄不合法！");
			}
		 
			// 将整个学生对象添加到集合中，注：集合存储学生对象，存储的是对象的内存地址
            
	}

	public static void deleteStu() {
		// 键盘录入要删除的学生学号
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要删除的学生学号:");
		String string1 = scanner.nextLine();
	    //定义布尔类型变量，提供条件判断
		boolean flag = true;
		/*	 遍历集合，此处可采用for循环的方法
		 for (int i = 0; i < a.size(); i++) {
			Student student = a.get(i);
			if (student.getStuId().equals(string1)) {
				a.remove(i);
				flag = false;
				System.out.println("删除成功！");
			}
		}
		if(flag) {
			System.out.println("该学号不存在!");
		} 
		 */
		//采用迭代器遍历集合,并添加相应判断
		Iterator<Student> iterator = a.iterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			if (student.getStuId().equals(string1)) {
				iterator.remove();
				System.out.println("删除成功！");
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println("删除失败！,输入的学号有误！");
		}
	}

	public static void updateStu() {
		// 键盘录入要修改的学生学号
		Scanner scanner = new Scanner(System.in);
		String id;
		//while语句解决,用户修改的学号重复问题
		while (true) {
			System.out.println("请输入要修改的学生学号:");
			id = scanner.nextLine();
			boolean flag = xiubu(id);
			if (flag) {
				System.out.println("要修改的学号不存在!请重新输入");
			} else {
				break;
			}
		}
		System.out.println("请输入要修改的学生姓名:");
		String name = scanner.nextLine();
		System.out.println("请输入要修改的学生班级:");
		String classStu = scanner.nextLine();
		System.out.println("请输入要修改的学生年龄:");
		short age = scanner.nextShort();

		// 创建学生对象，存储键盘录入的数据
		Student student = new Student();
		student.setStuId(id);
		student.setStuAge(age);
		student.setStuName(name);
		student.setStuClass(classStu);

		// 遍历集合，通过if条件控制语句修改对于学生信息
		for (int i = 0; i < a.size(); i++) {
			Student student1 = a.get(i);
			if (student1.getStuId().equals(id)) {
				a.set(i, student1);
				System.out.println("修改学生成功");
				break;
			}
		}
	}

	public static void findAllStu() {
		if (a.size() == 0) {
			System.out.println("该系统未录入学生信息，请添加学生信息!");
		} else {
			// 显示表头信息
			System.out.println("学号\t姓名\t年龄\t班级");
			// 遍历集合，将集合中的数据的数据取出，按照对应的格式显示
			for (int i = 0; i < a.size(); i++) {
				Student s = a.get(i);
				System.out.println(s.getStuId() + "\t" + s.getStuName() + "\t" + s.getStuAge() + "\t" +s.getStuClass());
			}
		}
	}

	public static void findStu() {
		//采用条件判断语句，若集合无数据，提供相应提示
		if (a.size() == 0) {
			System.out.println("该系统未录入学生信息，请添加学生信息!");
		} else {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入要查找学生的学号：");
			String str = scanner.nextLine();
			for (int i = 0; i < a.size(); i++) {
				Student s = a.get(i);
				if (str.equals(s.getStuId())) {
					// 显示表头信息
					System.out.println("学号\t姓名\t年龄\t班级");
					System.out.println(s.getStuId() + "\t" + s.getStuName() + "\t" + s.getStuAge() + "\t" +s.getStuClass());
				}
			}
		}
	}

	public static boolean xiubu(String id) {
		boolean flag = true;
		for (int i = 0; i < a.size(); i++) {
			Student student = a.get(i);
			if (student.getStuId().equals(id)) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public static boolean tianbu(String id) {

		boolean flag = false;
		for (int i = 0; i < a.size(); i++) {
			Student student = a.get(i);
			if (student.getStuId().equals(id)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
}
