package lk.project.salon.service;

import lk.project.salon.dto.FeedbackDto;
import lk.project.salon.entity.Feedback;

import java.util.List;

public interface FeedbackService {
    Object saveFeedback(FeedbackDto feedbackDto);

    List<Feedback> getAllFeedback();

    Object deleteFeedback(Integer id);
}
