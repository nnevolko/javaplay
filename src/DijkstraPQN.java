import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Stack;

public class DijkstraPQN {

	List<Edge> edges;
	List<DNode> nodes;
	Map<DNode, Integer> pathWeight = new HashMap<DNode, Integer>();
	Map<DNode, DNode> previous = new HashMap<DNode, DNode>();
	PriorityQueue<Pair> remainingQueue;
	DNode source;
	Map<DNode, Boolean> processedNodes = new HashMap<DNode, Boolean>();

	public DijkstraPQN(DNode source) {
		edges = new ArrayList<Edge>();
		nodes = new ArrayList<DNode>();

		// set path weights to infinity, could use max integer max minus 1
		/*
		 * for (int i = 0; i<size; i++){ pathWeight.add(i, 99999); }
		 */

		this.source = source;
		nodes.add(source);

	}

	public int getNumberOfEdges() {
		return edges.size();
	}

	public int getNumberOfVertices() {
		return nodes.size();
	}

	public void printGraph() {
		for (Edge e : edges) {
			System.out.print(", " + e.getFromNode().getName() + "-" + e.getToNode().getName()
					+ " (" + e.getDistance() + ")");
		}
		System.out.println();
	}

	public void printGraphNumbers() {
		System.out.println("Graph (V, E)-> (" + this.getNumberOfVertices() + ", "
				+ this.getNumberOfEdges() + ")");
	}

	// nodes have unique id's when searching need to use id to find the correct node
	public DNode findNode(String name) {
		for (final DNode tempNode : nodes) {
			if (tempNode.getName().equals(name)) {
				return tempNode;
			}
		}
		return null;
	}

	public DNode findNode(DNode node) {
		for (final DNode tempNode : nodes) {
			if (tempNode.equals(node)) {
				return node;
			}
		}
		return null;
	}

	public void addEdge(DNode fromNode, DNode toNode, Integer weight) {

		if (findNode(fromNode) == null) {
			nodes.add(fromNode);
			System.out.println("Adding new node:" + fromNode);
		}

		if (findNode(toNode) == null) {
			nodes.add(toNode);
			System.out.println("Adding new node: " + toNode);
		}
		Edge newEdge = new Edge(fromNode, toNode, weight);
		System.out.println("Adding edge" + newEdge);
		addEdge(newEdge);
	}

	public void addEdge(String fromName, String toName, Integer weight) {
		DNode fromNode;
		DNode toNode;

		String fromNameTrimmed = fromName.trim();
		String toNameTrimmed = toName.trim();

		fromNode = findNode(fromNameTrimmed);
		if (fromNode == null) {
			fromNode = new DNode(fromNameTrimmed);
			System.out.println("Adding new node" + fromNode);
			nodes.add(fromNode);
		}
		toNode = findNode(toNameTrimmed);
		if (toNode == null) {
			toNode = new DNode(toNameTrimmed);
			System.out.println("Adding new node" + toNode);
			nodes.add(toNode);
		}

		Edge newEdge = new Edge(fromNode, toNode, weight);
		System.out.println("Adding edge" + newEdge);
		addEdge(newEdge);
	}

	public void calculateDistances() {
		// initialize path_weight
		for (DNode node : nodes) {
			pathWeight.put(node, Integer.MAX_VALUE - 1000);
			processedNodes.put(node, false);
			previous.put(node, null);
		}

		remainingQueue = new PriorityQueue<Pair>(edges.size(), new ORDER_BY_DISTANCE());

		// set distance from source to source to zero
		Pair sourceToAdd = new Pair(source, 0);
		remainingQueue.add(sourceToAdd);
		pathWeight.put(source, 0);

		while (!remainingQueue.isEmpty()) {
			Pair currentNodePair = remainingQueue.remove();
			DNode currentNode = currentNodePair.getNode();
			System.out.println(">>>Processing the node: " + currentNode);

			List<DNode> neighbors = this.getNeighbors(currentNode);
	
			for (DNode neighbor : neighbors) {
				Integer previousDistance = pathWeight.get(neighbor);
			//	System.out.println("weight from " + currentNode + " to " + (previous.get(currentNode).getName()==null?" null": previous.get(currentNode).getName()) + " is " + previousDistance);
				Integer distanceBetweenNodes = getDistance(currentNode, neighbor);
				Integer newDistance = pathWeight.get(currentNode) + distanceBetweenNodes;
				System.out.println("weight from " + currentNode + " to " + neighbor + " is " + newDistance);
				if (newDistance < previousDistance) {
					previous.put(neighbor, currentNode);
					pathWeight.put(neighbor, newDistance);
				}
				Boolean alreadyVisited = processedNodes.get(neighbor);
				if (!alreadyVisited) {
					Pair neighborToProcess = new Pair(neighbor, newDistance);
					System.out.println("Enqueing: " + neighborToProcess);
					remainingQueue.add(neighborToProcess);
				}

			}
			processedNodes.put(currentNode, true);

		}
	}
	
