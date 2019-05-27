package group144.afrikanov;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

import static org.junit.jupiter.api.Assertions.*;

class ClassStructureGetterTest {

    @Test
    void equalClassesTest() {
        ClassStructureGetter classPrinter = new ClassStructureGetter();
        assertEquals(0, classPrinter.diffClasses(MyClass1.class, MyClass1.class).length());
    }

    @Test
    void classPrinterTest() throws IOException, ClassNotFoundException {
        ClassStructureGetter classPrinter = new ClassStructureGetter();
        classPrinter.printStructureInFile(MyClass2.class);
        ClassLoader buildClassLoader = new URLClassLoader(new URL[]{new URL("file://")});
        Class<?> buildClass = buildClassLoader.loadClass("group144.afrikanov.build.MyClass2");
        assertEquals(0, classPrinter.diffClasses(MyClass2.class, buildClass).length());
    }

    @Test
    void differencesTest() throws IOException, ClassNotFoundException {
        ClassStructureGetter classPrinter = new ClassStructureGetter();
        ClassLoader buildClassLoader = new URLClassLoader(new URL[]{new URL("file://")});
        Class<?> buildFirstClass = buildClassLoader.loadClass("group144.afrikanov.build.MyClass1");
        Class<?> buildSecondClass = buildClassLoader.loadClass("group144.afrikanov.MyClass2");
        String expected = " Different methods : \n" +
                "First Class - MyClass1\n" +
                "Second Class - MyClass2\n" +
                "* public void print() { \n" +
                "\treturn;\n" +
                "} \n" +
                "\n\n" +
                "In Classes : MyClass1 , MyClass2 different classes are : \n" +
                " Different fields : \n" +
                "First class - Node\n" +
                "Second class - Node\n" +
                "* private int b\n\n" +
                " Different methods : \n" +
                "First Class - Node\n" +
                "Second Class - Node\n" +
                "* public int getB() { \n" +
                "\treturn 0;\n" +
                "} \n\n\n";
        assertEquals(expected, classPrinter.diffClasses(buildFirstClass, buildSecondClass));
    }
}