package service.impl;

import java.util.List;

import atribut.Parameter;
import atribut.ResponseData;
import service.ParameterInterface;

public class ParameterImpl implements ParameterInterface {

	@Override
	public boolean ValidateData(Parameter parameter) {
		if (parameter.getAgeOfDeath() <= 0 || parameter.getYearOfDeath() <= 0) {
			return true;
		}
		return false;
	}

	@Override
	public ResponseData CalculateAverage(List<Parameter> parameters) {
		ResponseData responseData = new ResponseData();
		int count = 0;
		for (int i=0; i<parameters.size(); i++) {
			int total = parameters.get(i).getYearOfDeath() - parameters.get(i).getAgeOfDeath();
			int fib[] = new int[total];
			for (int j=0; j<total; j++) {
				if (j==0) {
					fib[j] = 1;
				} else if (j==1) {
					fib[j] = fib[j-1];
				} else {
					fib[j] = fib[j-1] + fib[j-2];
				}
			}
			int totalKill = 0;
			for (int z = 0; z < total; z++) {
				totalKill = totalKill+fib[z];
	        }
			count = count + totalKill;
		}
		float result = (float) count/2;
		responseData.setResult(result);
		responseData.setCode(00);
		responseData.setDescription("Success");
		return responseData;
	}
}
