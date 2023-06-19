
class Solution
{
    public boolean canReach(int[] arr, int start)
    {
        return _canReach(arr, start, new boolean[arr.length]);
    }

    private boolean _canReach(int[] arr, int start, boolean[] visited)
    {        // if you jump beyond the bounds of the array return false.        if (start < 0 || start >= arr.length)
        //        {            return false;        }        // If you jumped to a point with '0' value return true.
        //        if (arr[start] == 0)        {            return true;        }        // If already visited,
        //        returned false.        if (visited[start])        {            return false;        }
        //        visited[start] = true;        boolean reached = _canReach(arr, start + arr[start], visited)
        //        || _canReach(arr, start - arr[start], visited);        visited[start] = false;        return reached;    }}