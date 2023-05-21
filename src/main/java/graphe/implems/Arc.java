package main.java.graphe.implems;

public class Arc {
	private String source;
	private String destination;
	private int valuation;
	
	public Arc(String source, String destination, int valuation) {
		assert (valuation >= 0 && source != null && destination != null);
		this.source = source;
		this.destination = destination;
		this.valuation = valuation;
	}
	
	public String getSource() {
		return this.source;
	}

	public String getDestination() {
		return this.destination;
	}
	
	public int getValuation() {
		return this.valuation;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.source);
		sb.append("-");
		sb.append(this.destination);
		sb.append("(");
		sb.append(this.valuation);
		sb.append(")");
		
		
		return sb.toString();
	}
	
	public boolean equals(Arc a) {
		return this.destination == a.destination && this.source == a.source;
	}
}
