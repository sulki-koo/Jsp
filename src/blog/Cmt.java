package blog;

import java.io.Serializable;

public class Cmt implements Serializable {

	private static final long serialVersionUID = 1231563648657870801L;

	private int cmtId;
	private String cmtName;
	private String cmtText;
	private int cmtPostId;

	public Cmt() {
	}

	public Cmt(int cmtId, String cmtName, String cmtText, int cmtPostId) {
		super();
		this.cmtId = cmtId;
		this.cmtName = cmtName;
		this.cmtText = cmtText;
		this.cmtPostId = cmtPostId;
	}

	public int getCmtId() {
		return cmtId;
	}

	public void setCmtId(int cmtId) {
		this.cmtId = cmtId;
	}

	public String getCmtName() {
		return cmtName;
	}

	public void setCmtName(String cmtName) {
		this.cmtName = cmtName;
	}

	public String getCmtText() {
		return cmtText;
	}

	public void setCmtText(String cmtText) {
		this.cmtText = cmtText;
	}

	public int getCmtPostId() {
		return cmtPostId;
	}

	public void setCmtPostId(int cmtPostId) {
		this.cmtPostId = cmtPostId;
	}

	@Override
	public String toString() {
		return "Cmt [cmtId=" + cmtId + ", cmtName=" + cmtName + ", cmtText=" + cmtText + ", cmtPostId=" + cmtPostId
				+ "]";
	}

}
