package CesarChiffre;

public class Alphabet {

    private char[] alphabet = new char[36];
    private int key = -1;

    public Alphabet() {
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        alphabet = chars.toCharArray();
    }

    public int getIndexFromChar(char c) {
        int index = -1;
        for (int i = 0; i < alphabet.length; i++) {
            if(alphabet[i] == c) {
                index = i;
            }
        }
        return index;
    }
    public void setKey(int key) {
        this.key = key;
    }

    public char getCharFromIndex(int index) {
        return alphabet[index];
    }

    // m + a = c(mod36)

    public char encryptChar(char c) {
        char encryptedC = '-';
        int CIndex = getIndexFromChar(c);
        encryptedC = getCharFromIndex((CIndex + key)%alphabet.length);

        return encryptedC;
    }

    public char decryptChar(char c) {
        char decryptedC = '-';
        int CIndex = getIndexFromChar(c);
        decryptedC = getCharFromIndex((CIndex + (alphabet.length-key))%alphabet.length);
        return decryptedC;
    }
}
