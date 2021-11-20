package pattern.behavioral.responsibility.jdk;

/**
 * @author Freaver
 * @date 4/30/2021 16:45
 */
public interface Filter {
    public void doFilter(Request request, Response response, FilterChain filterChain);
}
