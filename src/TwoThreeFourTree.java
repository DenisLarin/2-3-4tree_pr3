/**
 * Created by denis__larin on 07.05.17.
 */
public class TwoThreeFourTree {
    private Node root = new Node();
    public int find(int key){
        Node curNode = root;
        int childNumber;
        while (true){
            if((childNumber = curNode.findItem(key))!=-1)
                return childNumber;
            else if(curNode.isLeaf())
                return -1;
            else curNode = getNextChild(curNode,key);
        }
    }
    public void insert(int value){
        Node curNode = root;
        DataItem dataItem = new DataItem(value);
        while (true){
            if(curNode.isFull()){
                split(curNode);
                curNode = curNode.getParent();
                curNode = getNextChild(curNode,value);
            }
            else if (curNode.isLeaf())
                break;
            else
                curNode = getNextChild(curNode,value);
        }
        curNode.insertItem(dataItem);
    }

    private void split(Node thisNode) {
        DataItem itemCentral, itemLast;
        Node parent,child2,child3;
        int itemIndex;
        itemLast = thisNode.removeLastItem();
        itemCentral = thisNode.removeLastItem();
        child2 = thisNode.disconnectChild(2);
        child3 = thisNode.disconnectChild(3);
        Node newRight = new Node();
        if(thisNode == root){
            root = new Node();
            parent = root;
            root.connectChild(0,thisNode);
        }
        else
            parent = thisNode.getParent();

        itemIndex = parent.insertItem(itemCentral);
        int n = parent.getNumberItem();
        for (int i = n-1; i>itemIndex;i--){
            Node temp = parent.disconnectChild(i);
            parent.connectChild(i+1,temp);
        }
        parent.connectChild(itemIndex+1,newRight);
        newRight.insertItem(itemLast);
        newRight.connectChild(0,child2);
        newRight.connectChild(1,child3);
    }

    private Node getNextChild(Node theNode, int key) {
        int i;
        int numItems = theNode.getNumberItem();
        for (i=0;i<numItems;i++){
            if(key<theNode.getItem(i).getData())
                return theNode.getChild(i);
        }
        return theNode.getChild(i);
    }
    public void printtree(){
        printtree(root,0,0);
    }

    private void printtree(Node prtinNode, int level, int childNumber) {
        System.out.print("level = " + level + " child = " + childNumber + " ");
        prtinNode.printNode();

        int numberItem = prtinNode.getNumberItem();
        for (int i = 0; i <numberItem+1; i++) {
            Node next = prtinNode.getChild(i);
            if(next!=null){
                printtree(next,level+1,i);
            }
            else
                return;
        }
    }
}
