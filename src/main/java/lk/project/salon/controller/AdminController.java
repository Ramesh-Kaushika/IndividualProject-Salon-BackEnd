package lk.project.salon.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("api/v1/admin")
public class AdminController {

    @GetMapping(path = "/text-1")
    public String getMyText(){
        String myText = "I m A Pro";
        System.out.println(myText);
        return myText;
    }
    @GetMapping("/text-2")
    public String getMyText2(){
        String myText = "I m A NOT Noob";
        System.out.println(myText);
        return myText;
    }
}
