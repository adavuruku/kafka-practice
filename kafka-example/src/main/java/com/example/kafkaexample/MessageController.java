package com.example.kafkaexample;

import com.example.kafkaexample.dto.Book;
import com.example.kafkaexample.dto.Course;
import com.example.kafkaexample.dto.MessageRequest;
import com.example.kafkaexample.dto.Student;
import com.example.kafkaexample.springevent.BookService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class MessageController {
    public MessageController(KafkaTemplate<String, String> kafkaTemplate,
                             KafkaTemplate<String, Object> multiTypeKafkaTemplate,
                             KafkaTemplate<String, Book> kafkaBookTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.multiTypeKafkaTemplate = multiTypeKafkaTemplate;
        this.kafkaBookTemplate = kafkaBookTemplate;
    }

    private KafkaTemplate<String, String> kafkaTemplate;

    private KafkaTemplate<String, Object> multiTypeKafkaTemplate;

    private KafkaTemplate<String, Book> kafkaBookTemplate;

    private BookService bookService;

    @PostMapping("/messages")
    public void publish(@RequestBody MessageRequest request){
        kafkaTemplate.send("amigoscode", request.getMessage());

    }

//    multiTypeKafkaTemplate.send("amigosObjectcode", new Farewell("Farewell", 25));
//        multiTypeKafkaTemplate.send("amigosObjectcode", "Simple string message");
    @PostMapping("/student")
    public Object createStudent(@RequestBody Student student){
        multiTypeKafkaTemplate.send("multitype", student);
        return student;
    }

    @PostMapping("/course")
    public Object createCourse(@RequestBody Course course){
        multiTypeKafkaTemplate.send("multitype", course);
        return course;
    }

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Book book)
    {
        // Sending the message
        kafkaBookTemplate.send("top1", book);
        return "Published Successfully";
    }

    @PostMapping("/book/event")
    public String testBookEvent(@RequestBody Book book)
    {
        bookService.createNewBooks(book);
        return "Published Successfully";
    }
}
