package enums;

// enum sample with constructors
public enum DisplaySizesConstructors {
    SD("480p"),
    HD("720p"),
    FullHD("1080p");

    private final String size;

    private DisplaySizesConstructors(String size){
        this.size = size;
    }

    public String getSize(){
        return size;
    }
}
