package dev.mariel.P_reserve_natural.facade;

public interface IEncryptFacade {

    String encode(String type, String data);

    String decode(String type, String data);

}
