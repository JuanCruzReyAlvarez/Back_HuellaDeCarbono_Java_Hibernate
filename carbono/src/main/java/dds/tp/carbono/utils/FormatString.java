package dds.tp.carbono.utils;

public class FormatString {

    public static String toLower(String string) {
        return string.toLowerCase();
    }

    public static String sinTildes(String string) {
        return string.replace("á", "a")
                     .replace("é", "e")
                     .replace("í", "i")
                     .replace("ó", "o")
                     .replace("ú", "u");
    }

    public static String sinEspacios(String string) {
        return string.replace(" ", "");
    }
}
