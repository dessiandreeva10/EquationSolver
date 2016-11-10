import java.util.Scanner;

public class SolveEquation {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		LinearEquation l = new LinearEquation();
		QuadraticEquation q = new QuadraticEquation();
		double[] coeff = new double[3];
		String string = new String();
		boolean run = true;	
	
		while(run){
			System.out.println("Enter what type of equation do you want to solve - linear or quadratic?");
			string = sc.next();
			
			if(string.equals("linear")){
				l.equationSolver(sc,coeff);
			}else if(string.equals("quadratic")){
				q.equationSolver(sc,coeff);
			}
			
		}
		sc.close();
	
	}
	

}
