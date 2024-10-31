package lk.project.salon.controller;

import lk.project.salon.dto.AdminDto;
import lk.project.salon.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("api/v1/admin")
public class AdminController {

   private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> registerAdmin(@RequestBody AdminDto adminDto){
        System.out.println("mona");
        System.out.println("Received AdminDto: " + adminDto);
        Object ad = adminService.registerAdmin(adminDto);
        return new ResponseEntity<>(ad, HttpStatus.CREATED);
    }

    @GetMapping("/text-2")
    public String getMyText2(){
        String myText = "I m A NOT Noob";
        System.out.println(myText);
        return myText;
    }
}
