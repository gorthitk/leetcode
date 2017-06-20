public class Solution {
	private static final String IPV4 = "IPv4";
	private static final String IPV6 = "IPv6";
	private static final String NEITHER = "Neither";
	private static final String IPV4_DELIMITER = "\\.";
	private static final String IPV6_DELIMITER = "\\:";

	public String validIPAddress(String IP) {
		if (IP.contains(".")) {
			String[] ipAddress = IP.split(IPV4_DELIMITER);
			if (ipAddress.length != 4 || IP.charAt(IP.length() - 1) == '.' || IP.charAt(0) == '.')
				return NEITHER;
			for (String add : ipAddress) {
				int num = getNumber(add);
				if (add.isEmpty() || num == -1 || num > 255 || (num > 0 && add.charAt(0) == '0') || (num == 0 && add.length() != 1)) {
					return NEITHER;
				}
				for (char c : add.toCharArray()) {
					if (c < '0' || c > '9') {
						return NEITHER;
					}
				}
			}
			return IPV4;
		} else if (IP.contains(":")) {
			String[] ipAddress = IP.split(IPV6_DELIMITER);
			if (ipAddress.length != 8 || IP.charAt(IP.length() - 1) == ':' || IP.charAt(0) == ':')
				return NEITHER;
			for (String add : ipAddress) {
				if (add.isEmpty() || add.length() > 4) {
					return NEITHER;
				}
				for (char c : add.toCharArray()) {
					if ((c < '0' || c > '9') && (c < 'a' || c > 'f') && (c < 'A' || c > 'F')) {
						return NEITHER;
					}
				}
			}
			return IPV6;
		}
		return NEITHER;
	}

	private int getNumber(String add) {
		try {
			return Integer.parseInt(add);
		} catch (Exception exp) {
			return -1;
		}
	}
}