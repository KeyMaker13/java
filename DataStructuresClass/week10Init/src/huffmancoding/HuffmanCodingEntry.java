package huffmancoding;

class HuffmanCodingEntry implements Comparable {
   public static final int SIGN_MASK = 0x80000000;
   public static final int PARENT_MASK = 0x0000ffff;
   private int value;
   private int index;
   private int weight;
   private int parent;
   private int leftChild;
   private int rightChild;
   private boolean childType;

   // Used to directly create a HuffmanCodingEntry
   public HuffmanCodingEntry(int v, int i, int w, int p, boolean c) {
      value = v;
      index = i;
      weight = w;
      parent = p;
      childType = c;
      leftChild = -1;
      rightChild = -1;
   }

   /**  Used to create a HuffmanCodingEntry from an encoded int
     v contains the encoded table entry
     childType - first bit
     value - leading two bytes
     parent - last two bytes
    */

   public HuffmanCodingEntry(int i, int v) {
      index = i; // set the index

      // extract the childType, value, and parent
      int temp = v;
      childType = ( (temp & SIGN_MASK) != 0); // set childType based on sign bit
      temp = temp & (~SIGN_MASK); // make sure the sign bit is 0
      value = temp >> 16; // value is in the most significant two bytes
      short p = (short) (temp & PARENT_MASK); // parent is in the low two bytes
      parent = (int) p;
      weight = 0; // weight is not encoded
      leftChild = -1;
      rightChild = -1;
   }

   // Add w to the weight of this object
   public void addWeight(int w) {
      weight += w;
   }

   public int compareTo(Object rhs) {
      if (weight < ( (HuffmanCodingEntry) rhs).getWeight())
         return -1;
      else if (weight > ( (HuffmanCodingEntry) rhs).getWeight())
         return 1;
      else
         return 0;
   }

   // Encode the entry as an int for embedding in the encoded file
   // format:  childType, value, and parent
   public int encode() {
      int temp = value << 16; // move value to leading two bytes
      temp = temp | (parent & PARENT_MASK); // parent in last two bytes
      if (childType)
         temp = temp | SIGN_MASK; // set the sign bit for right child
      return temp;
   }

   //  Usual accessors
   public int getIndex() {
      return index;
   }

   public int getLeftChild() {
      return leftChild;
   }

   public int getParent() {
      return parent;
   }

   public int getRightChild() {
      return rightChild;
   }

   public int getValue() {
      return value;
   }

   public int getWeight() {
      return weight;
   }

   public boolean isRightChild() {
      return childType;
   }

   //  Usual modifiers
   public void setChildType(boolean c) {
      childType = c;
   }

   public void setIndex(int i) {
      index = i;
   }

   public void setLeftChild(int l) {
      leftChild = l;
   }

   public void setParent(int p) {
      parent = p;
   }

   public void setRightChild(int r) {
      rightChild = r;
   }

   public String toString() {return value + "\t" + index +
         "\t" + weight + "\t"
         + parent + "\t" + childType + "\t" + leftChild + "\t" +
         rightChild;
   }
}
