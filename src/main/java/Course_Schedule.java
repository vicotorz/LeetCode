import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode-207
 */
public class Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new List[numCourses];
        for(int i=0;i<numCourses;i++) {
            adj[i] = new ArrayList<Integer>();
        }

        int[] indegree = new int[numCourses];

        for(int i=0;i<prerequisites.length;i++) {
            int curCourse = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            adj[preCourse].add(curCourse);//构建临街链表
            indegree[curCourse]++;//入度加1
        }
        //把入度为0的点放入队列中
        Queue<Integer> readyCourses = new LinkedList();
        for(int i=0;i<numCourses;i++) {
            if(indegree[i]==0) {readyCourses.offer(i);}
        }

        int finishCount = 0;
        while(!readyCourses.isEmpty()) {
            int course = readyCourses.poll();
            finishCount++;
            for(int nextCourse:adj[course]) {
                indegree[nextCourse]--;
                if(indegree[nextCourse] == 0) {readyCourses.offer(nextCourse);}
            }
        }
        return finishCount == numCourses;
    }
}
