import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeImplTest {


    @Test
    void findTest() {
        BinaryTreeImpl<Integer> btree = new BinaryTreeImpl<>();
        btree.root = new BinaryTreeImpl.Node<Integer>(2);
        btree.root.left = new BinaryTreeImpl.Node<Integer>(1);
        btree.root.right = new BinaryTreeImpl.Node<Integer>(3);
        btree.root.right.right = new BinaryTreeImpl.Node<Integer>(5);
    }

    @Test
    void findNodeTest() {
        BinaryTreeImpl<Integer> btree = new BinaryTreeImpl<>();
        btree.insert(4);
        btree.insert(2);
        btree.insert(6);
        btree.insert(1);
        btree.insert(3);
        btree.insert(5);
        btree.insert(7);
        System.out.println(btree.findNode(btree.root, 4));
    }

    @Test
    void deleteTest() {
        BinaryTreeImpl<Integer> btree = new BinaryTreeImpl<>();
        btree.insert(4);
        btree.insert(2);
        btree.insert(6);
        btree.insert(1);
        btree.insert(3);
        btree.insert(5);
        btree.insert(7);
        System.out.println("================");
        btree.print();
        btree.delete(1);
        System.out.println("================");
        btree.print();
        btree.delete(2);
        System.out.println("================");
        btree.print();
    }

    @Test
    void twoChildDeleteTest() {
        BinaryTreeImpl<Integer> btree = new BinaryTreeImpl<>();
        btree.insert(4);
        btree.insert(2);
        btree.insert(6);
        btree.insert(1);
        btree.insert(3);
        btree.insert(5);
        btree.insert(7);
        System.out.println("================");
        btree.print();
        btree.delete(6);
        System.out.println("================");
        btree.print();
    }

    @Test
    void rootLeaveDeleteTest() {
        BinaryTreeImpl<Integer> btree = new BinaryTreeImpl<>();
        btree.insert(7);
        System.out.println("================");
        btree.print();
        btree.delete(7);
        System.out.println("================");
        btree.print();
    }

    @Test
    void rootSingleBranchDeleteTest() {
        BinaryTreeImpl<Integer> btree = new BinaryTreeImpl<>();
        btree.insert(7);
        btree.insert(8);
        btree.insert(9);
        System.out.println("================");
        btree.print();
        btree.delete(7);
        System.out.println("================");
        btree.print();
    }

    @Test
    void rootTwoBranchDeleteTest() {
        BinaryTreeImpl<Integer> btree = new BinaryTreeImpl<>();
        btree.insert(8);
        btree.insert(9);
        btree.insert(7);
        System.out.println("================");
        btree.print();
        btree.delete(8);
        System.out.println("================");
        btree.print();
    }

    @Test
    void printTest() {
        BinaryTreeImpl<Integer> btree = new BinaryTreeImpl<>();
        btree.insert(4);
        btree.insert(2);
        btree.insert(6);
        btree.insert(1);
        btree.insert(3);
        btree.insert(5);
        btree.insert(7);
        btree.print();
    }

    @Test
    void createTreeTest() {
        BinaryTree<Integer> btree = new BinaryTreeImpl<Integer>(List.of(4,2,6,1,3,5,7));
        btree.print();
    }

    @Test
    void infixOrderTest() {
        BinaryTree<Integer> btree = new BinaryTreeImpl<Integer>(List.of(4,2,6,1,3,5,7));
        List<Integer> list = btree.toInfixList();
        btree.print();
        System.out.println(list);
    }
    @Test
    void prefixOrderTest() {
        BinaryTree<Integer> btree = new BinaryTreeImpl<Integer>(List.of(4,2,6,1,3,5,7));
        List<Integer> list = btree.toPrefixList();
        btree.print();
        System.out.println(list);
    }
    @Test
    void postfixOrderTest() {
        BinaryTree<Integer> btree = new BinaryTreeImpl<Integer>(List.of(4,2,6,1,3,5,7));
        List<Integer> list = btree.toPostfixList();
        btree.print();
        System.out.println(list);
    }

    @Test
    void getSuccessor() {
        BinaryTree<Integer> btree = new BinaryTreeImpl<Integer>(List.of(4,2,6,1,3,5,7));
        btree.print();
        assertEquals(2,btree.getSuccessor(1));
        assertEquals(3,btree.getSuccessor(2));
        assertEquals(4,btree.getSuccessor(3));
        assertEquals(5,btree.getSuccessor(4));
        assertEquals(6,btree.getSuccessor(5));
        assertEquals(7,btree.getSuccessor(6));
    }

    @Test
    void getSuccessor_NotExists() {
        BinaryTree<Integer> btree = new BinaryTreeImpl<Integer>(List.of(4,2,6,1,3,5,7));
        btree.print();
        assertNull(btree.getSuccessor(7));
    }

    @Test
    void getPredecessorTest() {
        BinaryTree<Integer> btree = new BinaryTreeImpl<Integer>(List.of(4,2,6,1,3,5,7));
        btree.print();
        assertEquals(2,btree.getSuccessor(1));
        assertEquals(2,btree.getSuccessor(1));
        assertEquals(3,btree.getSuccessor(2));
        assertEquals(4,btree.getSuccessor(3));
        assertEquals(5,btree.getSuccessor(4));
        assertEquals(6,btree.getSuccessor(5));
        assertEquals(7,btree.getSuccessor(6));
    }
}