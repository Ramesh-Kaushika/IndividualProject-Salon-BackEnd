package lk.project.salon.service;

import lk.project.salon.dto.PromotionDto;
import lk.project.salon.entity.Promotion;

import java.util.List;

public interface PromotionService {
    Object savePromotion(PromotionDto promotionDto);

    List<Promotion> getAllPromotion();

    String deletePromotion(Integer id);
}
