//package com.example.Medical.controller;
//
//import com.example.Medical.DTO.RequestDTO;
//import com.example.Medical.entity.Chat;
//import com.example.Medical.entity.Message;
//import com.example.Medical.service.ChatService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/chat")
//public class ChatController {
//
//    @Autowired
//    private ChatService chatService;
//
//    @PostMapping("/create")
//    public Chat createChat(@ModelAttribute RequestDTO request){
//        return chatService.createChatSession(request.getPatientId(), request.getDoctorId());
//    }
//
//    @PostMapping("/send")
//    public Message sendMessage(@ModelAttribute RequestDTO request){
//        return chatService.sendMessage(request.getChatId(),
//                request.getSenderId(), request.getMessageContent());
//    }
//
//    @GetMapping("/messages/{chatId}")
//    public List<Message> getMessages(@PathVariable("chatId") Long chatId){
//        return chatService.getMessages(chatId);
//    }
//}
