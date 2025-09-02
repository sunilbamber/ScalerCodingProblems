package module4.dsa1.recursion.day20_Recursion;

public class Solve {
    static int bar(int x, int y){
        System.out.println("calling ("+x +"+ bar("+x+", "+y+"))");
        if (y == 0){
            System.out.println("return 0");
            return 0;
        };
        return (x + bar(x, y-1));
    }

    static int foo(int x, int y){
        System.out.println("calling bar("+x+", foo("+x+", "+y+"))");
        if (y == 0) return 1;

        return bar(x, foo(x, y-1));
    }
    public static void main (String[] args)
    {
        System.out.println(foo(3,5));
    }

    /**
    foo(3,5) -> bar(3,foo(3,4)) -> bar(3,foo(3,3)) -> bar(3,(foo,3,2))
        -> bar(3,foo(3,1)) -> bar(3,foo(3,0)) -> bar(3,1) -> 3+bar(3,0)
        -> 3+0=3
     */
}
