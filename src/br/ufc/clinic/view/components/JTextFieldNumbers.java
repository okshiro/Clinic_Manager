package br.ufc.clinic.view.components;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public final class JTextFieldNumbers extends JTextField {
	private static final long serialVersionUID = 1L;
	private int maximoCaracteres=-1;
	public JTextFieldNumbers() {
        super();
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
            	jTextFieldKeyTyped(evt);}});
    }

		public JTextFieldNumbers(int maximo) {    
			super();
			setMaximoCaracteres(maximo);
	  
	        addKeyListener(new java.awt.event.KeyAdapter() {
	            @Override
	            public void keyTyped(java.awt.event.KeyEvent evt) {
	            	jTextFieldKeyTyped(evt);
	            }
	        }
	        );
    	}
  
        private void jTextFieldKeyTyped(KeyEvent evt) {
      
        	String caracteres="0987654321";
			if(!caracteres.contains(evt.getKeyChar()+"")){
			evt.consume();
			}
			if((getText().length()>=getMaximoCaracteres())&&(getMaximoCaracteres()!=-1)){
			evt.consume();
			setText(getText().substring(0,getMaximoCaracteres()));
			}

        }

    public int getMaximoCaracteres() {
        return maximoCaracteres;
    }
    public void setMaximoCaracteres(int maximoCaracteres) {
        this.maximoCaracteres = maximoCaracteres;
    }
}