package group144.afrikanov;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.*;

/** Class describes a structure of a given class and compares 2 classes for equality */
public class ClassStructureGetter {

    /**
     * Prints all information of the class to the file
     *
     * @param clazz - class, whose information will be written
     * @throws IOException throws when file is not found
     */
    public void printStructureInFile(Class clazz) throws IOException {
        String fileName = "src\\test\\java\\group144\\afrikanov\\build\\" + clazz.getSimpleName() + ".java";
        FileWriter fileWriter = new FileWriter(fileName);
        StringBuilder allFields = new StringBuilder("package group144.afrikanov.build; \n \n");
        fileWriter.write(printStructure(allFields, clazz, 1));
        fileWriter.close();
    }

    /**
     * Class gets the information of a class
     *
     * @param allFields - string which will include all information
     * @param clazz - a class with information
     * @param tabsAmount - tabs for beautiful output
     * @return a string with a structure
     */
    public String printStructure(StringBuilder allFields, Class clazz, int tabsAmount) {
        classDeclaration(allFields, clazz, tabsAmount - 1);
        getFields(allFields, clazz, tabsAmount);
        getConstructors(allFields, clazz, tabsAmount);
        getMethods(allFields, clazz, tabsAmount);
        getInnerClasses(allFields, clazz, tabsAmount);
        printTabs(allFields, tabsAmount - 1);
        allFields.append("} \n");
        return allFields.toString();
    }

    /** Method get all methods of a class */
    private void getMethods(StringBuilder allFields, Class clazz, int tabsAmount) {
        if (clazz.getDeclaredMethods().length == 0) {
            return;
        }
        for (var methodItem : clazz.getDeclaredMethods()) {
            showMethod(allFields, methodItem, tabsAmount);
            allFields.append("\n");
        }
    }

    private void printTabs(StringBuilder allFields, int tabsAmount) {
        for (int i = 0; i < tabsAmount; ++i) {
            allFields.append("\t");
        }
    }

    /** Method get current method of a class */
    private void showMethod(StringBuilder allFields, Method methodItem, int tabsAmount) {
        printTabs(allFields, tabsAmount);
        if (methodItem.getModifiers() != 0) {
            allFields.append(Modifier.toString(methodItem.getModifiers())).append(" ");
        }
        allFields.append(methodItem.getReturnType()).append(" ");
        allFields.append(methodItem.getName()).append("(");
        getDeclaredParameters(allFields, methodItem.getParameters());
        allFields.append(") { \n");
        printTabs(allFields, tabsAmount + 1);
        allFields.append("return");
        if (!methodItem.getReturnType().getSimpleName().equals("void")) {
            allFields.append(" ");
        }
        showReturnType(allFields, methodItem.getReturnType());
        allFields.append("\n");
        printTabs(allFields, tabsAmount);
        allFields.append("} \n");
    }

    /** Method get all parameters of a class */
    private void getDeclaredParameters(StringBuilder allFields, Parameter[] parameters) {
        for (var parameterItem : parameters) {
            allFields.append(parameterItem.getType().getSimpleName()).append(" ")
                    .append(parameterItem.getName());
            if (parameters[parameters.length - 1] != parameterItem) {
                allFields.append(", ");
            }
        }
    }

    private void getConstructors(StringBuilder allFields, Class clazz, int tabsAmount) {
        if (clazz.getDeclaredConstructors().length == 0) {
            return;
        }
        for (var constructorItem : clazz.getDeclaredConstructors()) {
            showConstructor(allFields, clazz, constructorItem, tabsAmount);
            allFields.append("\n");
        }
    }

    private void showConstructor(StringBuilder allFields, Class clazz, Constructor constructorItem, int tabsAmount) {
        printTabs(allFields, tabsAmount);
        if (constructorItem.getModifiers() != 0) {
            allFields.append(Modifier.toString(constructorItem.getModifiers())).append(" ");
        }
        allFields.append(clazz.getSimpleName()).append("(");
        getDeclaredParameters(allFields, constructorItem.getParameters());
        allFields.append(") { }").append("\n");
    }

    /** Method fills the declaration of a class */
    private void classDeclaration(StringBuilder allFields, Class clazz, int tabsAmount) {
        printTabs(allFields, tabsAmount);
        getDeclaredModifiers(allFields, clazz);
        allFields.append("class ");
        getDeclaredNameAndTypesOfClass(allFields, clazz);
        getSuperClasses(allFields, clazz);
        getInterfaces(allFields, clazz);
        allFields.append("{ \n \n");
    }

