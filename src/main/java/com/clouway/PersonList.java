package com.clouway;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class PersonList {

    public List<Person> personList = new ArrayList<>();

}
