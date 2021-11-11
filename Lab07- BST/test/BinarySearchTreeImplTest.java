
import static org.junit.Assert.assertEquals;

import bst.BinarySearchTreeImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Testing our binary search tree implementation.
 * 
 * @author Anush
 *
 */
public class BinarySearchTreeImplTest {

  private BinarySearchTreeImpl<Integer> intTree;
  
  /**
   * Setting up the BinartSearchTree.
   */
  @Before
  public void setUp() {
    intTree = new BinarySearchTreeImpl<>();
    intTree.add(8);
    intTree.add(1);
    intTree.add(4);
    intTree.add(3);
    intTree.add(6);
    intTree.add(2);
    intTree.add(9);
  }
  
  @Test
  public void testAdd() {
    BinarySearchTreeImpl<Integer> sampleTree = new BinarySearchTreeImpl<>();
    sampleTree.add(2);
    sampleTree.add(4);
    sampleTree.add(1);
    sampleTree.add(3);
    int expected = 4;
    assertEquals(expected, sampleTree.size());
  }

  @Test
  public void testAddEmpty() {
    BinarySearchTreeImpl<Integer> sampleTree = new BinarySearchTreeImpl<>();
    assertEquals(0,sampleTree.size());
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testAddNull() {
    BinarySearchTreeImpl<Integer> sampleTree = new BinarySearchTreeImpl<>();
    sampleTree.add(null);
  }
  
  @Test
  public void testSize() {
    assertEquals(7, intTree.size());
  }
  
  @Test 
  public void testEmptySize() {
    BinarySearchTreeImpl<Integer> sampleTree = new BinarySearchTreeImpl<>();
    assertEquals(0,sampleTree.size());
  }
  
  @Test 
  public void testHeight() {
    assertEquals(5,intTree.height());
  }
  
  @Test 
  public void testEmptyHeight() {
    BinarySearchTreeImpl<Integer> sampleTree = new BinarySearchTreeImpl<>();
    assertEquals(0,sampleTree.height());
  }
  
  @Test
  public void testPresent() {
    assertEquals(true, intTree.present(3));
  }
  
  @Test
  public void testNotPresent() {
    assertEquals(false, intTree.present(15));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPresentNull() {
    BinarySearchTreeImpl<Integer> sampleTree = new BinarySearchTreeImpl<>();
    sampleTree.add(3);
    sampleTree.present(null);
  }
  
  @Test
  public void testMinimum() {
    int expected = 1;
    int min = intTree.minimum();
    assertEquals(expected, min);
  }
  
  @Test
  public void testMinimumNull() {
    BinarySearchTreeImpl<Integer> sampleTree = new BinarySearchTreeImpl<>();
    assertEquals(null, sampleTree.minimum());
  }
  
  @Test
  public void testMaximum() {
    int expected = 9;
    int max = intTree.maximum();
    assertEquals(expected, max);
  }
  
  @Test
  public void testMaximumNull() {
    BinarySearchTreeImpl<Integer> sampleTree = new BinarySearchTreeImpl<>();
    assertEquals(null, sampleTree.maximum());
  }
  
  @Test
  public void testInOrder() {
    String expected = "[1 2 3 4 6 8 9]";
    assertEquals(expected, intTree.inOrder());
  }
  
  @Test
  public void testPreOrder() {
    String expected = "[8 1 4 3 2 6 9]";
    assertEquals(expected, intTree.preOrder());
  }
  
  @Test
  public void testPostOrder() {
    String expected = "[2 3 6 4 1 9 8]";
    assertEquals(expected, intTree.postOrder());
  }
  
  @Test 
  public void testEmptyTreeOrder() {
    BinarySearchTreeImpl<Integer> sampleTree = new BinarySearchTreeImpl<>();
    assertEquals("[]", sampleTree.preOrder());
    assertEquals("[]", sampleTree.inOrder());
    assertEquals("[]", sampleTree.postOrder());
  }
  
  @Test 
  public void testAddExisiting() {
    BinarySearchTreeImpl<Integer> sampleTree = new BinarySearchTreeImpl<>();
    sampleTree.add(3);
    sampleTree.add(3);
    assertEquals(1,sampleTree.size());
  }
  
  @Test
  public void testLeftHeight() {
    BinarySearchTreeImpl<Integer> sampleTree = new BinarySearchTreeImpl<>();
    sampleTree.add(10);
    sampleTree.add(9);
    sampleTree.add(8);
    sampleTree.add(7);
    sampleTree.add(6);
    sampleTree.add(5);
    sampleTree.add(11);
    sampleTree.add(12);
    assertEquals(6, sampleTree.height());
  }
  
  @Test
  public void testRightHeight() {
    BinarySearchTreeImpl<Integer> sampleTree = new BinarySearchTreeImpl<>();
    sampleTree.add(10);
    sampleTree.add(11);
    sampleTree.add(12);
    sampleTree.add(13);
    sampleTree.add(14);
    sampleTree.add(5);
    sampleTree.add(4);
    assertEquals(5, sampleTree.height());
  }
  
  @Test
  public void testAddEmptyToString() {
    BinarySearchTreeImpl<Integer> sampleTree = new BinarySearchTreeImpl<>();
    assertEquals("[]",sampleTree.toString());
  }
  
  @Test
  public void testAddToEmpty() {
    BinarySearchTreeImpl<Integer> sampleTree = new BinarySearchTreeImpl<>();
    assertEquals(0,sampleTree.size());
    sampleTree.add(3);
    assertEquals(1,sampleTree.size());
  }
  
  @Test
  public void testAddToNonEmpty() {
    BinarySearchTreeImpl<Integer> sampleTree = new BinarySearchTreeImpl<>();
    sampleTree.add(3);
    assertEquals(1,sampleTree.size());
    sampleTree.add(4);
    sampleTree.add(5);
    assertEquals(3,sampleTree.size());
  }
}
