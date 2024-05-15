package fr.dkf.batch.springbatchsample.processor;

import fr.dkf.batch.springbatchsample.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(final Person person) throws Exception {
        // Logique de traitement des données ici
        String firstName = person.getFirstName().toUpperCase();
        String lastName = person.getLastName().toUpperCase();
        int age = person.getAge();

        Person transformedPerson = Person.builder()
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .build();
        log.info("Converting ( {} ) into ( {} )", person, transformedPerson);

        return transformedPerson;
    }
}