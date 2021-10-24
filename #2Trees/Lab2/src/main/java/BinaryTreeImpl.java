import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BinaryTreeImpl<T extends Comparable<T>> implements BinaryTree<T> {
    public Node<T> root;

    public BinaryTreeImpl() {
    }

    public BinaryTreeImpl(Iterable<T> arr) {
        for (T t : arr) {
            this.insert(t);
        }
    }

    public BinaryTree<T> createTree(Collection<T> arr) {
        return new BinaryTreeImpl<T>(arr);
    }

    public void insert(T value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        if (contains(value)) {
            System.out.println("Element already exists");
            return;
        }
        insertNode(root, node);
    }

    private void insertNode(Node parentNode, Node newNode) {
        int comparisonResult = parentNode.value.compareTo(newNode.value);
        if (comparisonResult > 0) {
            if (parentNode.left != null) {
                insertNode(parentNode.left, newNode);
            } else {
                parentNode.left = newNode;
                newNode.parent = parentNode;
            }
        } else {
            if (parentNode.right != null) {
                insertNode(parentNode.right, newNode);
            } else {
                parentNode.right = newNode;
                newNode.parent = parentNode;
            }
        }
    }

    public boolean contains(T value) {
        return root != null && contains(root, value);
    }

    private boolean contains(Node<T> node, T value) {
        int comparisonResult = node.value.compareTo(value);
        if (comparisonResult == 0) {
            return true;
        }
        if (comparisonResult > 0 && node.left != null) {
            return contains(node.left, value);
        }
        if (comparisonResult < 0 && node.right != null) {
            return contains(node.right, value);
        }
        return false;
    }

    public void delete(T value) {
        Node<T> nodeToDelete = findNode(root, value);
        deleteNode(nodeToDelete);
    }

    private void deleteNode(Node<T> nodeToDelete) {
        if (nodeToDelete == null) {
            System.out.println("Tree does not contains this element");
            return;
        }
        if (nodeToDelete.right != null && nodeToDelete.left != null) {
            deleteTwoChildBranch(nodeToDelete);
        } else if (nodeToDelete.right != null || nodeToDelete.left != null) {
            deleteSingleChildBranch(nodeToDelete);
        } else {
            deleteLeave(nodeToDelete);
        }
    }

    private void deleteTwoChildBranch(Node<T> nodeToDelete) {
        Node<T> successor = getSuccessorNode(nodeToDelete);
        T temp = nodeToDelete.value;
        nodeToDelete.value = successor.value;
        successor.value = temp;
        deleteNode(successor);
    }

    private Node<T> getSuccessorNode(Node<T> node) {
        Node<T> successor = null;
        if (node.right != null) {
            successor = node.right;
            while (successor.left != null) {
                successor = successor.left;
            }
        } else if (node.parent != null) {
            successor = node.parent;
            while (successor.parent != null && node==successor.right) {
                node = successor;
                successor = successor.parent;
            }
            if(successor==root){
                return null;
            }
        }
        return successor;
    }

    private Node<T> getPredecessorNode(Node<T> node) {
        Node<T> predecessor = null;
        if (node.left != null) {
            predecessor = node.left;
            while (predecessor.left != null) {
                predecessor = predecessor.right;
            }
        } else if (node.parent != null) {
            predecessor = node.parent;
            while (predecessor.parent != null && node==predecessor.left) {
                node = predecessor;
                predecessor = predecessor.parent;
            }
            if(predecessor==root){
                return null;
            }
        }
        return predecessor;
    }

    private void deleteSingleChildBranch(Node<T> nodeToDelete) {
        Node<T> parent = nodeToDelete.parent;
        Node<T> child = nodeToDelete.left != null ? nodeToDelete.left : nodeToDelete.right;
        if (parent == null) {
            root = child;
            child.parent = null;
        } else if (parent.left == nodeToDelete) {
            parent.left = child;
        } else {
            parent.right = child;
        }
        child.parent = parent;
    }

    private void deleteLeave(Node<T> nodeToDelete) {
        Node<T> parent = nodeToDelete.parent;
        if (parent == null) {
            root = null;
        } else if (parent.left == nodeToDelete) {
            parent.left = null;
        } else {
            parent.right = null;
        }
    }

    public Node<T> findNode(Node<T> searchRoot, T value) {
        if (searchRoot == null) {
            return null;
        }
        int comparison = searchRoot.value.compareTo(value);
        if (comparison == 0) {
            return searchRoot;
        } else if (comparison < 0) {
            return findNode(searchRoot.right, value);
        } else {
            return findNode(searchRoot.left, value);
        }
    }

    public static class Node<T extends Comparable<T>> {
        Node<T> parent;
        Node<T> left;
        Node<T> right;
        T value;

        public Node(Node<T> parent, Node<T> left, Node<T> right, T value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public Node(T value) {
            this(null, null, null, value);
        }
    }

    private static final String SPACE = "    ";

    @Override
    public List<T> toInfixList() {
        List<T> values = new ArrayList<>();
        fillInfixOrderedNodes(values, root);
        return values;
    }

    private void fillInfixOrderedNodes(List<T> list, Node<T> currentNode) {
        if (currentNode != null) {
            fillInfixOrderedNodes(list, currentNode.left);
            list.add(currentNode.value);
            fillInfixOrderedNodes(list, currentNode.right);
        }
    }

    @Override
    public List<T> toPrefixList() {
        List<T> values = new ArrayList<>();
        fillPrefixOrderedNodes(values, root);
        return values;
    }

    private void fillPrefixOrderedNodes(List<T> list, Node<T> currentNode) {
        if (currentNode != null) {
            list.add(currentNode.value);
            fillPrefixOrderedNodes(list, currentNode.left);
            fillPrefixOrderedNodes(list, currentNode.right);
        }
    }

    @Override
    public List<T> toPostfixList() {
        List<T> values = new ArrayList<>();
        fillPostfixOrderedNodes(values, root);
        return values;
    }

    private void fillPostfixOrderedNodes(List<T> list, Node<T> currentNode) {
        if (currentNode != null) {
            fillPostfixOrderedNodes(list, currentNode.left);
            fillPostfixOrderedNodes(list, currentNode.right);
            list.add(currentNode.value);
        }
    }

    /**
     *
     * @return successor value if exists, otherwise return null
     */
    @Override
    public T getSuccessor(T val) {
        Node<T> successorNode = getSuccessorNode(findNode(root, val));
        if(successorNode!=null){
            return successorNode.value;
        }
        return null;
    }

    @Override
    public T getPredecessor(T val) {
        Node<T> predecessorNode = getPredecessorNode(findNode(root, val));
        if(predecessorNode!=null){
            return predecessorNode.value;
        }
        return null;
    }

    public void print() {
        printNode(0, root);
    }

    private void printNode(int depth, Node<T> node) {
        if (node == null) {
            return;
        }
        printNode(depth + 1, node.right);
        System.out.println(getIntends(depth) + node.value);
        printNode(depth + 1, node.left);
    }

    private String getIntends(int depth) {
        String intends = "";
        for (int i = 0; i < depth; i++) {
            intends += SPACE;
        }
        return intends;
    }

}
