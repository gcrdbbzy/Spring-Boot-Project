package com.bobAPI;

import java.math.BigInteger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntegerAdd {

	@RequestMapping(value = "/addTwoNumbers")
	public Integer addTwoNumbers(Integer digit1, Integer digit2) {
		
		BigInteger Num1 = BigInteger.valueOf(digit1);
		BigInteger Num2 = BigInteger.valueOf(digit2);
		BigInteger sum = Num1.add(Num2); 
		return sum.intValue();
		}
	
	
	
	
}
