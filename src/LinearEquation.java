import java.util.InputMismatchException;
import java.util.Scanner;

public class LinearEquation extends Equation {
	private double[] coefficients;
	private String returned;
	private double[] results;
	
	public LinearEquation(){
		this.returned = " ";
		this.coefficients = new double[3];
		this.results = new double[2];
	}
	
	public String getRetString(){
		return this.returned;
	}
		
	public double[] getCoefficients(){
		return this.coefficients;
	}
	
	public void setRetString(String ret){
	  this.returned = ret;
	}
	
	public void setCoefficients(double[] c){
		this.coefficients = c;
	}
	
	public void setResults(double[] roots){
		if(roots.length == 2){
			this.results[0] = roots[0];
			this.results[1] = roots[1];
		}else{
			this.results[0] = roots[0];
		}
	}
	
	public double[] getResults(){
		return this.results;
	}
	
	
	public double[] getUserCoefficients(Scanner n){
		double[] coefficients = new double[3];
		
		try{
			
			System.out.println("Enter the first coefficient:");
			coefficients[0] = n.nextDouble();
			System.out.println("Enter the second coefficient:");
			coefficients[1] = n.nextDouble();
			System.out.println("Enter the coefficient after equal sign:");
			coefficients[2] = n.nextDouble();
		}catch(InputMismatchException e){
			System.out.println("You cannot enter charachters as coefficients!");
			return null;
		}
		return coefficients;
	}
	

	public double[] solve(double[] coefficients, double d){
		LinearEquation e = new LinearEquation();
		
		if(coefficients[2] == 0){
			
			solveIfThirdCoefIsNull(coefficients, e);
			
		} else if(coefficients[2] > 0 || coefficients[2] < 0){
			
			solveIfThirdCoefIsAnotherNumber(coefficients, e);
			
		}
		
		printSolution(coefficients, e.getResults(), e.getRetString());
				
		return e.getResults();
}	
	
	
	public static double[] solveIfThirdCoefIsNull(double[] coefficients, LinearEquation e){
			double[] result = new double[2];
			
				if(coefficients[0] == 0 && coefficients[1] > 0){
					
					e.setRetString("The equation doesn't have real roots.");
					result[0] = 0;
					result[1] = 0;
					return result;
				
				} else if(coefficients[0] > 0 && coefficients[1] > 0){
						
						result[0] = coefficients[1]/coefficients[0];
						e.setResults(result);
						return result;
						
					} else if(coefficients[0] < 0 && coefficients[1] < 0) {
						
						result[0] = Math.abs(coefficients[1])/Math.abs(coefficients[0]);
						e.setResults(result);
						return result;
					
					}else if (coefficients[1] < 0 && coefficients[0] > 0){
						
						result[0] = coefficients[1]/Math.abs(coefficients[0]);
						e.setResults(result);
						return result;	
						
				}else if(coefficients[0] == 0 && coefficients[1] == 0){
					
					e.setRetString("Every x is solution.");
					result[0] = 0;
					result[1] = 0;
					return result;
				
				}
				
				return result;		
		}
		
		
	public static double[] solveIfThirdCoefIsAnotherNumber(double[] coefficients, LinearEquation e){
			double[] results = new double[2];
			
			if(coefficients[2] < 0){
				
				e.setRetString("The equation doesn't have real roots.");
				results[0] = 0;
				results[1] = 0;
				return results;
				
			} else if(coefficients[2] > 0){
				
				results[0] = (coefficients[2] - coefficients[1]) / coefficients[0];
				results[1] = - ((coefficients[2] + coefficients[1]) / coefficients[0]) ;
				e.setResults(results);
			}
			
			return results;
	}
						
	public void equationSolver(Scanner n, double[] coeff){
		coeff = getUserCoefficients(n);		
		if(coeff != null){
			solve(coeff,0);
		}
	}

	
	@Override
	public void printSolution(double[] coeff, double[] results, String ret) {
		// TODO Auto-generated method stub
		
		if(coeff[2] == 0){
			
			System.out.println(Math.round(coeff[0]) + "x" + " " + "+" + " " + Math.round(coeff[1])  + " = " +  Math.round(coeff[2]));
			System.out.println(Math.round(coeff[0]) + "x" + " = " + Math.round(coeff[1]));
			System.out.println("x" + " = " + Math.round(coeff[1]) +  " / " +  Math.round(coeff[0]));
			System.out.println("x" + " " + " = " + " " +  results[0]);
			
		} else if(coeff[2] > 0 || coeff[2] < 0){
		
			System.out.println(Math.round(coeff[0]) + "x" + " " + "+" + " " + Math.round(coeff[1])  + " = " +  Math.round(coeff[2]));
			
			System.out.println("x1" +  " = " + results[0]);
			System.out.println("x2" +  " = " + results[1]);
		
		}else if(ret != null){
			System.out.println(ret);
		}
		
	}

		
}
