package com.safetyGame.back;

import java.net.*;
import java.io.*;

public class LeggiBrowser {
    public static void main(String[] args) throws Exception {

        URL oracle = new URL("http://basi.maggiolo.net/prova.php?prova=ciao");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}