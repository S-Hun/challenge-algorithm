class Solution {
public:
    int maxArea(vector<int>& height) {
        int l = 0, r = height.size() - 1;
        int max_area = 0;
        while(l < r)
        {
            max_area = std::max(max_area, std::min(height[l], height[r]) * (r-l));
            if(height[l] < height[r])
            {
                int temp = height[l++];
                while(temp >= height[l])
                {
                    if(l == height.size() - 1) break;
                    l++;
                }
            }
            else
            {
                int temp = height[r--];
                while(temp >= height[r])
                {
                    if(r == 0) break;
                    r--;
                }
            }
        }
        return max_area;
    }
};
