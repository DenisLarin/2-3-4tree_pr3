/**
 * Created by denis__larin on 07.05.17.
 */
public class Main {
    public static void main(String[] args) {
        TwoThreeFourTree twoThreeFourTree = new TwoThreeFourTree();
        for (int i = 0; i <=10; i++) {
            twoThreeFourTree.insert(i);
        }
        twoThreeFourTree.printtree();
    }
}
