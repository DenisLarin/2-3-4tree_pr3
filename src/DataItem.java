/**
 * Created by denis__larin on 07.05.17.
 */
public class DataItem {
    private int data;

    public DataItem(int data) {
        this.data = data;
    }

    public void printData(){
        System.out.print("|" + this.data);
    }
    public int getData() {
        return data;
    }
}
