package CesarChiffre;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static String input = "";

    private static char[] message;
    private static int key = -1;

    private static boolean decrypt = true;


    private static Alphabet a = new Alphabet();

    public static void main(String[] args) {
        System.out.println("Möchten Sie eine Nachicht Verschlüsseln? [y/n]");
        decrypt = sc.nextLine().equalsIgnoreCase("y");
        if(!decrypt) {
            System.out.println("Möchten Sie eine Nachicht Entschlüsseln? [y/n]");
            boolean leave = sc.nextLine().equalsIgnoreCase("n");
            if(leave) {
                System.exit(0);
            }
        }

        if(!decrypt) {
            System.out.println("Geben sie eine Nachricht ein: ");
            message = sc.nextLine().replaceAll(" ", "").toLowerCase().toCharArray();

            System.out.println("Um wie viel Zeichen soll die Nachricht verschoben werden?");
            key = sc.nextInt();
            a.setKey(key);


            for (int i = 0; i < message.length; i++) {
                message[i] = a.encryptChar(message[i]);
            }

            System.out.println(String.valueOf(message));
        }else {
            System.out.println("Geben sie eine Nachricht ein: ");
            message = sc.nextLine().replaceAll(" ", "").toLowerCase().toCharArray();

            System.out.println("Bitte geben sie den Key ein: ");
            key = sc.nextInt();
            a.setKey(key);

            for (int i = 0; i < message.length; i++) {
                message[i] = a.decryptChar(message[i]);
            }

            System.out.println(String.valueOf(message));
        }
    }


}
