package com.trace;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        method();
        System.out.println( "Hello World!" );
    }

    private static int method(){
        int i = 0;
        int j = 1;
        method1();
        return i+j;
    }

    private static int method1(){
        int i = 0;
        return 1;
    }
}
