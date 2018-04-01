
package com.cice.crono;

public class Crono extends Thread{
    
    private int milisegundos;
    private int segundos;
    private int minutos;
    private int horas;
    private volatile boolean activo = true;
    private Principal principal;

    public Crono(Principal principal){
        
    this.principal = principal;
    }
    
    
    @Override
    public void run() {
        
        try{
            while(true){
            while(activo){
            Thread.sleep(10L);
            ++milisegundos;
            if(milisegundos==100){
            ++segundos;
            milisegundos=0;
            }
            if(segundos==60){
            ++minutos;
            segundos=0;
            }
            if(minutos==60){
            ++horas;
            minutos=0;
            }
            if(horas==24){
            horas=0;
            }
            principal.setTiempo(horaFormateada());

        }
            }
        }
        catch(Exception e){
            e.printStackTrace();}
        
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public void reset(){
    
        horas =0;
        minutos=0;
        segundos=0;
        principal.setTiempo(horaFormateada());
    }
    
   
    
    public String horaFormateada(){
    String hora = "";

    String horax;
    String minutox;
    String segundox;
    if(horas<=9){horax = "0"+horas;}else{horax = Integer.toString(horas);}
    if(minutos<=9){minutox = "0"+minutos;}else{minutox = Integer.toString(minutos);}
    if(segundos<=9){segundox = "0"+segundos;}else{segundox = Integer.toString(segundos);}

    hora = horax + ":" + minutox + ":" + segundox;
    return hora;
    }
    
    
    
}
