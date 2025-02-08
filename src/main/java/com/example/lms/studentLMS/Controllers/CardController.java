package com.example.lms.studentLMS.Controllers;
import com.example.lms.studentLMS.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("add")
    public String addCard(){
        return cardService.addNewCard();
    }

    @PutMapping("associateCardAndStudent")
    public ResponseEntity associateCardAndStudent(@RequestParam("cardId")Integer cardId,
                                          @RequestParam("studentId") Integer studentId) {
          try{
              String response = cardService.associateCardAndStudent(cardId, studentId);
              return new ResponseEntity(response, HttpStatus.OK);
          }catch(Exception e){
              return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
