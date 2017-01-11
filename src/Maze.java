import java.util.LinkedList;
import java.util.Queue;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Maze
{
    // use to get next position in maze
    public static int rowSteps[] = {-1, 0, 0, 1};
    public static int colSteps[] = {0, -1, 1, 0};

    //cordinates of matrix cell
    static class Point
    {
        int x;
        int y;
        public Point(){}
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    // store cell and distance from source
    static class QueueNode
    {
        Point location;  //location of cell
        int dist;  //disctance from source to cell
        public QueueNode(){}
        public QueueNode(Point newLocation, int dist){
            this.location = new Point(newLocation.x,newLocation.y);
            this.dist = dist;
        }
    }

    // check position insize the maze or not
    public static boolean isInMaze(int row, int col, int ROW, int COL)
    {
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL);
    }
    // find shortest path's step from src to dest
    public static int BreadthFirstSearch(int[][] mat,int rowNums, int colNums, Point srcPt, Point destPt)
    {
        // check source and destination cell is blocked or not
        if (mat[srcPt.x][srcPt.y] != 0 || mat[destPt.x][destPt.y] != 0)
            return -1;

        boolean[][] visited = new boolean[rowNums][colNums];

        // begin from source cell
        visited[srcPt.x][srcPt.y] = true;

        // Create a queue for storing steps
        Queue<QueueNode> queue = new LinkedList<QueueNode>();

        // initialize distance of source cell
        QueueNode source = new QueueNode(srcPt, 0);
        queue.add(source);

        // bfs from source
        while (!queue.isEmpty())
        {
            QueueNode curr = queue.peek();
            Point currentPosition = curr.location;

            // return shortest step if reach destination
            if (currentPosition.x == destPt.x && currentPosition.y == destPt.y)
                return curr.dist;

            // Otherwise continue with adjunction cell
            queue.poll();

            for (int i = 0; i < 4; i++)
            {
                int row = currentPosition.x + rowSteps[i];
                int col = currentPosition.y + colSteps[i];

                // mark cell as visted if has path and add this cell to queue
                if (isInMaze(row, col, rowNums, colNums) && mat[row][col] == 0 &&
                        !visited[row][col])
                {
                    // mark cell as visited and enqueue it
                    visited[row][col] = true;
                    QueueNode nextCell = new QueueNode(new Point(row, col), curr.dist + 1 );
                    queue.add(nextCell);
                }
            }
        }
        //destination cannot be reached
        return -1;
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int findMinNumSteps(int[][] maze, int rows, int columns, int exitRow, int exitCol)
    {
        // WRITE YOUR CODE HERE
        Point src = new Point(0, 0);
        Point dest = new Point(exitRow,exitCol);
        return BreadthFirstSearch(maze,rows,columns,src,dest);
    }
    // METHOD SIGNATURE ENDS
}