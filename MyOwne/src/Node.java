import java.util.ArrayList;
import java.util.List;

public class Node {
	public int id;
	public List<Node> preNodes = new ArrayList<>();
	public List<Node> nextNodes = new ArrayList<>();

	public Node() {

	}

	public Node(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Node) {
			Node node = (Node) obj;
			return id == node.id;
		}
		return super.equals(obj);
	}

	public void addNextNode(Node nextNode) {
		this.nextNodes.add(nextNode);
	}

	public void addPreNode(Node preNode) {
		this.preNodes.add(preNode);
	}
}
