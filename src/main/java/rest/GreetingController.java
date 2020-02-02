package rest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    Map<String, Integer> map = new HashMap<>();



   /* @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }*/

    @RequestMapping("/person")
    public void enterPerson(@RequestParam(value = "name") String name, @RequestParam(value ="age") int age){
        Person p = new Person(name, age);
        p.printPersonToString();
        map.put(name, age);

    }

    @RequestMapping("/list")
    public String listPersons(){
        String persons = "";
        for(Map.Entry e: map.entrySet()){
            persons += e.getKey() + " " + e.getValue() + ";\n";
        }
        return persons;
    }


    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }



}
