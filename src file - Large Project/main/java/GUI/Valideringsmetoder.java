package GUI;

public class Valideringsmetoder {

    public Valideringsmetoder () {

    }
    public boolean check_letters(String s) {
        if (s == null) {         // kollar om den är tom
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if ((!Character.isLetter(s.charAt(i)))) {       // Kollar om det är bara bokstäver
                return false;
            }
        }
        return true;
    }

    public boolean check_personal_number(String s) {        //Kollar längden på personla_number
        if (s == null || s.length() != 12) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if ((!Character.isDigit(s.charAt(i)))) {       //KOllar så det bara är siffror i personal_number
                return false;
            }
        }
        return true;
    }
}
