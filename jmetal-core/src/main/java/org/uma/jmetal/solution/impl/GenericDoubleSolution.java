package org.uma.jmetal.solution.impl;

import org.uma.jmetal.problem.DoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;
import org.uma.jmetal.solution.Solution;

import java.util.HashMap;

/**
 * Created by Antonio J. Nebro on 03/09/14.
 */
public class GenericDoubleSolution extends AbstractGenericSolution<Double, DoubleProblem> implements DoubleSolution {
  /** Constructor */
  public GenericDoubleSolution(DoubleProblem problem) {
    super(problem) ;
    overallConstraintViolationDegree = 0.0 ;
    numberOfViolatedConstraints = 0 ;

    for (int i = 0 ; i < problem.getNumberOfVariables(); i++) {
      Double value = randomGenerator.nextDouble() * (getUpperBound(i) - getLowerBound(i)) + getLowerBound(i);
      setVariableValue(i, value) ;
    }

    for (int i = 0; i < problem.getNumberOfObjectives(); i++) {
      setObjective(i, 0.0) ;
    }
  }

  /** Copy constructor */
  public GenericDoubleSolution(GenericDoubleSolution solution) {
    super(solution.problem) ;

    for (int i = 0; i < problem.getNumberOfVariables(); i++) {
      setVariableValue(i, solution.getVariableValue(i));
    }

    for (int i = 0; i < problem.getNumberOfObjectives(); i++) {
      setObjective(i, solution.getObjective(i)) ;
    }

    overallConstraintViolationDegree = solution.overallConstraintViolationDegree ;
    numberOfViolatedConstraints = solution.numberOfViolatedConstraints ;
    attributes = new HashMap(solution.attributes) ;
  }

  @Override
  public Double getUpperBound(int index) {
    return problem.getUpperBound(index);
  }

  @Override
  public Double getLowerBound(int index) {
    return problem.getLowerBound(index) ;
  }

  @Override
  public Solution copy() {
    return new GenericDoubleSolution(this);
  }

  @Override
  public String getVariableValueString(int index) {
    return getVariableValue(index).toString() ;
  }
}
