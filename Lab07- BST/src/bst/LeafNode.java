package bst;

import java.util.List;

/**
 * This a node that signifies the end of a particular path.
 * It implements the Node interface.
 * 
 * @author Anush
 *
 * @param <T> The type of data in the node.
 */
public class LeafNode<T extends Comparable<T>> implements Node<T> {

  @Override
  public Node<T> add(T data) {
    return new NodeImpl<>(data, this, this);
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public int height() {
    return 0;
  }

  @Override
  public boolean present(T data) {
    return false;
  }

  @Override
  public T minimum() {
    return null;
  }

  @Override
  public T maximum() {
    return null;
  }

  @Override
  public List<T> preOrder(List<T> orderList) {
    return orderList;
  }

  @Override
  public List<T> inOrder(List<T> orderList) {
    return orderList;
  }

  @Override
  public List<T> postOrder(List<T> orderList) {
    return orderList;
  }

}
