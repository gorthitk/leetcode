import (
	"math"
)
func isValidBST(root *TreeNode) bool {
    if root == nil {
    	return true;
    }
    var MaxInt64  int = 1<<63 - 1
    var MinInt64 int = -1 << 63
    return isValid(root, MaxInt64, MinInt64); 
}

func isValid(p *TreeNode, max int, min int) bool{
	if p == nil {
		return true;
	}
	if p.Val <= min || p.Val >= max {
		return false;
	}
	
	return isValid(p.Left, p.Val, min) && isValid(p.Right, max, p.Val); 
}
