package lk.project.salon.service.impl;


import lk.project.salon.dto.FeedbackDto;
import lk.project.salon.entity.Feedback;
import lk.project.salon.service.FeedbackService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackImpl implements FeedbackService {
    @Override
    public Object saveFeedback(FeedbackDto feedbackDto) {
        return null;
    }

    @Override
    public List<Feedback> getAllFeedback() {
        return null;
    }

    @Override
    public Object deleteFeedback(Integer id) {
        return null;
    }
}
