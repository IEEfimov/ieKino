package Model;

public class Place {
    public char modificator = 'F';
    public int num = 0;

    public Place(char modificator, int num) {
        this.modificator = modificator;
        this.num = num;
    }

    public char getModificator() {
        return modificator;
    }

    public int getNum() {
        return num;
    }
}
