package com.sujit.javafeatures.javareflection;

import com.sujit.javafeatures.javaio.Item;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Reflection {

    public void reflect() throws Exception {
        Class<?> myLinkedHashMap = LinkedHashMap.class;

        System.out.println(myLinkedHashMap);
        Class<?>[] innerClassEnumAndInterfaces = myLinkedHashMap.getClasses();
        System.out.println("Inner Classes, Enums and Interfaces :: " + Arrays.toString(innerClassEnumAndInterfaces));
        Class<?>[] innerClassEnumAndInterfacesPrivateToo = myLinkedHashMap.getDeclaredClasses();
        System.out.println(" All Private, public, protected and package Inner Classes, Enums and Interfaces :: " + Arrays.toString(innerClassEnumAndInterfacesPrivateToo));
        // almost similar with declaring classs method
        System.out.println("Package Name :: " + myLinkedHashMap.getPackage().getName());
        System.out.println("Class Modifier :: " + LinkedHashMap.class.getModifiers());
        // getting type variables

        TypeVariable<?>[] typeVariables = myLinkedHashMap.getTypeParameters();
        System.out.println("Type Parameters :: ");
        for (TypeVariable var:typeVariables ) {
            System.out.println(var.getName());
        }
        //Get implemented interfaces
        Class<?>[] implIntercaces = myLinkedHashMap.getInterfaces();
        System.out.println("Implemented Interfaces are :: " + Arrays.toString(implIntercaces));
        //get superclass
        Class<?> superclasses = myLinkedHashMap.getSuperclass();
        System.out.println("Super Class :: " + superclasses);

        // Get Public Methods
        Method[] publicMethod = myLinkedHashMap.getDeclaredMethods();
        System.out.println("Public Methods :: " + Arrays.toString(publicMethod));
        // Public Constructors
        Constructor<?>[] publicConstructors = myLinkedHashMap.getConstructors();
        System.out.println("Public Constructors :: " + Arrays.toString(publicConstructors));
        //creating object
        Constructor<?> constructor = myLinkedHashMap.getConstructor();
        Map<Integer, String> object = (Map<Integer, String>) constructor.newInstance();
        // invokong method
        Method method = myLinkedHashMap.getMethod("put", Object.class, Object.class);
        System.out.println("Method name is :: " +method.getName());
        System.out.println("Method Return Type  :: " +method.getReturnType());
        System.out.println("Method parameter type is ::  " + Arrays.toString(method.getParameterTypes()));
        System.out.println("Method Modifier is:: " +method.getModifiers());

        //public Fields
        Field[] publicFiels = myLinkedHashMap.getDeclaredFields();
        System.out.println("Public Fields :: " + Arrays.toString(publicFiels));
        //single Field
        System.out.println("Single Field :: " + publicFiels[3] );//to get field name only publicFields[3].getName()
        //field Type
        Field oneField = myLinkedHashMap.getDeclaredField(publicFiels[1].getName());
        Class<?> oneFieldType = oneField.getType();
        System.out.println("Field Type of " +oneField.getName() +" is :: " + oneFieldType);
        //Get Public Field

        //System.out.println("The value of field is :: " + oneField.get(object));



        //Annotations
        Annotation[] annotations = myLinkedHashMap.getDeclaredAnnotations();
        System.out.println("Annotations :: " + Arrays.toString(annotations));

    }

    public static void main(String[] args) throws Exception{
        Reflection reflection = new Reflection();
        //reflection.reflect();
        //reflection.getSetFields();
        //reflection.invokeMethods();

        Class<?> itemMainClass = Class.forName("com.sujit.javafeatures.javaio.impl.FileImporterExporterAndPathSelector");
        Object obj = itemMainClass.newInstance();
        Method[] methods = itemMainClass.getDeclaredMethods();
        for (Method metd : methods ) {
            if(metd.getName().startsWith("prep"))
                metd.invoke(obj);

        }


    }

    private void invokeMethods() throws Exception {
        Method method = Class.forName("java.util.HashMap").getMethod("put", Object.class, Object.class);

        Map<Integer, String > reflectedMap = new HashMap<>();
        // before calling private method make sure
        //method.setAccessible(true);
        method.invoke(reflectedMap,101, "Sujit");
        System.out.println("Object state after calling put method with value 101 and sujit  :: " +reflectedMap);



    }

    private void getSetFields() throws Exception {
        Field privateField = Class.forName("javaio.Item").getDeclaredField("name");
        privateField.setAccessible(true);
        Item item = new Item();
        System.out.println("Get Value of Name field :: " + privateField.get(item));
        //setting new value
        privateField.set(item, "Roti Tarkari");
        System.out.println("Get Value of Name field after Resetting :: " + privateField.get(item));




    }
}
