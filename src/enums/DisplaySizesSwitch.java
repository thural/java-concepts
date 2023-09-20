package enums;

// enum sample using switch
public enum DisplaySizesSwitch {
    SD,
    HD,
    FullHD,
    UltraHD;

    public String getSize(){
        switch(this){
            case SD:
                return "480p";
            case HD:
                return "720p";
            case FullHD:
                return "1080p";
            case UltraHD:
                return "1440p";
            default:
                return null;
        }
    }
}
