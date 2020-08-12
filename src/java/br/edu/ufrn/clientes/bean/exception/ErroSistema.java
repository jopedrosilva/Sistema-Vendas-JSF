package br.edu.ufrn.clientes.bean.exception;

public class ErroSistema extends Exception{
    public ErroSistema(String message){
        super(message);
    }
    
    public ErroSistema(String message, Throwable cause){
        super(message, cause);
    }
}