	public void printVisited(){
		System.out.print("Visited:");
		for (Entry<DNode, Boolean> entry : processedNodes.entrySet()) {
			System.out.println("[" + entry.getKey() + "]:[" + entry.getValue() + "]");
		}
		System.out.println();
	}

	public void printPrevious() {
		System.out.print("Previous:");
		for (Entry<DNode, DNode> entry : previous.entrySet()) {
			System.out.println("[" + entry.getKey() + "]:[" + entry.getValue() + "]");
		}
		System.out.println();
	}

	public void printPathWeight() {
		System.out.println("Shortest Path Weight: ");
		for (Entry<DNode, Integer> entry : pathWeight.entrySet()) {
			System.out.println("[" + entry.getKey() + "]:[" + entry.getValue() + "]");
		}
		System.out.println();
	}

	public List<DNode> getPath(DNode endNode) {
		List path = new ArrayList<DNode>();

		DNode step = endNode;
		while (previous.get(step) != null){
			path.add(step);
			step = previous.get(step);
		}
		if (path.size()>0){
			path.add(source);
		}
		Collections.reverse(path);
		this.printPath(path);
		return path;
	}

	public void printPath(List<DNode> path) {
		for (DNode node : path) {
			System.out.print(node.getName() + "-");
		}
		System.out.println("\n");
	}

	public List<DNode> getNeighbors(final DNode node) {
		List<DNode> neighbors = new ArrayList<DNode>();
		Boolean alreadyProcessed = processedNodes.get(node);
		if (alreadyProcessed){
			return neighbors;
		}
		for (Edge edge : edges) {
			if (edge.getFromNode().equals(node)) {
				// check if this node was processed previously, no need to run through it again				
					neighbors.add(edge.getToNode());
			}
		}
		printVisited();
		System.out.println("Neighbors of "+ node +" are " + neighbors.toString());
		return neighbors;
	}

	public Integer getDistance(DNode from, DNode to) {

		for (Edge e : edges) {
			if (e.getFromNode().equals(from) && e.getToNode().equals(to)) {
				return e.getDistance();
			}
		}
		return null;
	}

	public Edge getCorrespondingEdge(DNode from, DNode to) {
		for (Edge e : edges) {
			if (e.getFromNode().equals(from) && e.getToNode().equals(to)) {
				return e;
			}
		}
		return null;
	}

	private void addEdge(final Edge e) {
		if (edges == null) {
			edges = new ArrayList<Edge>();
			edges.add(e);
		} else {
			edges.add(e);
		}
	}

	public class ORDER_BY_DISTANCE implements Comparator<Pair> {

		public int compare(Pair p, Pair p2) {
			int compareByWeight = p.getWeight().compareTo(p2.getWeight());
			if (compareByWeight == 0) {
				return p.getNode().getName().compareTo(p2.getNode().getName());
			} else {
				return compareByWeight;
			}

		}
	}

	public static class Pair {

		private Integer weight;
		private DNode node;

		public Pair(DNode node, Integer weight) {
			this.weight = weight;
			this.node = node;
		}

		public DNode getNode() {
			return node;
		}

		public void setNode(DNode node) {
			this.node = node;
		}

		public Integer getWeight() {
			return weight;
		}

		public void setWeight(Integer weight) {
			this.weight = weight;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((weight == null) ? 0 : weight.hashCode());
			result = prime * result + ((node == null) ? 0 : node.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (weight == null) {
				if (other.weight != null)
					return false;
			} else if (!weight.equals(other.weight))
				return false;

			if (node == null) {
				if (other.node != null)
					return false;
			} else if (!node.equals(other.node))
				return false;

			return true;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Pair [weight=");
			builder.append(weight);
			builder.append(", node=");
			builder.append(node);
			builder.append("]");
			return builder.toString();
		}
		
		

	}

}
