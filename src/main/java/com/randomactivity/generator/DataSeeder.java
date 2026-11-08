package com.randomactivity.generator;

import com.randomactivity.generator.model.Activity;
import com.randomactivity.generator.repository.ActivityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ActivityRepository activityRepository;

    public DataSeeder(ActivityRepository activityRepository){
        this.activityRepository=activityRepository;
    }
    @Override
    public void run(String...args) throws Exception{
        if(activityRepository.count()==0){
            List<Activity>initialActivitties=List.of(
                   new Activity(null,"Посмотреть культовый фильм","Проведи час в тишине за чтением любимого жанра","lazy","any",true),
                   new Activity(null,"Принять горячую ванну","Добавь пену, соль и включи приятную музыку","lazy","any",true),
                   new Activity(null,"Почитать художественную книгу","Проведи час в тишине за чтением любимого жанра","lazy","any",true),

                   new Activity(null,"Устроить домашнюю тренировку","Займись разминкой или йогой под приятную музыку","active","any",true),
                   new Activity(null,"Сделать перестановку","Освежите комнату,передвинув рабочий стол или добавив новый декор","active","weekend",true),
                   new Activity(null,"Пробежка в парке","Оденься по погоде,включи бодрый подкаст и побежали","active","any",true),

                   new Activity(null,"Поиграть в настолки","Собери друзей или семью на партию в Монополию или Имаджинариум","social","weekend",true),
                   new Activity(null,"Позвони старому другу","Узнай как дела у человека с которым давно не общался","social","any",true),
                   new Activity(null,"Посетить кофейню","Найди на карте кофейню в которой еще ниразу не был ","social","any",false),

                   new Activity(null,"Приготовить новое блюдо","Найди необычный рецепт и приготовь его на ужин ","creative","any",false),
                   new Activity(null,"Порисовать или пораскрашивать","Попробуй нарисовать что то новое ","creative","any",true)
            );
            activityRepository.saveAll(initialActivitties);
            System.out.println(">>> База данных успешно наполнена стартовыми занятиями!");
        }
    }

}
