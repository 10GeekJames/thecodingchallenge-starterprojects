package cipherPrograms;

import models.CipherMessage;

public class MorseCodeStrategy {
    public String decrypt(CipherMessage cipherMessage) {
        return cipherMessage.getCipherText();
    }
}
