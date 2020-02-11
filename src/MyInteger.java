public class MyInteger {
    private int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public MyInteger increment(){
        value+=1;
        return this;
    }

    public MyInteger setValueToZero(){
        value=0;
        return this;
    }
}
