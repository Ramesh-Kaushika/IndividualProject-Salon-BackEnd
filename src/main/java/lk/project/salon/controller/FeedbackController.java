package lk.project.salon.controller;

import lk.project.salon.dto.FeedbackDto;
import lk.project.salon.entity.Feedback;
import lk.project.salon.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.ObjectView;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/feedback")
public class FeedbackController {

    @Autowired
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity<Object> saveFeedback(@RequestBody FeedbackDto feedbackDto) {
        Object newFeedback = feedbackService.saveFeedback(feedbackDto);
        return new ResponseEntity<>(newFeedback, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getAllFeedback() {
        List<Feedback> feedbacks = feedbackService.getAllFeedback();
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFeedback(@PathVariable Integer id) {
                Object deleted = feedbackService.deleteFeedback(id);
                return new ResponseEntity<>(deleted, HttpStatus.CREATED);
    }
}
