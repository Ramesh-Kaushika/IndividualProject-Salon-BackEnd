package lk.project.salon.service.impl;

import lk.project.salon.dto.PromotionDto;
import lk.project.salon.entity.Promotion;
import lk.project.salon.repo.PromotionRepo;
import lk.project.salon.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionImpl implements PromotionService {

    @Autowired
    PromotionRepo promotionRepo;

    @Override
    public Object savePromotion(PromotionDto promotionDto) {
        Promotion promotion = new Promotion(
                promotionDto.getPromotionId(),
                promotionDto.getTitle(),
                promotionDto.getDescription(),
                promotionDto.getStartDate(),
                promotionDto.getEndDate(),
                promotionDto.getDiscount()
        );
        return promotionRepo.save(promotion);
    }

    @Override
    public List<Promotion> getAllPromotion() {
        return promotionRepo.findAll();
    }

    @Override
    public String deletePromotion(Integer id) {
       if (promotionRepo.existsById(id)){
           promotionRepo.deleteById(id);
           return "Promotion Deleted";
       }
       return "No Promotion found";
    }
}
