package com.github.vanroy.springdata.reactive.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * Notification service delivred by SSE.
 *
 * @param <O> The Object to send
 */
@Service
public class NotificationService<O> {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);
    private final List<SseEmitter> sseEmitters = new ArrayList<>();

    public void sendMessage(O message) {
        synchronized (this.sseEmitters) {
            for (SseEmitter sseEmitter : this.sseEmitters) {
                // Servlet containers don't always detect ghost connection, so we must catch exceptions ...
                try {
                    sseEmitter.send(message, MediaType.APPLICATION_JSON);
                } catch (Exception e) {
                    LOGGER.error("Failed to send sse message {}", e.getMessage());
                }
            }
            LOGGER.debug("Sent message to {} client(s).", sseEmitters.size());
        }
    }

    public SseEmitter registerClient() {
        SseEmitter sseEmitter = new SseEmitter();
        LOGGER.debug("Register new SSE client");
        synchronized (this.sseEmitters) {
            this.sseEmitters.add(sseEmitter);
            sseEmitter.onCompletion(() -> {
                synchronized (this.sseEmitters) {
                    this.sseEmitters.remove(sseEmitter);
                }
                LOGGER.debug("Un-register SSE client");
            });
        }
        return sseEmitter;
    }

}
