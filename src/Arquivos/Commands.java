/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos;

import java.io.*;
import java.lang.String;

public class Commands {

    static final Runtime run = Runtime.getRuntime();
    static Process pro;
    static BufferedReader read;

    public static void main(String[] args) {
        String[] cmds = {
            "echo 2",
            "echo 3",
            "echo 4"
        };

        try {
            ProcessBuilder builder = new ProcessBuilder("cmd", "/c",
                    String.join("& ", cmds));

            builder.redirectErrorStream(true);

            Process p = builder.start();

            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;

            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }

                System.out.println(line);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
