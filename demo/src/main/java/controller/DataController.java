package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.YourDatabaseService;

@Controller
public class DataController {
	@Autowired
    private YourDatabaseService databaseService;

    @PostMapping("/insertData")
    public String insertData(@RequestParam String titolo, @RequestParam String corpo) {
        databaseService.insertData(titolo, corpo);
        return "success";
    }
}
