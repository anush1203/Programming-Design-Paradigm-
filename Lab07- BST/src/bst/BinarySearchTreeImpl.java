package bst;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementing the binary search tree using generic class and recursive unions.
 * Provides operations such as add, size, height, to check if an element is present
 * to order it. 
 * 
 * @author Anush
 *
 * @param <T> Type of element. It can be a tree of numbers, strings.
 */
public class BinarySearchTreeImpl<T extends Comparable<T>> implements BinarySearchTree<T> {

  private Node<T> root;
  
  /**
   * Creating the root. 
   * Initially it is empty.
   */
  public BinarySearchTreeImpl() {
    root = new LeafNode<T>();
  }

  @Override
  public void add(T data) {
    root = root.add(data);
  }

  @Override
  public int size() {
    return root.size();
  }

  @Override
  public int height() {
    return root.height();
  }

  @Override
  public boolean present(T data) {
    return root.present(data);
  }

  @Override
  public T minimum() {
    return root.minimum();
  }

  @Override
  public T maximum() {
    return root.maximum();
  }

  @Override
  public String preOrder() {
    List<T> oList = new LinkedList<>();
    List<T> preOrderList = root.preOrder(oList);
    return preOrderList.toString().replaceAll(",", "");
  }

  @Override
  public String inOrder() {
    List<T> oList = new LinkedList<>();
    List<T> inOrderList = root.inOrder(oList);
    return inOrderList.toString().replaceAll(",", "");
 
  }

  @Override
  public String postOrder() {
    List<T> oList = new LinkedList<>();
    List<T> postOrderList = root.postOrder(oList);
    return postOrderList.toString().replaceAll(",", "");
  }

  @Override
  public String toString() {
    String printL = "";
    List<T> inOrderList = new LinkedList<>();
    List<T> eList = root.inOrder(inOrderList);
    StringBuilder sb = new StringBuilder();
    if (eList == null) {
      throw new IllegalArgumentException("Null values are not accepted");
    }
    else {
      sb.append("[");
      for (T e : eList) {
        printL = String.format(e + " ");
        sb.append(printL);
      }
      return sb.toString().trim() + "]";
    }
  } 
}
