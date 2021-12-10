package Verschlüsseln;

public class Verschlüsselungsverfahren {

    public static String verschlüsseln(String pText, String pSchluessel) {
        String schluessel = pSchluessel;
        String neuschluessel = "";
        String geheim = "";
        int zahlwert;
        int schluessellaenge = schluessel.length();
        char zeichen, schluesselzeichen;
        int i = 0;
        while(i < pText.length()) {
            zeichen = pText.charAt(i);
            zahlwert = (int) zeichen;
            schluesselzeichen = schluessel.charAt(i % schluessellaenge);
            neuschluessel = schluesselzeichen + neuschluessel;
            zahlwert = zahlwert + (int) schluesselzeichen - 32;
            if(zahlwert > 126) {
                zahlwert = zahlwert - 95;
            }
            zeichen = (char) zahlwert;
            geheim = geheim + zeichen;
            i = i+1;
            if(i % schluessellaenge == 0) {
                schluessel = neuschluessel;
                neuschluessel = "";
            }
        }
        return geheim;
    }
}
