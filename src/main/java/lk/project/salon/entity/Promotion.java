package lk.project.salon.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Entity
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int promotionId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String startDate;
    @Column(nullable = false)
    private String endDate;
    @Column(nullable = false)
    private float discount;

    public Promotion() {
    }

    public Promotion(int promotionId, String title, String description, String startDate, String endDate, float discount) {
        this.promotionId = promotionId;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discount = discount;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }


}
