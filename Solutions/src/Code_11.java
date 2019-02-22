public class Code_11 {


    public static void main(String[] args) {
        Code_11 c = new Code_11();
        int[] heights = new int[] {76,155,15,188,180,154,84,34,187,142,22,5,27,183,111,128,50,58,2,112,179,2,100,111,115,76,134,120,118,103,31,146,58,198,134,38,104,170,25,92,112,199,49,140,135,160,20,185,171,23,98,150,177,198,61,92,26,147,164,144,51,196,42,109,194,177,100,99,99,125,143,12,76,192,152,11,152,124,197,123,147,95,73,124,45,86,168,24,34,133,120,85,81,163,146,75,92,198,126,191};

        int palindrome = c.maxArea(heights);
        System.out.println(palindrome);
    }

    int biggestArea = 0;
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;

        while (l < r) {
            int currentArea = Math.min(height[l], height[r]) * (r - l);
            biggestArea = Math.max(biggestArea, currentArea);

            if (height[l] < height[r]) {
                l ++;
            } else {
                r --;
            }

        }
        return biggestArea;
    }

}
