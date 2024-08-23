package main.java;

	/*
	 * nnevolko
	 */
public class Edge {

	DNode fromNode;
	DNode toNode;
	Integer distance;

	public Edge(DNode fromNode, DNode toNode, Integer distance) {
		this.fromNode = fromNode;
		this.toNode = toNode;
		this.distance = distance;
	}

	public DNode getFromNode() {
		return fromNode;
	}

	public void setFromNode(DNode fromNode) {
		this.fromNode = fromNode;
	}

	public DNode getToNode() {
		return toNode;
	}

	public void setToNode(DNode toNode) {
		this.toNode = toNode;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((fromNode == null) ? 0 : fromNode.hashCode());
		result = prime * result + ((toNode == null) ? 0 : toNode.hashCode());
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
		Edge other = (Edge) obj;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		if (fromNode == null) {
			if (other.fromNode != null)
				return false;
		} else if (!fromNode.equals(other.fromNode))
			return false;
		if (toNode == null) {
			if (other.toNode != null)
				return false;
		} else if (!toNode.equals(other.toNode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Edge [fromNode=");
		builder.append(fromNode);
		builder.append(", toNode=");
		builder.append(toNode);
		builder.append(", distance=");
		builder.append(distance);
		builder.append("]");
		return builder.toString();
	}

	
}
