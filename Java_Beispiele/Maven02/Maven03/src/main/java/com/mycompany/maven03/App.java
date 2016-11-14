package com.mycompany.maven03;

import com.mycompany.maven03.logic.BusinessLogik;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        BusinessLogik logik = new BusinessLogik();

        double d = logik.average(1,3,4,6,8,9);
        System.out.println("avg: " + d);
    }
}
