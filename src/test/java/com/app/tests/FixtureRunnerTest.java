package com.app.tests;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import com.app.utils.fixtures.Address;
import com.app.utils.fixtures.Employee;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class FixtureRunnerTest {

    @Test
    public void fixtureFactoryTest() {

        Fixture.of(Employee.class).addTemplate("valid", new Rule() {{
            add("id", random(Integer.class, range(100, 1000)));
            add("isFTE", random(true, false));
            add("firstName", random("prabhu", "krishnan", "Ram"));
            add("address", random(new Address("salem", "salem")));
            add("roles", uniqueRandom(Arrays.asList("tester"), Arrays.asList("traveller")));
        }});

        List<Employee> valid = Fixture.from(Employee.class).gimme(10, "valid");
        System.out.println(valid);
        valid.forEach(System.out::println);


    }
}
