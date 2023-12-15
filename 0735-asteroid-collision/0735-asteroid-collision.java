class Pair{
    int value;
    char sign;
    public Pair(int value, char sign)
    {
        this.value=value;
        this.sign=sign;
    }
}
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Pair> st = new Stack<>();
        for(int i=0;i<asteroids.length;i++)
        {
            char currSign = asteroids[i]>=0?'+':'-';
            if(!st.isEmpty() && st.peek().sign=='+' && currSign == '-')
            {
                while(!st.isEmpty() && st.peek().sign=='+' && currSign=='-' && st.peek().value<Math.abs(asteroids[i]))
                {
                    st.pop();
                }
                if(!st.isEmpty() && st.peek().sign== '+' && currSign=='-' && st.peek().value==Math.abs(asteroids[i]))
                {
                    st.pop();
                }
                else if(!st.isEmpty() && st.peek().sign=='+' && currSign=='-' && st.peek().value>Math.abs(asteroids[i]))
                {
                    continue;
                }
                else
                {
                    st.push(new Pair(Math.abs(asteroids[i]),currSign));
                }
            }
            else
            {
                 st.push(new Pair(Math.abs(asteroids[i]),currSign));
            }
        }
        int[] ans = new int[st.size()];
        int k=0;
        while(!st.isEmpty())
        {
            if(st.peek().sign == '+')
            {
                ans[k++]=st.peek().value;
            }
            else
            {
                ans[k++]=st.peek().value*-1;
            }
            st.pop();
        }
        reverse(ans);
        return ans;
    }
    public void reverse(int[] arr)
    {
        int start=0;
        int end=arr.length-1;
        while(start<end)
        {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        
    }
}