import java.util.Arrays;

public class TingTest {
	public static void main(String[] args) {
		Edege[] edeges=new Edege[5];
		edeges[0]=new Edege(0,1);
		edeges[1]=new Edege(0,2);
		edeges[2]=new Edege(3,0);
		edeges[3]=new Edege(2,1);
		edeges[4]=new Edege(4,3);
		getOrderedId(5,edeges);
	}

	private  static void getOrderedId(int nodeCount, Edege[] edegs) {
		NodeMap nodeMap = new NodeMap();
		Arrays.stream(edegs).forEach(e -> {
			Node preNode = nodeMap.getNode(e.preId);
			Node nextNode = nodeMap.getNode(e.nextId);
			preNode.addNextNode(nextNode);
			nextNode.addPreNode(preNode);
		});
		nodeMap.sort();
		nodeMap.print();
	}

}
