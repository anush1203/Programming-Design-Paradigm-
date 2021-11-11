package bst;

import java.util.List;

/**
 * A class that represents elements in a tree. 
 * Each Node is an individual element. 
 * @author anush
 *
 * @param <T> type of data in the node.
 */
public class NodeImpl<T extends Comparable<T>> implements Node<T> {
  
  private Node<T> left;
  private Node<T> right;
  private final T element;

  /**
   * Constructing a Node element.
   * 
   * @param element The element that is being added to the tree.
   * @param left The left part of the tree.
   * @param right The right part of the tree.
   */
  public NodeImpl(T element, Node<T> left, Node<T> right) {
    if (element == null || left == null || right == null) {
      throw new IllegalArgumentException("inputs can not be null");
    }
    this.element = element;
    this.left = left;
    this.right = right;
  }
  
  @Override
  public Node<T> add(T data) {
    if (data == null) {
      throw new IllegalArgumentException("Enter valid inputs.");
    }
    if (element.compareTo(data) < 0) {
      right = right.add(data);
    } 
    else if (element.compareTo(data) > 0) {
      left = left.add(data);
    }
    return this;
  }

  @Override
  public int size() {
    return (left.size() + 1 + right.size());
  }

  @Override
  public int height() {
    int leftHeight = left.height();
    int rightHeight = right.height();
    return 1 + Math.max(leftHeight, rightHeight);
  }

  @Override
  public boolean present(T data) {
    if (data == null) {
      throw new IllegalArgumentException("Enter valid inputs");
    }
    if (element.equals(data)) {
      return true;
    }
    else {
      return ((right.present(data) 
          || (left.present(data))));
    }
  }

  @Override
  public T minimum() {
    T min = this.left.minimum();
    if (min != null) {
      return min;  
    }
    return this.element;
  }

  @Override
  public T maximum() {
    T max = this.right.maximum();
    if (max != null) {
      return max;
    }
    return this.element;
  }

  @Override
  public List<T> preOrder(List<T> orderList) {
    orderList.add(this.element);
    this.left.preOrder(orderList);
    this.right.preOrder(orderList);
    return orderList;
  }

  @Override
  public List<T> inOrder(List<T> orderList) {
    this.left.inOrder(orderList);
    orderList.add(this.element);
    this.right.inOrder(orderList);
    return orderList;
  }

  @Override
  public List<T> postOrder(List<T> orderList) {
    this.left.postOrder(orderList);
    this.right.postOrder(orderList);
    orderList.add(this.element);
    return orderList;
  }

  @Override
  public String toString() {
    return "";
  }
}
