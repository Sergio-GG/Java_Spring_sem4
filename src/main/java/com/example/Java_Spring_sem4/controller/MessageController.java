package com.example.Java_Spring_sem4.controller;
import com.example.Java_Spring_sem4.domain.Message;
import com.example.Java_Spring_sem4.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
@AllArgsConstructor
public class MessageController {
    private final MessageRepository messageRepository;

    @GetMapping("/page")
    public String returnPage(){
        return "messages.html";
    }

    @PostMapping("/messages")
    public String addMessageToField(Message message, Model model){
        messageRepository.addMessage(message);
        model.addAttribute("messages", messageRepository.getMessages());
        return "messages";
    }
    @GetMapping("/messages")
    public String getMessages(Model model){
        model.addAttribute("messages", messageRepository.getMessages());
        return "messages";
    }

}
