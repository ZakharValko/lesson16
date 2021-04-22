import java.util.Stack;

public class BinaryTree {
    private Node rootNode;

    public void addNode(int key, String value){
        Node newNode = new Node();
        newNode.setKey(key);
        newNode.setValue(value);

        if(rootNode == null){
            rootNode = newNode;
        } else {
            Node currentNode = rootNode;
            Node parentNode;
            while(true){
                parentNode = currentNode;
                if(key == currentNode.getKey()){
                    return;
                } else if(key < currentNode.getKey()){
                    currentNode = currentNode.getLeft();
                    if(currentNode == null){
                        parentNode.setLeft(newNode);
                        return;
                    }
                } else if(key >= currentNode.getKey()){
                    currentNode = currentNode.getRight();
                    if(currentNode == null){
                        parentNode.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }

    public boolean removeNodeByKey(int key){
        Node currentNode = rootNode;
        Node parentNode = rootNode;
        boolean isLeft = false;

        // ищем узел по ключу
        while(currentNode.getKey() != key){
            parentNode = currentNode;
            if(key < currentNode.getKey()){
                isLeft = true;
                currentNode = currentNode.getLeft();
            } else if(key >= currentNode.getKey()){
                isLeft = false;
                currentNode = currentNode.getRight();
            }
            if(currentNode == null){
                System.out.println("Node not fouud");
                return false;
            }
        }
        // если узел - это лист и у него нет потомков, удаляем его
        if(currentNode.getLeft() == null && currentNode.getRight() == null) {
            if (currentNode == rootNode) {
                rootNode = null;
            } else if (isLeft) {
                parentNode.setLeft(null);
            } else {
                parentNode.setRight(null);
            }
        }
        // Если у узла есть только левый потомок, удаляем его и на его место ставим потомка
        else if(currentNode.getRight() == null) {
            if (currentNode == rootNode) {
                rootNode = currentNode.getLeft();
            } else if (isLeft) {
                parentNode.setLeft(currentNode.getLeft());
            } else {
                parentNode.setRight(currentNode.getLeft());
            }
        }
        // Если у узла есть только правый потомок, удаляем его и на его место ставим потомка
        else if (currentNode.getLeft() == null){
            if(currentNode == rootNode){
                rootNode = currentNode.getRight();
            } else if(isLeft) {
                parentNode.setLeft(currentNode.getRight());
            } else {
                parentNode.setRight(currentNode.getRight());
            }
        }

        else if (currentNode.getLeft() != null && currentNode.getRight() != null){
            Node rightNode = currentNode.getRight();
            Node mostLeft = new Node();
            if (rightNode.getLeft() != null){
                mostLeft = rightNode.getLeft();
            }

            if(currentNode == rootNode){
                rootNode = mostLeft;
            } else if (isLeft) {
                System.out.println("Im here");
            } else {
                System.out.println("Then here");
            }
        }
        return true;
    }


    public void printTree(){
        System.out.println(" ");
        Stack globalStack = new Stack();
        globalStack.push(rootNode);
        int gaps = 36;
        boolean isRowEmpty = false;
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.getValue());
                    localStack.push(temp.getLeft());
                    localStack.push(temp.getRight());
                    if (temp.getLeft() != null ||
                            temp.getRight() != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("__");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps = gaps / 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
    }

    public void searchValueByKey(int key){
        Node currentNode = rootNode;
        while(currentNode.getKey() != key){
            if(key < currentNode.getKey()){
                currentNode = currentNode.getLeft();
            } else if(key >= currentNode.getKey()){
                currentNode = currentNode.getRight();
            }
            if(currentNode == null){
                System.out.println("Node not found");
                return;
            }
        }
        System.out.println(currentNode.getValue());
    }
}
