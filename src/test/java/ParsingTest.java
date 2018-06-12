import com.clouway.Person;
import com.clouway.PersonList;
import com.clouway.parser.JsonCodec;
import com.clouway.parser.MessageCodec;
import com.clouway.parser.XmlCodec;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParsingTest {

    MessageCodec codec;

    @Test
    public void JsonFromFile(){

        codec = new JsonCodec(PersonList.class);

        File file = new File("message.json");

        PersonList list = (PersonList) codec.parseFile(file);

        assertThat(list.personList.size(), is(7));

    }

    @Test
    public void ObjectToJson(){
        codec = new JsonCodec(PersonList.class);

        PersonList list = new PersonList();
        Person person = new Person();
        person.age = 20;
        person.firstName = "John";
        person.lastName = "Smith";

        for(int i = 0; i < 7; i++){
            list.personList.add(person);
        }

        File file = codec.parseObject(list);

        assertThat(file.exists(), is(true));
    }


    @Test
    public void ObjectToXml(){

        codec = new XmlCodec(PersonList.class);

        PersonList list = new PersonList();
        Person person = new Person();
        person.age = 20;
        person.firstName = "John";
        person.lastName = "Smith";

        for(int i = 0; i < 7; i++){
            list.personList.add(person);
        }

        File file = codec.parseObject(list);

        assertThat(file.exists(), is(true));

    }

    @Test
    public void XmlFromFile(){

        codec = new XmlCodec(PersonList.class);

        File file = new File("message.xml");

        PersonList list = (PersonList) codec.parseFile(file);

        assertThat(list.personList.size(), is(7));

    }

}
