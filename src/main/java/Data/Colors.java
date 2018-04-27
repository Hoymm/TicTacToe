package Data;

public enum Colors {
    DEFAULT("\u001B[0m"),
    INACTIVE("\u001B[0m"),
    ACTIVE("\u001B[32m"),
    RED("\u001B[31m"),
    BLUE("\u001B[34m");

    String color;
    Colors(String color){
        this.color = color;
    }

    @Override
    public String toString(){
        return color;
    }
}
