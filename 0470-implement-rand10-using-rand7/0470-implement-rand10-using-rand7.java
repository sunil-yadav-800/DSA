/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int result =  rand7()+(rand7()-1)*7;
        while(result>40)
        {
            result = rand7()+(rand7()-1)*7;
        }
        return result%10+1;
    }
}