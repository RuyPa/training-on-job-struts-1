package consts;

public class Consts {

	public static class UserConst {

		private UserConst() {

		}

		public final static String EMAIL = "email";
		public final static String PASSWORD = "password";
		public final static String NAME = "name";
		public final static String ROLE = "role";
		public final static String ADDRESS = "address";
		public final static String CREATED_DATE = "created_date";
		public final static String CREATED_BY = "created_by";

	}

	public static class UserAction {

		private UserAction() {

		}

		public final static String GET_ACTION = "get";
	}

	public static class Attribute {
		private Attribute() {

		}

		public final static String USER = "users";
		public final static String ITEMS = "items";
	}

	public static class Status {
		private Status() {

		}

		public final static String SUCCESS = "success";
	}
}
