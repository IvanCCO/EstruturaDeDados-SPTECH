package org.example;

public class Main {
    public static void main(String[] args)
    {

        Vendedor vendedor = new Vendedor("3837383", "Ivan", 1000.00, 10.00);
        Horista horista = new Horista("32323232", "fe", 5, 40.00);
        Engenheiro eng = new Engenheiro("31313131", "Pedro", 1200.99);

        System.out.println(vendedor.calcSalario());
        System.out.println(horista.calcSalario());
        System.out.println(eng.calcSalario());

    }
}