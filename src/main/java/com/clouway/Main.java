package com.clouway;

import com.clouway.parser.JsonCodec;
import com.clouway.parser.XmlCodec;
import com.clouway.parser.MessageCodec;

import java.io.File;

public class Main {

    public static void main(String[] args){

        MessageCodec codec;

        PersonList list;

        String type = args[1];
        String filepath = args[2];
        String action = args[3];


        if(type.equals("json")){

            codec = new JsonCodec(PersonList.class);

            File file = new File(filepath);

            list = (PersonList)codec.parseFile(file);

            if(action.equals("--printAverageStats"))

            System.out.println("Users Count: " + list.personList.size());
            System.out.println("Average Age: " +
                    (int)(list.personList.stream()
                            .mapToInt(p -> p.age)
                            .average()
                            .getAsDouble())
            );

        }

    }

}
