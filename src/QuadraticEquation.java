import java.util.InputMismatchException;
import java.util.Scanner;

public class QuadraticEquation extends Equation {
	private double[] coef;
	private double[] roots;
	private double discriminant = 0;
	private String returned;
	
	public QuadraticEquation(){
		this.coef = new double[3];
		this.roots = new double[2];
		this.discriminant = 0;
		this.returned = null;
	}
	
	public void setRetString(String ret){
		this.returned = ret;
	}
	
	public String getRetString(){
		return this.returned;
	}

	public void setCoef(double[] coef){
		this.coef = coef;
	}
	
	public void setRoots(double[] roots){
		
		if(roots.length == 2){
			this.roots[0] = roots[0];
			this.roots[1] = roots[1];
		}else{
			this.roots[0] = roots[0];
		}
	}
	
	public void setDiscriminant(double d){
		this.discriminant = d;
	}
	
	public double getDiscriminant(){
		return this.discriminant;
	}
	
	public double[] getCoef(){
		return this.coef;
	}
	
	public double[] getRoots(){
		return this.roots ;
	}
	

	public double[] solve(double[] c, double discriminant){ 
		double[] roots = new double[2];
		
		if(discriminant == 0){
			roots[0] = (-c[1]/ (2*c[0]));
			return roots;
		}else if(discriminant > 0){
			roots[0] = ((-c[1] + Math.sqrt(discriminant)) / (2*c[0]));
			roots[0] = roundRoots(roots[0]);
			roots[1] = ((-c[1] - Math.sqrt(discriminant)) / (2*c[0]));
			roots[1] = roundRoots(roots[1]);
			return roots;
			
		}
		
		return roots;
	}
	
	public void equationSolver(Scanner n, double[] coeff){
		QuadraticEquation q = new QuadraticEquation();
		double discriminant = 0;

		System.out.println("Quadratic equation");
		try{
			coeff = getUserCoefficients(n);
		} catch(IllegalCoefficientException e){
			System.out.println(e.getMessage());
		}
		
		
		if(coeff[0] != 0){
			discriminant = findDiscriminant(coeff);
		
			if(discriminant < 0){
				q.setRoots(findComplexRoots(coeff, discriminant,q));
			}else {
				q.setRoots(solve(coeff,discriminant));
			}
			printSolution(coeff, q.getRoots(), q.getRetString());
		} 
		
	}
	
 	public static double roundRoots(double r){
		r = Math.round(r*100);
		r = r / 100;	
		return r;
	}
		
	public double[] findComplexRoots(double[] c, double discriminant, QuadraticEquation q){
		q.setRetString("The equation have complex roots!");
		double realPart = 0;
		double complexPart = 0;
		double[] result = new double[2];
		
		realPart = (-c[1]/ (2*c[0]));
		realPart = roundRoots(realPart);
		complexPart = (Math.sqrt(Math.abs(discriminant)) / (2*c[0]));
		complexPart = roundRoots(complexPart);
		
		result[0] = realPart;
		result[1] = complexPart;
		
		return result;
	}
	
	public static double findDiscriminant(double[] coef){
		double discriminant;
		
		discriminant = ((coef[1]*coef[1]) - (4*coef[0]*coef[2]));
		return discriminant;
	}
	
	public static double[] getUserCoefficients(Scanner n) throws IllegalCoefficientException {
			
			double[] coefficients = new double[3];
			
			try{
				
				System.out.println("Enter first coefficient:");
				coefficients[0] = n.nextDouble();
				if(coefficients[0] == 0){
		
					throw new IllegalCoefficientException();
				}
				System.out.println("Enter second coefficient:");
				coefficients[1] = n.nextDouble();
				
				System.out.println("Enter third coefficient:");
				coefficients[2] = n.nextDouble();
			} catch(InputMismatchException e){
				System.out.println("You entered wrong value! Coefficients should be numbers not characters!");
			}
			return coefficients;
	}

	@Override
	public void printSolution(double[] coeff, double[] results, String ret) {
		// TODO Auto-generated method stub
		if(ret != null){
			System.out.println(ret);
			System.out.println("x1 = " + results[0] +  " + i*" +results[1]);
			System.out.println("x2 = " + results[0] +  " - i*" +results[1]);
		} else if(results.length == 2){
			System.out.println("x1 = " + results[0]);
			System.out.println("x2 = " + results[1]);
		} else if(results.length == 1){
			System.out.println("x1 = x2 =" + results[0]);
		}
		
	}

	

}
