package nekogochan.controller;

import nekogochan.database.TestDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    public TestDB testDB;

    @GetMapping("/db")
    public String testDB() {
        testDB.add(10000);
        return testDB.getAll();
    }



}
