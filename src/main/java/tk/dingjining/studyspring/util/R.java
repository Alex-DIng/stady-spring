package tk.dingjining.studyspring.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class R implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int code;
	private String msg;
	private Map<String, Object> data;

	private R(int code, String msg, Map<String, Object> data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public static R success() {
		return new R(200, "成功", null);
	}

	public static R fail() {
		return new R(500, "失败", null);
	}

	public static R build(int code, String msg) {
		return new R(200, msg, null);
	}

	public R put(String key, Object msg) {
		if (this.getData() == null) {
			this.setData(new HashMap<>(16));
		}
		this.getData().put(key, msg);
		return this;
	}
}
