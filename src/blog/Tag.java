package blog;

import java.io.Serializable;

public class Tag implements Serializable {

	private static final long serialVersionUID = 2482342423492341L;

	private int tagId;
	private String tagName;
	private int postId;

	public Tag() {
	}

	public Tag(int tagId, String tagName, int postId) {
		super();
		this.tagId = tagId;
		this.tagName = tagName;
		this.postId = postId;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	@Override
	public String toString() {
		return "Tag [tagId=" + tagId + ", tagName=" + tagName + ", postId=" + postId + "]";
	}

}
