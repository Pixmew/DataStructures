public class DynamicArray <T>{

  private T[] arr;
  private int len;
  private int capacity;

  //sets initial Capacity for the List if not Provided
  public DynamicArray(){ this(16); }
  //sets the size of List with the given Capacity provided
  public DynamicArray(int capacity){
    if (capacity <= 0) throw new IllegalArgumentError("illegal Capacity " + capacity);
    this.capacity = capacity;
    this.len = 0;
    arr = (T[]) new Object[capacity];
  }

  //
  private T[] doubleCapacity(){
    if (capacity == 0) capacity = 1;
    capacity *= 2;
    T[] new_arr = (T[]) new Object[capacity];
    for(int i = 0 ; i < len ; i++){
      new_arr[i] = arr[i];
    }
    return new_arr;
  }

  //takes element as an argument and then adds this element to last of the List
  public void add(T elem){
    //double doubles the capacity of len is necessary
    if (len >= capacity) arr = doubleCapacity();
    arr[len + 1] = elem;
    len += 1;
  }
  //takes element and the respective index to which the element to add
  public void add(T elem , int index){
    if (len <= capacity) arr = doubleCapacity();
    for (int i = len-1 ; i >= 0 ; i--){
      arr[i + 1] = arr[i];
      if (i == index){arr[i] = elem; break;};
    }
    len += 1;
  }

  //clears the List and starts with new List of size 16
  public void clear() {
    for(int i =0 ; i < len ;i++){
      arr[i] = null;
    }
  }
  //returns the size of List which usedr thinks
  public int size() { return len;}

  public boolean isEmpty() {return size() == 0;}

  //removes the element Provided if present
  public void remove(T elem){
    int index;
    for (int i = 0 ; i < len ; i++){
      if (arr[i] == elem) index = i;
      else {throw new java.util.NoSuchElementException("No such element " + elem);}
    }
    delete(index);
  }

  //delets the element in the respective index provided
  public void delete(int index){
    for(int i = index ; i < len ; i++){
      arr[i] = arr[i + 1];
    }
    len -= 1;
  }

  //gets element from respective index privided
  public T get(int index){ return arr[index]; }
  //sets the element of a particular index to its new value
  public void set(T elem , int index) { arr[index] = elem;}
}
