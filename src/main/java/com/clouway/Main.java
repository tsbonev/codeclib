package com.clouway;

import com.clouway.parser.JsonCodec;
import com.clouway.parser.XmlCodec;
import com.clouway.parser.MessageCodec;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args){

        MessageCodec codec;

        List<Person> list = new ArrayList<>();

        /*
        String type = args[1];
        String filepath = args[2];
        String action = args[3];
        */

        String type = "json";
        String filepath = "message.json";


        if(type.equals("json")){

            codec = new JsonCodec(Person.class);

            File file = new File(filepath);

            list = (List<Person>) codec.parseFile(file);

        }

    }

}
