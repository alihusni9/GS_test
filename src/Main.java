import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import atribut.Parameter;
import atribut.ResponseData;
import service.ParameterInterface;
import service.impl.ParameterImpl;

public class Main {

	public static void main(String[] args) {
		ResponseData result = new ResponseData();
		Scanner scanner = new Scanner(System.in);
		ParameterInterface parameterInterface = new ParameterImpl();
		List<Parameter> parameters= new ArrayList<Parameter>();
		System.out.println("==========STARTING APPLICATION==========");
		for (int i=1; i<3; i++) {
			Parameter parameter = new Parameter();
			System.out.println("Input Data "+i);
			try {
				System.out.print("Age Of Death : ");
				int ageOfDeath = scanner.nextInt();
				parameter.setAgeOfDeath(ageOfDeath);
				System.out.print("Year Of Death : ");
				int yearOfDeath = scanner.nextInt();
				parameter.setYearOfDeath(yearOfDeath);
				boolean resultValidate = parameterInterface.ValidateData(parameter);
				if (resultValidate) {
					result.setCode(01);
					result.setDescription("parameter is not valid");
					result.setResult(-1F);
					break;
				}
				parameters.add(parameter);
				System.out.println("-------------------------------");
			} catch (InputMismatchException e) {
				System.out.println("Parameter must be only numeric");
				break;
			}
		}
		
		System.out.println("=======================================");
		if (result.getCode() != 00) {
			System.out.println("Description Error : "+result.getDescription());
		} else {
			result = parameterInterface.CalculateAverage(parameters);
		}
		System.out.println("Result of Average : "+result.getResult());
		System.out.println("==========CLOSING APPLICATION==========");
	}
}
