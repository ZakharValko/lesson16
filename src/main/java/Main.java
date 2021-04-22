public class Main {
    public static void main(String[] args) {
        BinaryTree myBT = new BinaryTree();
        myBT.addNode(100, "100");
        myBT.addNode(50, "50");
        myBT.addNode(150, "150");
        myBT.addNode(200, "200");
        myBT.addNode(130, "130");
        myBT.addNode(90, "90");
        myBT.addNode(89, "89");
        myBT.addNode(91, "91");
        myBT.addNode(40, "40");
        myBT.addNode(24, "24");
        myBT.addNode(140, "140");
        myBT.addNode(128, "129");
        myBT.addNode(250, "250");
        myBT.addNode(190, "190");
        //myBT.addNode(49, "49");
        myBT.printTree();
        myBT.removeNodeByKey(40);
        myBT.printTree();







    }
}
