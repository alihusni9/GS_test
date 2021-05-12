package service;

import java.util.List;

import atribut.Parameter;
import atribut.ResponseData;

public interface ParameterInterface {
	boolean ValidateData(Parameter parameter);
	ResponseData CalculateAverage(List<Parameter> parameters);
}
