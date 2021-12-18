package question7.subclass;
import question7.superclass.CommunityMember;
import java.util.Vector;
public class Faculty extends CommunityMember{
    private String academicDept;
	private Vector<String> courses;
	
	//default constructor
	public Faculty(){
	   super("Noname",21,1000);
	   this.academicDept="academic";
	   this.courses=new Vector<String>();//empty list of courses
	   this.ID="F" + this.ID;
    }
	public Faculty(String dept, Vector<String> classes){
		super("Noname",21,1000);
		this.academicDept=dept;
		this.courses=classes;
		this.ID="F" + this.ID;
	}
	public Faculty(String name, int age, float salary, String dept, Vector<String> classes){
		super(name,age,salary);//super has the first line in the constructor
		this.academicDept=dept;
		this.courses=classes;
		this.ID="F" + this.ID;
	}
	//accessor methods
	public String getAcademicDept(){
		return this.academicDept;
	}
	
	public Vector getCourses(){
		return this.courses;
	}
	
	//mutator methods
	
	public void setAcademicDept(String dept){
		this.academicDept=dept;
	}
	public void setCourses(Vector courses){
		this.courses=courses;
	}
	
	//other methods 
	public String listCourses(){
		String retString="";
		Vector courses = this.getCourses();
		if(courses==null){
			retString="No courses taught\n";
			
		}else if(courses.size()==0){
			retString="No courses taught\n";
		}else{			
			for(int i=0;i<courses.size();++i){
				retString = retString + courses.get(i) + "\n";
			}
		}
		
		return retString;
	}
	public String toString(){
		String retString="";
		retString=retString + super.toString()+"\n";
		retString=retString + this.getAcademicDept() + "\n";
		retString=retString + this.listCourses() + "\n";
		
		return retString;
	}
}