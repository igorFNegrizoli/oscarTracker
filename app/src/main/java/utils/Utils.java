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

    public String duracaoToLongString(Integer duracao){
        String duracao_text = "";
        int horas = duracao/60;
        int minutos_restantes = duracao%60;
        if(horas>=1){
            duracao_text = duracao_text+horas+" hours and ";
        }
        if(minutos_restantes==0){
            duracao_text = duracao_text+"00 minutes";
        }
        else if(minutos_restantes<10){
            duracao_text = duracao_text+"0"+minutos_restantes+" minutes";
        }
        else{
            duracao_text = duracao_text+minutos_restantes+" minutes";
        }
        return duracao_text;
    }

    public String categoryButtonName(String category_name){
        switch (category_name){
            case "Best Picture": return "icon_cinema_clapper";
            case "Actor in a Leading Role": return "icon_male";
            case "Actor in a Supporting Role": return "icon_male";
            case "Actress in a Leading Role": return "icon_female";
            case "Actress in a Supporting Role": return "icon_female";
            case "Directing": return "icon_director_chair";
            case "Writing (Adapted Screenplay)": return "icon_screenplay";
            case "Writing (Original Screenplay)": return "icon_screenplay";
            case "International Feature Film": return "icon_world";
            case "Documentary (Feature)": return "icon_documentary";
            case "Animated Feature Film": return "icon_animation";
            case "Cinematography": return "icon_camera";
            case "Film Editing": return "icon_editing";
            case "Short Film (Animated)": return "icon_animation";
            case "Short Film (Live Action)": return "icon_cinema_clapper";
            case "Documentary (Short Subject)": return "icon_documentary";
            case "Sound": return "icon_sound";
            case "Music (Original Score)": return "icon_music";
            case "Music (Original Song)": return "icon_music";
            case "Production Design": return "icon_production";
            case "Visual Effects": return "icon_visual_effect";
            case "Makeup and Hairstyling": return "icon_hairstyling";
            case "Costume Design": return "icon_costume";
            default: return "";
        }
    }


}