    /** Method get all fields of a class */
    private void getFields(StringBuilder allFields, Class clazz, int tabsAmount) {
        if (clazz.getDeclaredFields().length == 0) {
            return;
        }
        for (var fieldItem : clazz.getDeclaredFields()) {
            printTabs(allFields, tabsAmount);
            if (fieldItem.getModifiers() != 0) {
                allFields.append(Modifier.toString(fieldItem.getModifiers()));
                allFields.append(" ");
            }
            allFields.append(fieldItem.getType().getSimpleName());
            allFields.append(" ");
            allFields.append(fieldItem.getName());
            allFields.append(" = ");
            showReturnType(allFields, fieldItem.getType());
            allFields.append("\n");
        }
        allFields.append("\n");
    }

    private void showReturnType(StringBuilder allFields, Type type) {
        switch (type.getTypeName()) {
            case "Integer":
                allFields.append("Integer.valueOf(0);");
                break;
            case "Long":
                allFields.append("Long.valueOf(0);");
                break;
            case "Boolean":
                allFields.append("true;");
                break;
            case "Double":
                allFields.append("Double.valueOf(0.0);");
                break;
            case "Character":
                allFields.append("Character.valueOf('a');");
                break;
            case "Byte":
                allFields.append("Byte.valueOf(0);");
                break;
            case "String":
                allFields.append("String.valueOf(\"\");");
                break;
            case "Short":
                allFields.append("Short.valueOf(0);");
                break;
            case "Float":
                allFields.append("Float.valueOf(0);");
                break;
            case "int":
                allFields.append("0;");
                break;
            case "boolean":
                allFields.append("true;");
                break;
            case "double":
                allFields.append("0;");
                break;
            case "char":
                allFields.append("'a';");
                break;
            case "byte":
                allFields.append("0;");
                break;
            case "long":
                allFields.append("0;");
                break;
            case "short":
                allFields.append("0;");
                break;
            case "float":
                allFields.append("0;");
                break;
            case "void":
                allFields.append(";");
                break;
            default:
                allFields.append("null;");
                break;
        }
    }

    /** Method get all super classes of a class */
    private void getSuperClasses(StringBuilder allFields, Class clazz) {
        if (clazz.getSuperclass() == null) {
            return;
        }
        allFields.append("extends ");
        getDeclaredNameAndTypesOfClass(allFields, clazz.getSuperclass());
    }

    private void getDeclaredNameAndTypesOfClass(StringBuilder allFields, Class clazz) {
        allFields.append(clazz.getSimpleName()).append(" ");
        getTypeParameters(allFields, clazz);
    }

    private void getDeclaredModifiers(StringBuilder allFields, Class clazz) {
        if (clazz.getModifiers() == 0) {
            return;
        }
        allFields.append(Modifier.toString(clazz.getModifiers()));
        allFields.append(" ");
    }

    private void getTypeParameters(StringBuilder allFields, Class clazz) {
        if (clazz.getTypeParameters().length == 0) {
            return;
        }
        allFields.append("<");
        for (var typeItem : clazz.getTypeParameters()) {
            allFields.append(typeItem);
            if (clazz.getTypeParameters()[clazz.getTypeParameters().length - 1] != typeItem) {
                allFields.append(", ");
            }
        }
        allFields.append("> ");
    }

    private void getInterfaces(StringBuilder allFields, Class clazz) {
        if (clazz.getInterfaces().length == 0) {
            return;
        }
        allFields.append("implements ");
        Class[] interfaceList = clazz.getInterfaces();
        for (var interfaceItem : interfaceList) {
            allFields.append(interfaceItem.getSimpleName());
            getTypeParameters(allFields, interfaceItem);
            if (interfaceList[interfaceList.length - 1] != interfaceItem) {
                allFields.append(", ");
            }
        }
        allFields.append(" ");
    }

    /** Method get all inner classes of a class */
    private void getInnerClasses(StringBuilder allFields, Class clazz, int tabsAmount) {
        if (clazz.getDeclaredClasses().length == 0) {
            return;
        }
        for (var innerClassItem : clazz.getDeclaredClasses()) {
            printStructure(allFields, innerClassItem, tabsAmount + 1);
            allFields.append("\n");
        }
    }

    /** Method finds the differences between two classes and return a string with these differences */
    public String diffClasses(Class firstClass, Class secondClass) {
        StringBuilder differences = new StringBuilder();
        findDifferences(differences, firstClass, secondClass);
        return differences.toString();
    }

    private void findDifferences(StringBuilder differences, Class firstClass, Class secondClass) {
        findDifferentFields(differences, firstClass, secondClass);
        findDifferentMethods(differences, firstClass, secondClass);
        findDifferentInnerClasses(differences, firstClass, secondClass);
    }

