package model;

import java.io.Serializable;

public class CommSearcher implements Serializable {

	private static final long serialVersionUID = 132136549873214L;

	private int blogId;
	private String searchKey;
	private String searchValue;

	public CommSearcher() {
	}

	public CommSearcher(int blogId, String searchKey, String searchValue) {
		this.blogId = blogId;
		this.searchKey = searchKey;
		this.searchValue = searchValue;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	@Override
	public String toString() {
		return "CommSearcher [blogId=" + blogId + ", searchKey=" + searchKey + ", searchValue=" + searchValue + "]";
	}

}
