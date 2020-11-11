package UI;

import java.util.Scanner;
public class Input {

    public static String getString(String question) {
        System.out.print(question);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String getMinutesToTimeFormat(int minutes){
        String hoursText =  String.valueOf(minutes / 60);
        String minutesText = String.valueOf(minutes % 60);
        return hoursText + "." + minutesText;
    }

    // Kan indlæse på formatet: 15.30
    public static int getTimeInMinutes(String question){
        while (true) {
            System.out.print(question);
            Scanner scanner = new Scanner(System.in);
            String timeAsString = scanner.nextLine();
            String[] strings = timeAsString.split("\\.");
            try {
                int hoursInMinutes = Integer.parseInt(strings[0]) * 60;
                int minutes = Integer.parseInt(strings[1]);
                return hoursInMinutes + minutes;
            } catch(NumberFormatException e)  {
                System.out.println("Fejl i tidsformat. Det skal være på formen hh.mm");
            } catch (IndexOutOfBoundsException e ) {
                System.out.println("Du mangler et punktum!");
            } catch (Exception e){
                System.out.println("Last resort");
            }
        }
    }

    public static int getInt(String question) {
        while (true) {
            try {
                // hvis konverterinngen lykkedes så returnere vi. Hvis det ikke lykkedes
                // så smides der er fejl og gribes af min catch og løkken køre igenn.
                return Integer.parseInt(Input.getString(question));
            } catch (Exception e) {
                System.out.println("det må ikke være et tal ord");
            }
        }
    }


    private static int[] textToInts(String s) {
        String[] strings = s.split(" ");
        int[] ints = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            try {
                ints[i] = Integer.parseInt(strings[i]);
            } catch (NumberFormatException e) {
                ints[i] = Input.getInt(strings[i] + " er ikke et tal , skriv et ny tal : ");
            }
        }
        return ints;
    }

    private static String replaceSpace(String s) {
        while (s.contains("  ")) {
            s = s.replace("  ", " ");
        }
        return s;
    }

}






