import java.util.*;

public class Codec {
	private static final String STUB = "#";
	private static final String DELIMITER = ",";
	
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		sb.append(root == null ? STUB : root.val).append(DELIMITER);
		sb.append(root == null ? "" : serialize(root.left));
		sb.append(root == null ? "" : serialize(root.right));
		return sb.toString();
	}


	public TreeNode deserialize(String data) {
		Queue<String> queue = new LinkedList<>();
		queue.addAll(Arrays.asList(data.split(DELIMITER)));
		
		return buildTree(queue);
	}

	private TreeNode buildTree(Queue<String> queue) {
		String node = queue.poll();
		if (node.equals(STUB)) return null;
		TreeNode root = new TreeNode(Integer.parseInt(node));
		root.left = buildTree(queue);
		root.right = buildTree(queue);
		return root;
	}
}
