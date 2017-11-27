package Utils;

public enum QuestionTag {
	Requirements ("Requirements"), 
	Agile ("Agile"),
	TDD ("TDD"), 
	ConfigurationManagement ("Configuration Management"),
	SoftwareArchitecture("Software Architecture"),
	SOAnCloud ("SOA and Cloud"),
	DesignPatterns ("Design Patterns"),
	SoftwareTesting ("Software Testing"),
	Maintenance ("Maintenance"),
	CostsnRisks ("Costs and Risks");
	
	
	private String tag;
	
	
	QuestionTag(String tag) {
		this.tag = tag;
	}
	
	
	public String getName() {
		return this.tag;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getName();
	}
	
}