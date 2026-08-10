import java.io.*;

class Singleton {

    private static Singleton singleInstance;

    public String str;

    private Singleton() {
    }

    public static Singleton getSingleInstance() {
        if (singleInstance == null) {
            singleInstance = new Singleton();
        }

        return singleInstance;
    }
}

public class Solution {
    public static void main(String[] args) {

        String s = "hello world";

        Singleton instance = Singleton.getSingleInstance();

        instance.str = s;

        System.out.println(
            "Hello I am a singleton! Let me say " +
            instance.str + " to you"
        );
    }
}
