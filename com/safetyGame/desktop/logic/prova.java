package com.safetyGame.desktop.logic;


/**
 * Write a description of class prova here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class prova
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class prova
     */
    public prova()
    {
       x=0;
       String s="";
       for (;x<10000;x++){
        char c=(char) x;
        System.out.println(c);
        s+=c;
        } System.out.println(s);
       
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
