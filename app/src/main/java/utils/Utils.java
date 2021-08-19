package utils;

public class Utils {
    public Utils() {
    }

    public String duracaoToString(Integer duracao){
        String duracao_text = "";
        int horas = duracao/60;
        int minutos_restantes = duracao%60;
        if(horas>=1){
            duracao_text = duracao_text+horas+"h ";
        }
        if(minutos_restantes==0){
            duracao_text = duracao_text+"00m";
        }
        else if(minutos_restantes<10){
            duracao_text = duracao_text+"0"+minutos_restantes+"m";
        }
        else{
            duracao_text = duracao_text+minutos_restantes+"m";
        }
        return duracao_text;
    }
}
