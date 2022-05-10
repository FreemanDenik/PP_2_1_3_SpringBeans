package app;

import app.config.AppConfig;
import app.model.AnimalsCage;
import app.model.Dog;
import app.model.Timer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        List<Long> timer = new ArrayList<>();
        for (int i = 0; i < 5; i++) {

            AnimalsCage bean =
                    applicationContext.getBean(AnimalsCage.class);
            bean.whatAnimalSay();
            timer.add(applicationContext.getBean(Timer.class).getTime());
        }

        boolean result = timer.stream().allMatch(t->t == applicationContext.getBean(Timer.class).getTime());
        System.out.println("Ответ: " + result);

    }

}
