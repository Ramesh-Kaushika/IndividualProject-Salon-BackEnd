package lk.project.salon.controller;

import lk.project.salon.dto.PromotionDto;
import lk.project.salon.entity.Promotion;
import lk.project.salon.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/promotion")
public class PromotionController {

    @Autowired
    PromotionService promotionService;

    @PostMapping
    public ResponseEntity<Object> savePromotion(@RequestBody PromotionDto promotionDto){
        Object savePromotion = promotionService.savePromotion(promotionDto);
        return new ResponseEntity<>(savePromotion, HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<Object> getAllPromotion(){
        List<Promotion> allPromotion = promotionService.getAllPromotion();
        return new ResponseEntity<>(allPromotion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePromotion(@PathVariable Integer id){
        String promotionDeleted = promotionService.deletePromotion(id);
        return new ResponseEntity<>(promotionDeleted, HttpStatus.CREATED);
    }


}
