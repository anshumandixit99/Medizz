//package com.example.Medical.service;
//
//import com.example.Medical.entity.Chat;
//import com.example.Medical.entity.Doctor;
//import com.example.Medical.entity.Message;
//import com.example.Medical.entity.Users;
//import com.example.Medical.repository.ChatRepository;
//import com.example.Medical.repository.DoctorRepository;
//import com.example.Medical.repository.MessageRepository;
//import com.example.Medical.repository.UserRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@Slf4j
//public class ChatService {
//
//    @Autowired
//    private MessageRepository messageRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private ChatRepository chatRepository;
//
//    @Autowired
//    private DoctorRepository doctorRepository;
//
//    public Chat createChatSession(Long patientId, Long doctorId){
//
//        Users patient = userRepository.findById(patientId)
//                .orElseThrow(()->new RuntimeException("Patient not found"));
//
//        Doctor doctor = doctorRepository.findById(doctorId)
//                .orElseThrow(()->new RuntimeException("Doctor not found"));
//
//        Chat chat = new Chat();
//        chat.setPatient(patient);
//        chat.setDoctor(doctor);
//
//        return chatRepository.save(chat);
//    }
//
//    public Message sendMessage(Long chatId, Long senderId, String messageContent){
//
//        Chat chat = chatRepository.findById(chatId)
//                .orElseThrow(()-> new RuntimeException("Chat not found"));
//
//        Users patient = userRepository.findById(senderId).orElse(null);
//
//        Doctor doctor = doctorRepository.findById(senderId).orElse(null);
//
//        if(patient==null && doctor==null) {
//            throw new RuntimeException("sender not found");
//        }
//
//        Message message = new Message();
//        message.setChat(chat);
//
//        if(patient!=null){
//            message.setSenderPatient(patient);
//        }else{
//            message.setSendorDoctor(doctor);
//        }
//
//        message.setMessage(messageContent);
//
//        return messageRepository.save(message);
//    }
//
//    public List<Message> getMessages(Long chatId){
//        return messageRepository.findByChatId(chatId);
//    }
//}
