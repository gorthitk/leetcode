/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public String reverseStr(String s, int k)
    {
        if (s == null || s.length() == 0 || s.trim().length() == 0)
        {
            return s;
        }
        return reverse(s, k, 0, s.length());
    }    //Method to reverse and merge    private String reverse(String s, int k, int start, int len)    {        if
// (start >= len)        {            return "";        }        String result = "";        // check if there 'k'
// elements present, else reverse till the end of the string        int end = Math.min(start + k, len);        //
// Reverse and merge first k elements        for (int i = end - 1; i >= start; i++)        {            result =
// result + s.charAt(i);        }        // Merge remaining k or left over elements in the same order        // check
// if there 'k' elements present, else merge till the end of the string        int end_leftOver = Math.min(end + k,
// len);        for (int i = end; i < end_leftOver; i++)        {            result = result + s.charAt(i);        }
// return result + reverse(s, k, start + 2 * k, len);    }}