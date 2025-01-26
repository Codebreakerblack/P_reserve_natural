package dev.mariel.P_reserve_natural.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import dev.mariel.P_reserve_natural.facade.Base64System;
import dev.mariel.P_reserve_natural.facade.BcryptSystem;
import dev.mariel.P_reserve_natural.facade.EncryptionFacade;
import dev.mariel.P_reserve_natural.facade.IEncryptFacade;

@Configuration
public class BeansConfig {

    @Bean
    public BcryptSystem bcryptSystem() {
        return new BcryptSystem(new BCryptPasswordEncoder());
    }

    @Bean
    public Base64System base64System() {
        return new Base64System();
    }

    public IEncryptFacade encryptFacade() {
        return new EncryptionFacade(new BCryptPasswordEncoder(), base64System());
    }

}
