package StudentSystem;
/*
 * @31��
 ���˴�һ���1��ѧ��
 ���ļ򵥼��ϵ�ѧ������ϵͳ��ϰ
 */
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import javax.print.DocFlavor.STRING;
import javax.swing.event.SwingPropertyChangeSupport;
public class StudentDemo {
	// ����ArrayList����
	static ArrayList<Student> a = new ArrayList<Student>();
	public static void main(String[] args) {
		// ��whileѭ���ص�������
		while (true) {
			System.out.println("��ӭ����ѧ������ϵͳ��");
			System.out.println("1-���ѧ��\t2-ɾ��ѧ��\t3-�޸�ѧ��\t4-�鿴����ѧ��\t5-�鿴����ѧ��\t6-�˳�ϵͳ");
			Scanner scanner = new Scanner(System.in);
			System.out.println("���������ѡ��");
			String s = scanner.nextLine();
			// ʹ��switch�ṩѡ��
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
				System.out.println("�˳�ϵͳ�ɹ�!");
				System.exit(0);// JVM������˳�ϵͳ
				break;
			}
			default:
				System.out.println("�����ѡ�񲻴���!,����������");
				break;
			}
		}
	}

	public static void addStu() {
		Scanner scanner = new Scanner(System.in);
		String id;
		//����while��䣬�����ӵ�ѧ���ظ�����
		while (true) {
			System.out.println("������Ҫ��ӵ�ѧ��ѧ��:");
			id = scanner.nextLine();
			boolean flag = tianbu(id);
			if (flag) {
				System.out.println("�����ѧ���Ѵ���!����������");
			} else {
				break;
			}
		}
		// ����ѧ�����󣬰Ѽ���¼���ѧ�������ݸ�ֵ��ѧ������
		Student s = new Student();
		System.out.println("������Ҫ��ӵ�ѧ������:");
		String name = scanner.nextLine();
		System.out.println("������Ҫ��ӵ�ѧ���༶:");
		String classStu = scanner.nextLine();
		System.out.println("������Ҫ��ӵ�ѧ������:");
		short age = scanner.nextShort();
			if(age<=120&&age>=0) {
			s.setStuAge(age);  
			s.setStuId(id);
			s.setStuName(name);
			s.setStuClass(classStu);
			a.add(s);
			System.out.println("���ѧ���ɹ���");
			}else {
				System.out.println("���ʧ�ܣ���������䲻�Ϸ���");
			}
		 
			// ������ѧ��������ӵ������У�ע�����ϴ洢ѧ�����󣬴洢���Ƕ�����ڴ��ַ
            
	}

	public static void deleteStu() {
		// ����¼��Ҫɾ����ѧ��ѧ��
		Scanner scanner = new Scanner(System.in);
		System.out.println("������Ҫɾ����ѧ��ѧ��:");
		String string1 = scanner.nextLine();
	    //���岼�����ͱ������ṩ�����ж�
		boolean flag = true;
		/*	 �������ϣ��˴��ɲ���forѭ���ķ���
		 for (int i = 0; i < a.size(); i++) {
			Student student = a.get(i);
			if (student.getStuId().equals(string1)) {
				a.remove(i);
				flag = false;
				System.out.println("ɾ���ɹ���");
			}
		}
		if(flag) {
			System.out.println("��ѧ�Ų�����!");
		} 
		 */
		//���õ�������������,�������Ӧ�ж�
		Iterator<Student> iterator = a.iterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			if (student.getStuId().equals(string1)) {
				iterator.remove();
				System.out.println("ɾ���ɹ���");
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println("ɾ��ʧ�ܣ�,�����ѧ������");
		}
	}

	public static void updateStu() {
		// ����¼��Ҫ�޸ĵ�ѧ��ѧ��
		Scanner scanner = new Scanner(System.in);
		String id;
		//while�����,�û��޸ĵ�ѧ���ظ�����
		while (true) {
			System.out.println("������Ҫ�޸ĵ�ѧ��ѧ��:");
			id = scanner.nextLine();
			boolean flag = xiubu(id);
			if (flag) {
				System.out.println("Ҫ�޸ĵ�ѧ�Ų�����!����������");
			} else {
				break;
			}
		}
		System.out.println("������Ҫ�޸ĵ�ѧ������:");
		String name = scanner.nextLine();
		System.out.println("������Ҫ�޸ĵ�ѧ���༶:");
		String classStu = scanner.nextLine();
		System.out.println("������Ҫ�޸ĵ�ѧ������:");
		short age = scanner.nextShort();

		// ����ѧ�����󣬴洢����¼�������
		Student student = new Student();
		student.setStuId(id);
		student.setStuAge(age);
		student.setStuName(name);
		student.setStuClass(classStu);

		// �������ϣ�ͨ��if������������޸Ķ���ѧ����Ϣ
		for (int i = 0; i < a.size(); i++) {
			Student student1 = a.get(i);
			if (student1.getStuId().equals(id)) {
				a.set(i, student1);
				System.out.println("�޸�ѧ���ɹ�");
				break;
			}
		}
	}

	public static void findAllStu() {
		if (a.size() == 0) {
			System.out.println("��ϵͳδ¼��ѧ����Ϣ�������ѧ����Ϣ!");
		} else {
			// ��ʾ��ͷ��Ϣ
			System.out.println("ѧ��\t����\t����\t�༶");
			// �������ϣ��������е����ݵ�����ȡ�������ն�Ӧ�ĸ�ʽ��ʾ
			for (int i = 0; i < a.size(); i++) {
				Student s = a.get(i);
				System.out.println(s.getStuId() + "\t" + s.getStuName() + "\t" + s.getStuAge() + "\t" +s.getStuClass());
			}
		}
	}

	public static void findStu() {
		//���������ж���䣬�����������ݣ��ṩ��Ӧ��ʾ
		if (a.size() == 0) {
			System.out.println("��ϵͳδ¼��ѧ����Ϣ�������ѧ����Ϣ!");
		} else {
			Scanner scanner = new Scanner(System.in);
			System.out.println("������Ҫ����ѧ����ѧ�ţ�");
			String str = scanner.nextLine();
			for (int i = 0; i < a.size(); i++) {
				Student s = a.get(i);
				if (str.equals(s.getStuId())) {
					// ��ʾ��ͷ��Ϣ
					System.out.println("ѧ��\t����\t����\t�༶");
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
