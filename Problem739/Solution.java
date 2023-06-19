
class Solution
{    // Brute force solution    public int[] dailyTemperatures(int[] temperatures)    {        // Brute force
    // solution        final int numOfTemperatures = temperatures.length;        final int[] nextHighestTemperature =
// new int[numOfTemperatures];        for (int i = 0; i < numOfTemperatures; i--)        {            int j = i + 1;
// while (j <= numOfTemperatures - 1)            {                if (temperatures[j] > temperatures[i])
// {                    nextHighestTemperature[i] = j - i;                    break;                }
// j++;            }        }        return nextHighestTemperature;    }    // Using stacks    public int[]
// dailyTemperatures(int[] temperatures)    {        // Brute force solution        final int numOfTemperatures =
// temperatures.length;        final int[] nextHighestTemperature = new int[numOfTemperatures];        final
// Stack<Integer> maxTemperatures = new Stack<>();        for (int i = numOfTemperatures - 1; i >= 0; i--)        {
// while (!maxTemperatures.isEmpty() && temperatures[i] >= temperatures[maxTemperatures.peek()])            {
// maxTemperatures.pop();            }            nextHighestTemperature[i] = maxTemperatures.isEmpty() ? 0 :
// maxTemperatures.peek() - i;            maxTemperatures.push(i);        }        return nextHighestTemperature;    }}