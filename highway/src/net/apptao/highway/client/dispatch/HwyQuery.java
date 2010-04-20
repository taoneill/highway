package net.apptao.highway.client.dispatch;

public class HwyQuery {
	private String filter;
	private Class<?> dataClass;

	public HwyQuery(Class<?> dataClass){
		this.setDataClass(dataClass);
	}
	
	HwyQuery filter(String filter){
		this.setFilter(this.getFilter() + (filter + " "));
		return this;
	}

	public void setDataClass(Class<?> dataClass) {
		this.dataClass = dataClass;
	}

	public Class<?> getDataClass() {
		return dataClass;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getFilter() {
		return filter;
	}
}
