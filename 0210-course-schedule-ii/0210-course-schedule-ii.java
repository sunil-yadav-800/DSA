class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++)
        {
           adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        return isTopoSortPossible(numCourses,indegree,adj);
    }
    public int[] isTopoSortPossible(int numCourses, int[] indegree, List<List<Integer>> adj)
    {
        Queue<Integer> q = new LinkedList<>();
        for(int courses=0;courses<numCourses;courses++)
        {
            if(indegree[courses]==0)
            {
                q.add(courses);
            }
        }
        int[] ans = new int[numCourses];
        int count=0;
        while(!q.isEmpty())
        {
            int c = q.poll();
            ans[count]=c;
            count++;
            for(int adjc: adj.get(c))
            {
                indegree[adjc]--;
                if(indegree[adjc]==0)
                {
                    q.add(adjc);
                }
            }
        }
        return numCourses == count ? ans : new int[]{};
    }
}