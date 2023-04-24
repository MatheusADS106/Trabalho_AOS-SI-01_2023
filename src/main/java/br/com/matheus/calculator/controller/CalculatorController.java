package br.com.matheus.calculator.controller;

import br.com.matheus.calculator.exceptions.InvalidNumberOperationException;
import br.com.matheus.calculator.exceptions.BlankOrEmptyValueException;
import br.com.matheus.calculator.model.Calculator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @RequestMapping(value = {"/sum/{n1}/{n2}", "/sum/{n1}/", "/sum/{n1}" , "/sum/", "/sum"}, method = RequestMethod.GET)
    public float sum(@PathVariable(value = "n1", required = false) String n1, @PathVariable(value = "n2", required = false) String n2) {
        if(isBlankOrIsEmpty(n1) || isBlankOrIsEmpty(n2)) {
            throw new BlankOrEmptyValueException("Um ou ambos os parâmetros está em branco!");
        }
        if(!isNumeric(n1) || !isNumeric(n2)) {
            throw new InvalidNumberOperationException("Por favor, informe valores numéricos válidos!");
        }
        return Calculator.sum(Float.parseFloat(n1), Float.parseFloat(n2));
    }

    @RequestMapping(value = {"/minus/{n1}/{n2}", "/minus/{n1}/", "/minus/{n1}", "/minus/", "/minus"}, method = RequestMethod.GET)
    public float minus(@PathVariable(value = "n1", required = false) String n1, @PathVariable(value = "n2", required = false) String n2) {
        if(isBlankOrIsEmpty(n1) || isBlankOrIsEmpty(n2)) {
            throw new BlankOrEmptyValueException("Um ou ambos os parâmetros está em branco!");
        }
        if(!isNumeric(n1) || !isNumeric(n2)) {
            throw new InvalidNumberOperationException("Por favor, informe valores numéricos válidos!");
        }
        return Calculator.minus(Float.parseFloat(n1), Float.parseFloat(n2));
    }

    @RequestMapping(value = {"/times/{n1}/{n2}", "/times/{n1}/", "/times/{n1}" , "/times/", "/times"}, method = RequestMethod.GET)
    public float times(@PathVariable(value = "n1", required = false) String n1, @PathVariable(value = "n2", required = false) String n2) {
        if(isBlankOrIsEmpty(n1) || isBlankOrIsEmpty(n2)) {
            throw new BlankOrEmptyValueException("Um ou ambos os parâmetros está em branco!");
        }
        if(!isNumeric(n1) || !isNumeric(n2)) {
            throw new InvalidNumberOperationException("Por favor, informe valores numéricos válidos!");
        }
        return Calculator.times(Float.parseFloat(n1), Float.parseFloat(n2));
    }

    @RequestMapping(value = {"/divide/{n1}/{n2}", "/divide/{n1}/", "/divide/{n1}", "/divide/", "/divide"}, method = RequestMethod.GET)
    public float divide(@PathVariable(value = "n1", required = false) String n1, @PathVariable(value = "n2", required = false) String n2) {
        if(isBlankOrIsEmpty(n1) || isBlankOrIsEmpty(n2)) {
            throw new BlankOrEmptyValueException("Um ou ambos os parâmetros está em branco!");
        }
        if(!isNumeric(n1) || !isNumeric(n2)) {
            throw new InvalidNumberOperationException("Por favor, informe valores numéricos válidos!");
        }
        return Calculator.divide(Float.parseFloat(n1), Float.parseFloat(n2));
    }

    public boolean isNumeric(String value) {
        try {
            Float.parseFloat(value);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean isBlankOrIsEmpty(String value) {
        return value == null;
    }
}