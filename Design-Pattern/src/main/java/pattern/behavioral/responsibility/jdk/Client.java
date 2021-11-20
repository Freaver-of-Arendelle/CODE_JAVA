package pattern.behavioral.responsibility.jdk;

/**
 * @author Freaver
 * @date 4/30/2021 16:55
 */
public class Client {
    public static void main(String[] args) {
        Request request = null;
        Response response = null;

        FilterChain filterChain = new FilterChain();

        filterChain.addFilter(new FirstFilter()).addFilter(new SecondFilter());

        filterChain.doFilter(request, response);
    }
}
