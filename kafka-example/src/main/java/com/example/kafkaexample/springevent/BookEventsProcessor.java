package com.example.kafkaexample.springevent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BookEventsProcessor {
    @EventListener
    void handleEmployeeEvent(BookEvent event) {
        // handle the event
        BookEvent bookEvent = (BookEvent) event;

        System.out.println("Book Event Type " + bookEvent.getEventType()
                + " with details : " + bookEvent.getBook());
    }
}
