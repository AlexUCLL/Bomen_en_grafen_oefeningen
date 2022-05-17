import java.util.ArrayList;
import java.util.List;

public class Recursie {


    // Oefening 1: n-de Fibonacci-getal

    public static int fibonacci(int getal) {
        if(getal < 0 ) throw new IllegalArgumentException();
        if (getal == 1 ) return 1;
        if(getal == 2) return 1;
        return fibonacci(getal - 1) + fibonacci(getal -2);
    }

    // Oefening 2 : som van cijfers

    public static int somVanCijfers(int getal) {
        if (getal < 0) {
            getal = getal * -1;
        }
        if (getal == 0) {
            return 0;
        }
        int eerste = getal%10;
        int rest = getal/10;
        return eerste + somVanCijfers(rest);
    }

    // Oefening 3: keer een string om
    public static String keerOm(String s) {
        if(s == null ) throw new IllegalArgumentException();
        if(s.length()<=1) return s;
        return keerOm(s.substring(1)) + s.charAt(0);
    }

    //oefening 4: countX

    public static int countX(String s) {
        if (s == null) {
            throw new IllegalArgumentException("String cannot be null");
        }
        int getal = 0;
        if (s.length() == 0) {
            return 0;
        }
        String lastChar = s.substring(s.length()-1);
        String rest = s.substring(0,s.length()-1);
        if (lastChar.equals("x")) {
            getal += 1;
        }
        return getal + countX(rest);
    }

    //oefening 5 : countHi
    public static int countHi(String s) {
        if(s==null){throw new IllegalArgumentException("Mag niet leeg zijn");}
        if(s.isBlank() || s.isEmpty() || s.length()==1){return 0;}
        int getal = 0;
        if(s.endsWith("hi")){getal+=1;}
        return getal + countHi(s.substring(0,s.length()-1));
    }

    // oefening 6
    public static String changeXY(String s) {
        if (s == null) {
            throw new IllegalArgumentException("String cannor be null");
        }
        if (s.length() == 1) {
            if (s.equals("x")) {
                return "y";
            }
            else {
                return s;
            }
        }
        String firstChar = s.substring(0,1);
        String rest = s.substring(1,s.length());
        if (firstChar.equals("x")) {
            firstChar = "y";
        }
        return firstChar + changeXY(rest);
    }

    // oefening 7

    public static String changePi(String s) {
        if (s == null) throw new IllegalArgumentException();
        if (s.length() <= 1) {
            return s;
        }

        // if the first character is 'p'
        // and the first character of the part
        // passed to recursion is 'i' then replace
        //"pi" with "3.14"
        if (s.charAt(0) == 'p' && s.length() >= 2
                && s.charAt(1) == 'i') {
            return "3.14" + changePi(s.substring(2, s.length()));
        }

        // if the first character is not 'p'
        // then just put that character in
        // front of the answer which came
        // from recursion
        return s.charAt(0) + changePi(s.substring(1, s.length()));
    }

    // oefening 8:
    public static int tweelog(int getal) {
        if (getal == 1){
            return 0;
        }
        if (getal <= 2) {
            throw new IllegalArgumentException();
        }
        else {
            return 1 + tweelog(getal/2) ;

        }
    }

    // oefening 9;
    public static double findMaximum(List<Double> lijst) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // oefening 10;
    public static ArrayList<String> findSubstrings(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // oefening 11;
    public static int aantalKaarten(int n){
        throw new UnsupportedOperationException("Not yet implemented");
    }

}