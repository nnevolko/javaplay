	/*
	 * nnevolko
	 */
public class DNode implements Comparable<DNode> {

	private String name;

	public DNode(String name) {
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		DNode other = (DNode) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(DNode o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}

}
