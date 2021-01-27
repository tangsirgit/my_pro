package com.my.emplogin.enums;

public class ResponseEnums {
	public ResponseEnums() {
	}

	public static enum RESPONSE_CODE {
		SUCCESS(1, "成功"),
		FAILD(2, "失败");

		private int code;
		private String name;

		private RESPONSE_CODE(int code, String name) {
			this.code = code;
			this.name = name;
		}

		public int getCode() {
			return this.code;
		}

		public String getName() {
			return this.name;
		}
	}

	public static enum RESPONSE_ERROR_CODE {
		PARAM_WARNING(1, "参数错误"),
		DB_WARNING(2, "数据库异常"),
		CODE_WARNING(3, "代码运行异常"),
		UNKNOWN_WARNING(4, "未知异常");

		private int code;
		private String name;

		private RESPONSE_ERROR_CODE(int code, String name) {
			this.code = code;
			this.name = name;
		}

		public int getCode() {
			return this.code;
		}

		public String getName() {
			return this.name;
		}
	}
}
