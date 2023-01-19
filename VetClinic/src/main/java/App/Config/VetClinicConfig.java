package App.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VetClinicConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
