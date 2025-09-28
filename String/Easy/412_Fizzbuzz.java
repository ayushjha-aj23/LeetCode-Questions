
class Solution {

    // Naive Approach
    /*
    public List<String> fizzBuzz(int n) {
        
        ArrayList<String> result = new ArrayList<>();
        for(int i=1; i<=n; i++){

            StringBuilder sb = new StringBuilder();

            // If divisible by 3 and 5 both
            if(i%3==0 && i%5==0){
                sb.append("FizzBuzz");
            }
            // If divisible by 3 and !5
            else if(i%3==0){
                sb.append("Fizz");
            }
            // If divisible by 5 and !3
            else if(i%5==0){
                sb.append("Buzz");
            }
            // Not divisible by 3 and 5 both
            else{
                sb.append(i);
            }

            result.add(sb.toString());
        }
        return result;
    }
    */

    // Better Approach
    /*
    public List<String> fizzBuzz(int n) {
        
        ArrayList<String> result = new ArrayList<>();

        for(int i=1; i<=n; i++){
            String s = "";

            if(i%3==0)
                s += "Fizz";
            
            if(i%5==0)
                s += "Buzz";
            
            if(s.length()==0)
                s += i;
            
            result.add(s.toString());
        }

        return result;
    }
    */

    // Optimised Approach
    public List<String> fizzBuzz(int n) {
        
        ArrayList<String> result = new ArrayList<>();

        // HashMap mapping
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(3, "Fizz");
        hashMap.put(5, "Buzz");

        int[] divisors = {3, 5};

        for(int i=1; i<=n; i++){
            
            StringBuilder sb = new StringBuilder();

            // Check for Divisors
            for(int d:divisors){
                if(i%d==0){
                    sb.append(hashMap.get(d));
                }
            }

            if(sb.length()==0)
                sb.append(i);
            
            result.add(sb.toString());
        }
        return result;
    }

}
