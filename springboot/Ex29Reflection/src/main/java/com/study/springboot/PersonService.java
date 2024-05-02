package com.study.springboot;

import java.lang.reflect.*;

public class PersonService {
    // 리플렉션이란 객체를 통해 클래스의 정보를 분석해 내는 프로그램 기법을 말한다
    // 리플렉션을 사용하면 어노테이션, 생성자, 메소드, 필드 등 클래스에 대한 정보를 아주 자세히 알아낼 수 있다.
    // 사용용도 :
    // 1. 동적으로 Class를 사용 해야할 경우
    //    코드 작성 시점에서는 어떠한 Class를 사용해야할지 모르지만 Runtime에 Class를 가져와서 실행해야하는 경우 (Spring Annotation)
    // 2. Jackson, GSON 등의 JSON Serialization Library
    //    Reflection을 사용하여 객체 필드의 변수명/어노테이션명을 Json key와 mapping 해주고 있다.
    public void reflectionPersonMan( Class clazz ) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 생성자 목록
        System.out.println("생성자 목록");

        // getConstructors : 자체 + 상속된 생성자 목록
        // getDeclaredConstructors : 자체 생성자 목록
        Constructor[] cons = clazz.getDeclaredConstructors();
        for( Constructor con : cons ){
            System.out.println(con);

            if( con.getParameterCount() > 0 ){
                // public PersonMan(String name, int age)
                // CTRL + ALT + V : 반환값 코드 자동생성
                Class[] parameterTypes = con.getParameterTypes();
                System.out.println("parameterTypes.length = " + parameterTypes.length);
                for( Class type : parameterTypes){
                    System.out.println("type.getName() = " + type.getName());
                }

                Parameter[] parameters = con.getParameters();
                for( Parameter parameter: parameters ){
                    System.out.println("parameter.getName() = " + parameter.getName());
                }
            }

        }

        //클래스 정보(Class)를 이용한 객체 생성
        //java9이후에는 사용하지 않음. deprecated.
        PersonMan p1 = (PersonMan)clazz.newInstance();
        System.out.println("p1 = " + p1);
        System.out.println("p1.getName() = " + p1.getName());
        System.out.println("p1.getAge() = " + p1.getAge());

        //생성자함수로부터 객체 생성 : 추천하는 방법
        //기본생성자 반환
        Constructor<?> basicCon = clazz.getDeclaredConstructor();
        PersonMan p2 = (PersonMan)basicCon.newInstance();
        System.out.println("p2 = " + p2);
        //왜? ObjectMapper는 기본생성자만 가지고 객체생성을 할까?
        // {"name":"hong", "age": 20}  => 클래스 객체(필드명,Getter/Setter)
        // setName( "hong" ) : 값을 초기화한다.
        // setAge( 20 ) : 값을 초기화한다.

        //매개변수가 있는 생성자 반환
        Constructor<?> paramCon = clazz.getDeclaredConstructor(String.class, int.class);
        PersonMan p3 = (PersonMan) paramCon.newInstance("hong", 20);
        System.out.println("p3 = " + p3);
        System.out.println("p3.getName() = " + p3.getName());


        //메소드 목록
        System.out.println("메소드 목록");
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods ){
            System.out.println(method);
            System.out.println(method.getName());
            System.out.println(method.getParameterCount());
            //method.invoke() : 메소드를 호출(실행)해주는 메소드
        }
        System.out.println();
        //필드 목록
        System.out.println("필드 목록");
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getName());
            //private, protected도 접근 권한을 풀어준다.
            field.setAccessible(true);
            System.out.println(field.getDeclaredAnnotations());
        }
        System.out.println();
    }
}