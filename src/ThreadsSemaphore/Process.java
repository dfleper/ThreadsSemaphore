package ThreadsSemaphore;

import java.awt.Color;
import java.awt.TextField;
import static java.lang.Thread.sleep;
import javax.swing.*;

public class Process implements Runnable {

    public boolean iterar;
    public JButton btnRojo;
    public JButton btnAmarillo;
    public JButton btnVerde;
    public TextField txtTexto;
    public int contador = 0, temp = 0, temp2 = 0, temp3 = 0;

    public Process(JButton entrada1, JButton entrada2, JButton entrada3, TextField entrada4) {
        this.btnRojo = entrada1;
        this.btnAmarillo = entrada2;
        this.btnVerde = entrada3;
        this.txtTexto = entrada4;
    }

    @Override
    public void run() {
        while (iterar) {
            contador++;
            if (contador >= 1 && contador <= 30) {
                temp++;
                txtTexto.setText(" " + temp);
            }
            if (contador == 1) {
                btnRojo.setBackground(Color.red);
                btnAmarillo.setBackground(Color.gray);
                btnVerde.setBackground(Color.gray);
            }
            if (contador >= 30 && contador <= 60) {
                temp2++;
                txtTexto.setText(" " + temp2);
            }
            if (contador == 30) {
                btnRojo.setBackground(Color.gray);
                btnAmarillo.setBackground(Color.gray);
                btnVerde.setBackground(Color.green);
            }
            if (contador >= 60 && contador <= 64) {
                temp3++;
                txtTexto.setText(" " + temp3);
            }
            if (contador == 60) {
                btnRojo.setBackground(Color.gray);
                btnAmarillo.setBackground(Color.yellow);
                btnVerde.setBackground(Color.gray);
            }
            if (contador == 65) {
                contador = 0;
                temp = 0;
                temp2 = 0;
                temp3 = 0;
            }
            try {
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        iterar = true;
        new Thread(this).start();
    }

    public void stop() {
        iterar = false;
    }

    public void restart() {
        contador = 0;
        temp = 0;
        temp2 = 0;
        temp3 = 0;
        txtTexto.setText("");
    }
}
