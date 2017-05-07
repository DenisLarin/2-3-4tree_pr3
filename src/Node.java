/**
 * Created by denis__larin on 07.05.17.
 */
public class Node {
    private final int NUMBER = 4;
    private int numberItem;
    private Node parent;
    private Node[] childArray = new Node[NUMBER];
    private DataItem[] itemArray = new DataItem[NUMBER-1];

    //присоединение родителя к ребенку
    public void connectChild(int childNumber, Node child){
        childArray[childNumber] = child;
        if(child!=null){
            child.parent = this;
        }
    }
    //отсоединение элемента от родителя
    public Node disconnectChild(int childNumber){
        Node tempNode = childArray[childNumber];
        childArray[childNumber] = null;
        return tempNode;
    }
    public Node getParent(){
        return parent;
    }
    public Node getChild(int childNumber){
        return childArray[childNumber];
    }
    public boolean isLeaf(){
        return childArray[0] == null;
    }
    public int getNumberItem() {
        return numberItem;
    }
    public DataItem getItem(int dataIndex){
        return itemArray[dataIndex];
    }
    public boolean isFull(){
        return numberItem == NUMBER - 1;
    }
    public int findItem(int key){
        for (int i=0;i<NUMBER-1;i++){
            if (itemArray[i] == null)
                break;
            else if(itemArray[i].getData() == key)
                return i;
        }
        return -1;
    }
    public int insertItem(DataItem newItem){
        numberItem++;
        int newKey = newItem.getData();
        for(int i = NUMBER-2;i>=0;i--){
            if(itemArray[i] == null)
                continue;
            else{
                int thisKey = itemArray[i].getData();
                if(newKey<thisKey)
                    itemArray[i+1] = itemArray[i];
                else{
                    itemArray[i+1] = newItem;
                    return i+1;
                }
            }
        }
        itemArray[0] = newItem;
        return 0;
    }
    public DataItem removeLastItem(){
        DataItem temp = itemArray[numberItem-1];
        itemArray[numberItem-1] = null;
        numberItem--;
        return temp;
    }
    public void printNode(){
        for (int i = 0; i < numberItem; i++) {
            itemArray[i].printData();
        }
        System.out.println("|");
    }
}
