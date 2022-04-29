package StudentSystem;

public class Student {
	 		 private String stuId;
			 private String stuName;
			 private short stuAge;
		     private  String stuClass;
		  public Student() {
			
		}
		public Student(String stuId, String stuName, short stuAge, String stuClass) {
			
			this.stuId = stuId;
			this.stuName = stuName;
			this.stuAge = stuAge;
			this.stuClass = stuClass;
		}
		public String getStuId() {
			return stuId;
		}
		public void setStuId(String stuId) {
			this.stuId = stuId;
		}
		public String getStuName() {
			return stuName;
		}
		public void setStuName(String stuName) {
			this.stuName = stuName;
		}
		public short getStuAge() {
			return stuAge;
		}
		public void setStuAge(short stuAge) {
			this.stuAge = stuAge;
		}
		public String getStuClass() {
			return stuClass;
		}
		public void setStuClass(String stuClass) {
			this.stuClass = stuClass;
		}
	
}