    private void findDifferentInnerClasses(StringBuilder differences, Class firstClass, Class secondClass) {
        if (firstClass.getDeclaredClasses().length == 0 && secondClass.getDeclaredClasses().length == 0) {
            return;
        } else if (firstClass.getDeclaredClasses().length != 0 && secondClass.getDeclaredClasses().length != 0) {
            StringBuilder differentInnerClasses = new StringBuilder();
            for (Class firstInnerClassItem : firstClass.getDeclaredClasses()) {
                for (Class secondInnerClassItem : secondClass.getDeclaredClasses()) {
                    findDifferences(differentInnerClasses, firstInnerClassItem, secondInnerClassItem);
                }
            }
            if (differentInnerClasses.length() == 0) {
                return;
            }
            differences.append("In Classes : ").append(firstClass.getSimpleName()).append(" , ").append(secondClass.getSimpleName());
            differences.append(" different classes are : \n").append(differentInnerClasses);

        } else if (firstClass.getDeclaredClasses().length == 0) {
            differences.append("Class ").append(firstClass.getSimpleName()).append(" does not have inner classes \n");
            differences.append("Inner classes in class ").append(secondClass.getSimpleName()).append(" : \n");
            for (var innerClassItem : secondClass.getDeclaredClasses()) {
                differences.append(innerClassItem.getSimpleName()).append("\n");
            }
            differences.append("\n");
        } else {
            differences.append("Class ").append(secondClass.getSimpleName()).append(" does not have inner classes \n");
            differences.append("Inner classes in class ").append(firstClass.getSimpleName()).append(" : \n");
            for (var innerClassItem : firstClass.getDeclaredClasses()) {
                differences.append(innerClassItem.getSimpleName()).append("\n");
            }
            differences.append("\n");
        }
    }

    private void findDifferentFields(StringBuilder differences, Class firstClass, Class secondClass) {
        Field[] firstClassFields = firstClass.getDeclaredFields();
        Field[] secondClassFields = secondClass.getDeclaredFields();
        boolean[] firstClassFieldsContains = new boolean[firstClassFields.length];
        boolean[] secondClassFieldsContains = new boolean[secondClassFields.length];
        int currentSize = firstClassFields.length + secondClassFields.length;
        for (int i = 0; i < firstClassFields.length; ++i) {
            if (firstClassFields[i].getName().length() < 5) {
                continue;
            }
            if (firstClassFields[i].getName().substring(0, 5).equals("this$")) {
                currentSize--;
            }
        }
        for (int i = 0; i < secondClassFields.length; ++i) {
            if (secondClassFields[i].getName().length() < 5) {
                continue;
            }
            if (secondClassFields[i].getName().substring(0, 5).equals("this$")) {
                currentSize--;
            }
        }
        int equalFieldsAmount = 0;
        for (int i = 0; i < firstClassFields.length; ++i) {
            var firstClassFieldItem = firstClassFields[i];
            if (firstClassFieldItem.getName().length() >= 4 && firstClassFieldItem.getName().substring(0, 5).equals("this$")) {
                continue;
            }
            for (int j = 0; j < secondClassFields.length; ++j) {
                var secondClassFieldItem = secondClassFields[j];
                if (secondClassFieldItem.getName().length() >= 4 && secondClassFieldItem.getName().substring(0, 5).equals("this$")) {
                    continue;
                }
                if (firstClassFieldItem.getName().equals(secondClassFieldItem.getName()) &&
                        Modifier.toString(firstClassFieldItem.getModifiers()).equals(Modifier.toString(secondClassFieldItem.getModifiers())) &&
                        firstClassFieldItem.getType().getSimpleName().equals(secondClassFieldItem.getType().getSimpleName())) {
                    firstClassFieldsContains[i] = true;
                    secondClassFieldsContains[j] = true;
                    equalFieldsAmount += 2;
                }
            }
        }
        if (equalFieldsAmount == currentSize) {
            return;
        }
        differences.append(" Different fields : ").append("\n");
        differences.append("First class - ").append(firstClass.getSimpleName()).append("\n");
        for (int i = 0; i < firstClassFieldsContains.length; ++i) {
            if (firstClassFields[i].getName().length() >= 4 && firstClassFields[i].getName().substring(0, 5).equals("this$")) {
                continue;
            }
            if (!firstClassFieldsContains[i] && !firstClassFields[i].getName().equals("this$0")) {
                differences.append("* ");
                if (firstClassFields[i].getModifiers() != 0) {
                    differences.append(Modifier.toString(firstClassFields[i].getModifiers())).append(" ");
                }
                differences.append(firstClassFields[i].getType().getSimpleName()).append(" ").append(firstClassFields[i].getName()).append("\n");
            }
        }
        differences.append("Second class - ").append(secondClass.getSimpleName()).append("\n");
        for (int i = 0; i < secondClassFieldsContains.length; ++i) {
            if (secondClassFields[i].getName().length() >= 4 && secondClassFields[i].getName().substring(0, 5).equals("this$")) {
                continue;
            }
            if (!secondClassFieldsContains[i] && !secondClassFields[i].getName().equals("this$0")) {
                differences.append("* ");
                if (secondClassFields[i].getModifiers() != 0) {
                    differences.append(Modifier.toString(secondClassFields[i].getModifiers())).append(" ");
                }
                differences.append(secondClassFields[i].getType().getSimpleName()).append(" ").append(secondClassFields[i].getName()).append("\n");
            }
        }
        differences.append("\n");
    }

