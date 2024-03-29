package Models;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.*;


public class Clients {

    Socket socol;
    DataInputStream entrada;
    DataOutputStream sortida;
    String usuari;


    public Clients(Socket socol, DataInputStream entrada, DataOutputStream sortida, String usuari) {
        this.socol = socol;
        this.entrada = entrada;
        this.sortida = sortida;
        this.usuari = usuari;
    }

    public Clients() {
    }

    public Socket getSocol() {
        return socol;
    }

    public void setSocol(Socket socol) {
        this.socol = socol;
    }

    public DataInputStream getEntrada() {
        return entrada;
    }

    public void setEntrada(DataInputStream entrada) {
        this.entrada = entrada;
    }

    public DataOutputStream getSortida() {
        return sortida;
    }

    public void setSortida(DataOutputStream sortida) {
        this.sortida = sortida;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }


    public Clients connectarClients(String dniClients, TextArea txtArea) throws IOException {
        String verified = "\n Connectat al HOST correctament.";
        String benvinguda = "\n Hola, " + dniClients;

        socol = new Socket(InetAddress.getByName("127.0.0.1"), 12000);
            entrada = new DataInputStream(socol.getInputStream());
            sortida = new DataOutputStream(socol.getOutputStream());
            sortida.flush();
            sortida.writeUTF(dniClients);
            sortida.flush();
            clientRebre clientRebre = new clientRebre(entrada, txtArea);
            Thread filRebre = new Thread(clientRebre);
            Clients user = new Clients(socol, entrada, sortida, dniClients);
            filRebre.start();
        return user;
    }

}
