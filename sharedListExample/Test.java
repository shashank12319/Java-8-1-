package sharedListExample;

public  class Test {
	
	@SuppressWarnings("finally")
	public static int employee(){
		try {
			return 1;
		}
		catch(Exception e){
			return 2;
		}
		finally {
			return 3;
		}
	}
public static void main(String[] args) {
	System.out.println(employee());
}
}

