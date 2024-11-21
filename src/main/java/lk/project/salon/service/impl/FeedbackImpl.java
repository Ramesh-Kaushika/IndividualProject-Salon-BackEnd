package lk.project.salon.service.impl;


import lk.project.salon.dto.FeedbackDto;
import lk.project.salon.entity.Feedback;
import lk.project.salon.repo.FeedbackRepo;
import lk.project.salon.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackImpl implements FeedbackService {

    @Autowired
    FeedbackRepo feedbackRepo;

    @Override
    public Object saveFeedback(FeedbackDto feedbackDto) {
       Feedback feedback = new Feedback(
               feedbackDto.getFeedbackId(),
               feedbackDto.getRating(),
               feedbackDto.getComment(),
               feedbackDto.getDate()
       );
       return  feedbackRepo.save(feedback);
    }

    @Override
    public List<Feedback> getAllFeedback() {
        return feedbackRepo.findAll();
    }

    @Override
    public Object deleteFeedback(Integer id) {
       if (feedbackRepo.existsById(id)){
           feedbackRepo.deleteById(id);
           return "Feedback deleted";
       }
       return "No feedback found";
    }
}
