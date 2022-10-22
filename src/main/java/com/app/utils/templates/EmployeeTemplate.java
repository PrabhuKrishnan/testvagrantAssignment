package com.app.utils.templates;


import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.app.utils.fixtures.Address;
import com.app.utils.fixtures.Employee;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeTemplate implements TemplateLoader {


    @Override
    public void load() {
        Fixture.of(Employee.class).addTemplate("valid", new Rule() {{
            add("id", random(Integer.class, range(100, 1000)));
            add("isFTE", random(true, false));
            add("firstName", random("prabhu", "krishnan", "Ram"));
            add("address", random(new Address("salem", "salem")));
            add("roles", uniqueRandom(Arrays.asList("tester"), Arrays.asList("traveller")));

        }});

        Fixture.of(Employee.class).addTemplate("invalidId", new Rule() {{
            add("id", random(Integer.class, range(1, 3)));
            add("isFTE", random(true, false));
            add("firstName", random(getFirstName()));
            add("address", random(new Address("salem", "salem")));
            add("roles", uniqueRandom(Arrays.asList("tester"), Arrays.asList("traveller")));

        }});

        Fixture.of(Employee.class).addTemplate("invalidFirstName").inherits("valid", new Rule() {{
            add("firstName", random("pra-bhu-", "kr-ishn-an", "Ra--m"));
        }});
    }

    private Object[] getFirstName()
    {
        Faker faker = new Faker();
        List<String> list = new ArrayList<>();

        for(int i=0;i<10;i++)
        {
            list.add(faker.name().firstName());
        }
        return list.toArray();
    }



















}
