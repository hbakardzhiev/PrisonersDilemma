public class Tuple<T, E> {
    private T key;
    private E value;
    public Tuple(T key, E value) {
        this.key = key;
        this.value = value;
    }
    public Tuple() {  }
    public T getKey() {
        return key;
    }
    public E getValue() {
        return value;
    }
    public void setKey(T key) {
        this.key = key;
    }
    public void setValue(E value) {
        this.value = value;
    }
}
 class Triple<T, E, F> {
    private T key;
    private E value;
    private F booleanValue;

    public Triple(T key, E value) {
        this.key = key;
        this.value = value;
    }
    public Triple() {  }
    public T getKey() {
        return key;
    }
    public E getValue() {
        return value;
    }

    public F booleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(F booleanValue) {
        this.booleanValue = booleanValue;
    }

    public void setKey(T key) {
        this.key = key;
    }
    public void setValue(E value) {
        this.value = value;
    }
}
