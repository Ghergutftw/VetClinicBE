package App.Prescription;

import java.util.HashMap;
public class DiseaseTreatment {
    HashMap<String,String> Book=new HashMap<>();
    public DiseaseTreatment(){
        Book.put("Anthrax","Anthrax Pill");
        Book.put("Black Quarter","Black Quarter Treatment");
        Book.put("Rabies","Euthanasia");
        Book.put("Pox","Pox Treatment");
        Book.put("Tetanus","Tetanus Treatment");
    }
    public HashMap<String, String> getBook() {
        return Book;
    }

    public void setBook(HashMap<String, String> book) {
        Book = book;
    }
}
