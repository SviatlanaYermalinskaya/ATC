public class Calculator
{
    public static void main(String[] args)
    {
        double a;
        double b;

        a=Double.parseDouble(args[0]);
        b=Double.parseDouble(args[1]);

        double Sum;
        double Dif;
        double Mult;
        double Dev;

        Sum=a+b;
        Dif=a-b;
        Mult=a*b;
        
        System.out.print(Sum+" "+Dif+" "+Mult+" ");

        if (b!=0.0)
        {      
            Dev=a/b;
            System.out.println(Dev);
        }
        else
        {
            System.out.println("Операция деления невозможна!");
        }
    }

   
}