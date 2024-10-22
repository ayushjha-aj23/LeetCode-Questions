class RandomizedSet {

    // Method 1: Using ArrayList and Loop - O(N)
    /*
    private ArrayList<Integer> elements;
    private Random random;

    // Constructor to Initialize the object
    public RandomizedSet() {
        elements = new ArrayList<>();
        random = new Random();
    }
    

    // If we insert i.e. add the element then true if already present then false
    public boolean insert(int val) {
        if(elements.contains(val))
            return false;
        
        elements.add(val);
        return true;
    }
    
    // If not present then false and if present then remove and return true
    public boolean remove(int val) {
        if(!elements.contains(val))
            return false;
        
        elements.remove(Integer.valueOf(val)); 
        // Integer.valueOf is used because remove function works with objects 
        return true;
    }
    
    // Give the random value as output
    public int getRandom() {
        return elements.get(random.nextInt(elements.size()));
    }
    */



    // Method 2: Using HashMap - TC - O(1)
    // HashMap for fast access and removal and dynamic array for random access
    // All operations in O(1)


    private List<Integer> elements;
    private HashMap<Integer, Integer> hash;
    private Random random;

    public RandomizedSet() {
        elements = new ArrayList<>();
        hash = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(hash.containsKey(val))
            return false; // Already present
        
        hash.put(val, elements.size());
        elements.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!hash.containsKey(val))
            return false; // Not Present
        
        // Get the index of the element to be removed
        int index = hash.get(val);


        // Move the last element to the position of the element to remove 
        int lastElement = elements.get(elements.size()-1);
        elements.set(index, lastElement);
        hash.put(lastElement, index);


        // Remove the last element
        elements.remove(elements.size()-1);
        hash.remove(val);
        return true;
    }
    
    public int getRandom() {
        return elements.get(random.nextInt(elements.size()));
    }
    
}



/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
