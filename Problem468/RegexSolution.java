public class Solution
{
    private static final String IPV4 = "IPv4";
    private static final String IPV6 = "IPv6";
    private static final String NEITHER = "Neither";
    private static final String IPV4_REGEX = "(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5]))";
    private static final String IPV6_REGEX = "(([0-9a-fA-F]{1,4}):){7}([0-9a-fA-F]{1,4})";

    public String validIPAddress(String IP)
    {
        return IP.matches(IPV4_REGEX) ? IPV4 : IP.matches(IPV6_REGEX) ? IPV6 : NEITHER;
    }

}