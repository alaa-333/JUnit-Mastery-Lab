package org.example.fundamental.task1;


//Write a test for add() method with positive numbers
//
//Write a test for add() with negative numbers
//
//Write tests for isEven() with even and odd numbers
//
//Add a test for add() with zero values

public class CalculatorService {


    // method one
    public int add(int num1 , int num2)
    {
        return num1 + num2;
    }


    // method two
    public boolean isEven(int num)
    {
        return num % 2 == 0;
    }


}
