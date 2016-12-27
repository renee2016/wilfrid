
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class IntegerBinaryTreeTest {
    @Test
    public void should_be_able_to_create_am_empty_tree() throws Exception {

        IntegerBinaryTree binaryTree = new IntegerBinaryTree();
        assertNotNull(binaryTree);

    }

    @Test
    public void should_be_able_to_create_binary_tree_with_elements() throws Exception {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(3);
        IntegerBinaryTree binaryTree = new IntegerBinaryTree(arrayList);

        assertNotNull(binaryTree);
    }

    @Test
    public void should_be_able_to_insert_an_element() throws Exception{
        IntegerBinaryTree binaryTree = new IntegerBinaryTree();
        assertEquals(binaryTree.size(), 0);

        binaryTree.insert(3);
        assertEquals(binaryTree.size(), 1);

    }
}