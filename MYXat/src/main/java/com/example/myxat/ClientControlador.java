package com.example.myxat;

import Models.Clients;
import Models.SendClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.sql.*;
import java.io.IOException;

public class ClientControlador {
    @FXML
    Button btnUsuari, btnEnviar;
    @FXML
    TextField txtUsuari, txtMissatge;
    @FXML
    PasswordField txtContrasenya;
    @FXML
    TextArea txtArea;
    @FXML
    Label lblInfo;
    Clients client1;
    Clients client = new Clients();

    @FXML
    public void sendMessage() {
      String missatge = txtMissatge.getText();
      if(!missatge.equals("")){
          SendClient sc = new SendClient(client1.getSortida(), client1.getUsuari(), missatge,txtArea);
          Thread enviar = new Thread(sc);
          enviar.start();
      }
      txtMissatge.clear();
    }

    public void UsersValidation(ActionEvent actionEvent){
        String dni = txtUsuari.getText();
        String contrasenya= txtContrasenya.getText();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/myxat","root", "");
            String sqlUsuari= "SELECT * FROM usuaris WHERE dni='"+dni+"' AND contrasenya='"+contrasenya+"'";
            PreparedStatement stUser = conexion.prepareStatement(sqlUsuari);
            ResultSet rs = stUser.executeQuery();
            String usuari[] = new String[2];
            while(rs.next()){
                usuari[0]= rs.getString(2);
                usuari[1]= rs.getString(3);
            }
            String userNom= usuari[0]+" "+usuari[1];
            client1 = client.connectarClients(userNom, txtArea);
            lblInfo.setText("Benvingut/da: "+ usuari[0].toString());
            lblInfo.setTextFill(Color.web("#34c759"));
            conexion.close();

        } catch (Exception e)
        {
            lblInfo.setTextFill(Color.web("#ff3b30"));
            lblInfo.setText("ERROR!! " + e);
            txtUsuari.clear();
            txtContrasenya.clear();

        }


    }

    public void ForbiddenWords(){


    }
}
