
public class Staticvariable {

	int id;
	String name;
	static String clgname;
	 int a;
	
	Staticvariable(int id1,String name1){
		
		id=id1;
		name=name1;
		}
	
	public void display() {
		System.out.println(id+""+name+""+clgname);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Staticvariable s1=new Staticvariable(1,"Pooja");
		Staticvariable s2=new Staticvariable(2,"ankia");
		s1.display();
		s2.display();
		
		System.out.println(s1.a);
	}

}
