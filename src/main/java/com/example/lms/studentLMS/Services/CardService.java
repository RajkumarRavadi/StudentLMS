package com.example.lms.studentLMS.Services;

import com.example.lms.studentLMS.Enum.CardStatus;
import com.example.lms.studentLMS.Models.LibraryCard;
import com.example.lms.studentLMS.Models.Student;
import com.example.lms.studentLMS.Repositories.CardRepository;
import com.example.lms.studentLMS.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private StudentRepository studentRepository;


    public String addNewCard(){
        LibraryCard card = new LibraryCard();
        card.setCardStatus(CardStatus.NEW);
        card.setNoOfBooksIssued(0);
        card = cardRepository.save(card);
        return "The card with the card id " + card.getCardId() + " has generated.";
    }

    public String associateCardAndStudent(Integer cardId, Integer studentId){
        LibraryCard card = cardRepository.findById(cardId).get();
        Student student = studentRepository.findById(studentId).get();
        card.setStudent(student); //this is how we set it up
        card.setCardStatus(CardStatus.ACTIVE); // hence the student id linked with the cardId now the card status is update to active
        cardRepository.save(card);
        return "Successfully associated the cardID " + cardId + "with Student ID" + studentId;
    }
}
