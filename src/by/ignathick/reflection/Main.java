package by.ignathick.reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str();
    int val();
}
public class Main {
    @MyAnno(str = "Example of annotation", val = 100)

    public static void myMeth () {

        Main ob = new Main();

        //get anotation from method
        //and print they members

        try{

            Class<?> c = ob.getClass();
            Method m = c.getMethod("myMeth");
            MyAnno anno = m.getAnnotation(MyAnno.class);
            System.out.println(anno.str() + " " + anno.val());

        } catch (NoSuchMethodException exc) {
            System.out.println("Cant find method");
        }

    }

    public static void main(String[] args) {
        myMeth();
    }
}
