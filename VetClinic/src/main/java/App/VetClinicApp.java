package App;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import App.DTO.DoctorDTO;
import App.DTO.WorkingHoursDTO;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import App.Entity.Doctor;
import App.Entity.WorkingHours;
import App.Repository.WorkingHoursRepository;
import App.Service.ConsultationService;
import App.Service.DoctorService;
import App.Service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

import javax.transaction.Transactional;

@SpringBootApplication
@Configuration
public class VetClinicApp {

    //Programul de munca a firmei
    public static final int startingTime = 10;
    public static final int endingTime =16;

    public static void main(String[] args) {

        SpringApplication.run(VetClinicApp.class, args);
        //Intai se adauga doctori

    }
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    WorkingHoursRepository workingHoursRepository;
    ConsultationService consultationService;
    DoctorService doctorService;
    UserService userService;

    public VetClinicApp(WorkingHoursRepository workingHoursRepository, ConsultationService consultationService, DoctorService doctorService, UserService userService) {
        this.workingHoursRepository = workingHoursRepository;
        this.consultationService = consultationService;
        this.doctorService = doctorService;
        this.userService=userService;
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
//        Resetare Baza da Date
//        consultationRepository.deleteAll();
//        workingHoursRepository.deleteAll();
//        doctorRepository.deleteAll();
//        generateDoctors();


        //Generate intervale de munca a doctorilor
        generateIntervals(startingTime,endingTime);
    }

    public void generateIntervals(int startingHour, int endingHour){
        List<DoctorDTO> theDoctors= doctorService.getDoctors();
        for (DoctorDTO theDoctor: theDoctors) {
            for (int i = startingHour; i <= endingHour; i++) {
                Calendar calendarStart = Calendar.getInstance();
                calendarStart.set(2022,Calendar.SEPTEMBER,12,i,0);
                Calendar calendarEnd = Calendar.getInstance();
                calendarEnd.set(2022,Calendar.SEPTEMBER,12,i+1,0);
                workingHoursRepository.save(new WorkingHours(-1,calendarStart.getTime(), calendarEnd.getTime(), "FREE", modelMapper().map(theDoctor,Doctor.class)));
            }
        }
    }



}
