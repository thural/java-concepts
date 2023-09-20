package enums;

public enum DisplaySizes {
    SD{
        @Override
        public String toString(){
            return "480p";
        }
    },
    HD {
        @Override
        public String toString() {
            return "720p";
        }
    },
    FullHD {
        @Override
        public String toString() {
            return "1080p";
        }
    }
}
