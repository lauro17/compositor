package Util;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Mouse CLASE QUE ABRE LA PAGINA DE DESCARGA DE JAVA
 */
public class Atualizacao {

    /**
     *
     * @return o status da conexão
     */
    public static boolean verificaConexao() {
        try {
            URL url = new URL("https://raw.githubusercontent.com/lauro17/compositor/master/Version.txt");
            URLConnection con = url.openConnection();
            con.connect();
            return true;
        } catch (MalformedURLException ex) {
            Logger.getLogger(Atualizacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Atualizacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
        
    }

    /**
     *
     * @return a nova versão
     */
    public static String obtemVersao() {
        try {
            URL url = new URL("https://raw.githubusercontent.com/lauro17/compositor/master/Version.txt");
            URLConnection con = url.openConnection();
            con.connect();
            return obterConteudo(url);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Atualizacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Atualizacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    public static String obterConteudo(URL url) {
        try {
            Scanner s = new Scanner(url.openStream()).useDelimiter("\\Z");
            String conteudo = s.next();
            return conteudo;
        } catch (IOException ex) {
            Logger.getLogger(Atualizacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

    /**
     * re
     *
     * @param url
     */
    public static void abrirLigacao(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(Atualizacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
