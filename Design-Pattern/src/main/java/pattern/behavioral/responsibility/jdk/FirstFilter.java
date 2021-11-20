package pattern.behavioral.responsibility.jdk;

/**
 * @author Freaver
 * @date 4/30/2021 16:53
 */
public class FirstFilter implements Filter{
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        System.out.println("Filter1 PreSolve");

        filterChain.doFilter(request, response);

        System.out.println("Filter1 PostSolve");
    }
}
