package net.apptao.highway.shared.dispatch;


public class HwyGet implements HwyCommand<HwyGetResult> {

	private static final long serialVersionUID = -4984323251731370401L;
	
	private Long dataId;
	private String dataName;
	private Iterable<?> idsOrNames;

	private Class<?> dataType;

	public HwyGet(Class<?> dataType, Long dataId) {
		this.setDataId(dataId);
	}

	public HwyGet(Class<?> dataType, String dataName) {
		this.setDataType(dataType);
		this.setDataName(dataName);
	}

	public HwyGet(Class<?> dataType, Iterable<?> idsOrNames) {
		this.setDataType(dataType);
		this.setIdsOrNames(idsOrNames);
	}

	public void setDataId(long dataId) {
		this.dataId = dataId;
	}

	public long getDataId() {
		return dataId;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataType(Class<?> dataType) {
		this.dataType = dataType;
	}

	public Class<?> getDataType() {
		return dataType;
	}

	public void setIdsOrNames(Iterable<?> idsOrNames) {
		this.idsOrNames = idsOrNames;
	}

	public Iterable<?> getIdsOrNames() {
		return idsOrNames;
	}

}
