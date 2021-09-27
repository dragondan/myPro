import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class NodeMap {
	List<Node> nodes = new ArrayList<>();

	public Node getNode(int id) {
		return findNode(nodes, id);
	}

	private Node findNode(List<Node> nodes, int id) {
		Optional<Node> optional = nodes.stream().filter(n -> n.id == id).findFirst();
		if (optional.isPresent())
			return optional.get();
		Node node = new Node(id);
		nodes.add(node);
		return node;
	}

	public void sort() {
//		List<Node> ret = new ArrayList<>();
//		Optional<Node> findFirst = nodes.stream().filter(n -> n.preNodes.size() == 0).findFirst();
//		Node rootNode = findFirst.get();
//		ret.add(rootNode);
		nodes.sort(new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				if (n1.preNodes.size() == 0)
					return -1;
				if (n1.preNodes.stream().anyMatch(n -> n.id == n2.id)) {
					return -1;
				}
				if (n1.nextNodes.stream().anyMatch(n -> n.id == n2.id)) {
					return 1;
				}
				return 0;
			}

		});
	}

	public void print() {
		nodes.stream().forEach(n -> {
			System.out.println(n.id);
		});

	}

}
