package net.apptao.highway.shared.dispatch;

public class HwyPut implements HwyCommand<HwyPutResult> {

	private static final long serialVersionUID = -2326996747768005507L;
	
	private Object data;
	
	public HwyPut(Object data) {
		this.setData(data);
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}
	
}
