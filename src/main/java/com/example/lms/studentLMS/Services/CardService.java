package com.example.lms.studentLMS.Services;

import com.example.lms.studentLMS.Enum.CardStatus;
import com.example.lms.studentLMS.Models.LibraryCard;
import com.example.lms.studentLMS.Models.Student;
import com.example.lms.studentLMS.Repositories.CardRepository;
import com.example.lms.studentLMS.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public String associateCardAndStudent(Integer cardId, Integer studentId) throws Exception{
        //check if the card with given cardId is there or not
        Optional<LibraryCard> optionalLibraryCard = cardRepository.findById(cardId);
        if(optionalLibraryCard.isEmpty()){
            throw new Exception("There is no card exists with the cardID: "+ cardId);
        }

        //now check if the student with given studentId is there or not
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if(optionalStudent.isEmpty()){
            throw new Exception("There is no student exists with the studentID: "+ studentId);
        }

        LibraryCard card = optionalLibraryCard.get();
        Student student = optionalStudent.get();
        card.setStudent(student); //this is how we set it up
        card.setCardStatus(CardStatus.ACTIVE); // hence the student id linked with the cardId now the card status is update to active
        cardRepository.save(card);
        return "Successfully associated the cardID " + cardId + "with Student ID" + studentId;
    }
}
