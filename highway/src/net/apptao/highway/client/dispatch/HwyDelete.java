package net.apptao.highway.client.dispatch;


public class HwyDelete implements HwyCommand<HwyDeleteResult> {

	private static final long serialVersionUID = 7924202920484337744L;
	
	private long dataId;

	public HwyDelete(long dataId) {
		this.setDataId(dataId);
	}

	public void setDataId(long dataId) {
		this.dataId = dataId;
	}

	public long getDataId() {
		return dataId;
	}

}
