import Inherited.Father;
import Inherited.Son;
import annotation.Age;
import annotation.MyTestAnnotation;
import repeatable.Game;
import repeatable.People;
import repeatable.PlayGame;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class test {

   public static void main(String[] args) throws NoSuchMethodException {

      /*//获取Son的class对象
       Class<Son> sonClass = Son.class;
      // 获取Son类上的注解MyTestAnnotation可以执行成功
      MyTestAnnotation annotation = sonClass.getAnnotation(MyTestAnnotation.class);*/
        /**
         * 获取类注解属性
         */
        Class<Father> fatherClass = Father.class;
        boolean annotationPresent = fatherClass.isAnnotationPresent(MyTestAnnotation.class);
        if(annotationPresent){
            MyTestAnnotation annotation = fatherClass.getAnnotation(MyTestAnnotation.class);
            System.out.println(annotation.name());
            System.out.println(annotation.age());
        }

        /**
         * 获取方法注解属性
         */
        try {
            Field age = fatherClass.getDeclaredField("age");
            boolean annotationPresent1 = age.isAnnotationPresent(Age.class);
            if(annotationPresent1){
                Age annotation = age.getAnnotation(Age.class);
                System.out.println(annotation.value());
            }

            Method play = PlayGame.class.getDeclaredMethod("play");
            if (play!=null){
                People annotation2 = play.getAnnotation(People.class);
                Game[] value = annotation2.value();
                for (Game game : value) {
                    System.out.println(game.value());
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
