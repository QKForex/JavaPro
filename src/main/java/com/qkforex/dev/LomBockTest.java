package com.qkforex.dev;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

//@Data
@Slf4j
@Value
//@RequiredArgsConstructor(staticName = "of")
public class












LomBockTest {

    @Getter
    @Setter
    private String name;

    public List<Method> getAllMethods() {
        List<Method> methods = new ArrayList<Method>();
        for (Method method : this.getClass().getMethods()) {
            methods.add(method);
        }
        return methods;
    }
    public List<Constructor> getAllConstructors(){
        List<Constructor> methods = new ArrayList<Constructor>();
        for (Constructor method : this.getClass().getConstructors()) {
            methods.add(method);
        }
        return methods;
    }


    public static void main(String[] args) {

        //LomBockTest lb =new LomBockTest("haha");
        //LomBockTest lb =LomBockTest.of("haha");
        LomBockTest lb=new LomBockTest("hha");
       // lb.setName("FrankSang");
        System.out.println(lb.getName());
        log.info("this is my first SLF4J");
       /* List<Method> methods=lb.getAllMethods();
        for(Method method:methods)
        {
            System.out.println(method.getName());
//            System.out.println(method.get());
        }*/

        List<Constructor> constructors=lb.getAllConstructors();
        for(Constructor constructor:constructors)
        {
            System.out.println(constructor.getName());
            try {
                LomBockTest llb= (LomBockTest) constructor.newInstance("haha");
                System.out.println(llb.getName());
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }

    }
}
