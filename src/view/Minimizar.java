package view;

import Min.Tablas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Minimizar extends JFrame {
    private JPanel Min;
    private JTextField txtSimbolos;
    private JTextField txtEstados;
    private JTextField txtTranscripcion;
    private JTextField txtFinal;
    private JButton BtnProceso;
    private JTextArea txtRta;
    private JButton btnLimpiar;

    public Minimizar(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(Min);
        this.pack();
        BtnProceso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sim = txtSimbolos.getText();
                String estado= txtEstados.getText();
                String transcripcion = txtTranscripcion.getText();
                String finalizador = txtFinal.getText();
                String []arreglo = transcripcion.split(",");
                String transcripcionPC="";
                for (int i = 0; i < arreglo.length; i++) {
                    transcripcionPC+=arreglo[i];
                    if((i+1)%sim.split(",").length==0){
                        transcripcionPC+=";";
                    }else{
                        transcripcionPC+=",";
                    }
                }

                Tablas ejemplo = new Tablas(sim, estado, transcripcion,transcripcionPC,finalizador);
                ejemplo.cargarTabla();
                ejemplo.minimizar();
                txtRta.setText(ejemplo.mostrar());

            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtSimbolos.setText("");
                txtEstados.setText("");
                txtTranscripcion.setText("");
                txtFinal.setText("");
                txtRta.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frama = new Minimizar("Minimizar");
        frama.setVisible(true);
    }
}
