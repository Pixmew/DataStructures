public class Stack <T>{

  private T[] stack;
  public int len = -1;
  public int capacity;

  public Stack(int capacity){
    this.capacity = capacity;
    stack =(T[]) new Object[capacity];
  }

  public void push(T ele){
    this.len += 1;
    if(isFull()){throw new ArrayIndexOutOfBoundsException(":Stack is Full");}
    this.stack[this.len] = ele;
  }

  public void pop(){
    if(isEmpty()){throw new java.util.EmptyStackException();}
    this.stack[this.len] = null;
    this.len -= 1;
  }

  public boolean isEmpty(){if(this.len < 0){return true;}else{return false;}}
  public boolean isFull(){if(this.len >= this.capacity){return true;}else{return false;}}
}