    private void findDifferentMethods(StringBuilder differences, Class firstClass, Class secondClass) {
        boolean[] firstClassMethodsContains = new boolean[firstClass.getDeclaredMethods().length];
        boolean[] secondClassMethodsContains = new boolean[secondClass.getDeclaredMethods().length];
        int equalMethodsAmount = 0;
        for (int i = 0; i < firstClass.getDeclaredMethods().length; ++i) {
            var firstClassMethod = firstClass.getDeclaredMethods()[i];
            for (int j = 0; j < secondClass.getDeclaredMethods().length; ++j) {
                var secondClassMethod = secondClass.getDeclaredMethods()[j];
                if (equalMethods(firstClassMethod, secondClassMethod)) {
                    firstClassMethodsContains[i] = true;
                    secondClassMethodsContains[j] = true;
                    equalMethodsAmount += 2;
                    break;
                }
            }
        }
        if (equalMethodsAmount == firstClassMethodsContains.length + secondClassMethodsContains.length) {
            return;
        }
        differences.append(" Different methods : \n");
        differences.append("First Class - ").append(firstClass.getSimpleName()).append("\n");
        for (int i = 0; i < firstClass.getDeclaredMethods().length; ++i) {
            if (firstClassMethodsContains[i]) {
                continue;
            }
            differences.append("* ");
            showMethod(differences, firstClass.getDeclaredMethods()[i], 0);
            differences.append("\n");
        }
        differences.append("Second Class - ").append(secondClass.getSimpleName()).append("\n");
        for (int i = 0; i < secondClass.getDeclaredMethods().length; ++i) {
            if (secondClassMethodsContains[i]) {
                continue;
            }
            differences.append("* ");
            showMethod(differences, secondClass.getDeclaredMethods()[i], 0);
            differences.append("\n");
        }
        differences.append("\n");
    }

    private boolean equalMethods(Method firstClassMethod, Method secondClassMethod) {
        boolean allEquals;
        allEquals = firstClassMethod.getReturnType().equals(secondClassMethod.getReturnType());
        allEquals = allEquals && Modifier.toString(firstClassMethod.getModifiers()).equals(Modifier.toString(secondClassMethod.getModifiers()));
        allEquals = allEquals && exceptionsEqual(firstClassMethod, secondClassMethod);
        allEquals = allEquals && parametersEqual(firstClassMethod, secondClassMethod);
        return allEquals;
    }

    /** A method that checks if the exceptions of two methods are equal */
    private boolean exceptionsEqual(Method firstClassMethod, Method secondClassMethod) {
        List<Class> firstClassExceptions = new ArrayList<>(Arrays.asList(firstClassMethod.getExceptionTypes()));
        List<Class> secondClassExceptions = new ArrayList<>(Arrays.asList(secondClassMethod.getExceptionTypes()));
        if (firstClassMethod.getExceptionTypes().length != secondClassMethod.getExceptionTypes().length) {
            return false;
        }
        for (var secondExceptionItem : secondClassExceptions) {
            if (!firstClassExceptions.contains(secondExceptionItem)) {
                return false;
            }
        }
        return true;
    }

    /** A method that checks if the parameters of two methods are equal */
    private boolean parametersEqual(Method firstClassMethod, Method secondClassMethod) {
        List<Class> firstClassParameters = new ArrayList<>(Arrays.asList(firstClassMethod.getParameterTypes()));
        List<Class> secondClassParameters = new ArrayList<>(Arrays.asList(secondClassMethod.getParameterTypes()));
        if (firstClassMethod.getExceptionTypes().length != secondClassMethod.getExceptionTypes().length) {
            return false;
        }
        for (var secondExceptionItem : secondClassParameters) {
            if (!firstClassParameters.contains(secondExceptionItem)) {
                return false;
            }
        }
        return true;
    }
}
