package Models;

import javafx.scene.control.TextArea;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;



public class SendClient implements Runnable {
    private DataOutputStream sortida;
    String usuari;
    String missatge;
    TextArea txtArea;


    public SendClient(DataOutputStream sortida, String usuari, String missatge,TextArea txtArea) {
        this.txtArea = txtArea;
        this.sortida = sortida;
        this.usuari = usuari;
        this.missatge = missatge;
    }

    @Override
    public void run() {

        while (true && !missatge.equals("")) {
            try {
                if (!missatge.equals("Fi")) {
                    txtArea.appendText("\nTu: " + missatge);
                    sortida.writeUTF(usuari + ": "+missatge );
                    sortida.flush();
                    missatge = "";
                } else {
                    sortida.writeUTF(usuari+": "+ missatge);
                    sortida.flush();
                    txtArea.appendText("\n"+usuari + "Ha sortit del xat. ");
                    System.exit(0);
                }
            } catch (IOException ex) {
                Logger.getLogger(clientRebre.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


}
