package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CipherMessage {
    private ArrayList<CipherMessageKeyValue> _cipherKey = new ArrayList<CipherMessageKeyValue>();
    private String _cipherText = "";

    public List<CipherMessageKeyValue> getCipherKey() {return _cipherKey; }
    public void addCipherKey(CipherMessageKeyValue cipherMessageKeyValue) {_cipherKey.add(cipherMessageKeyValue); }

    public String getCipherText() {return _cipherText; }
    public void setCipherText(String cipherText) {_cipherText = cipherText; }
}
