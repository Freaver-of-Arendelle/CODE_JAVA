package pattern.behavioral.responsibility.jdk;

import java.nio.channels.FileChannel;
import java.security.UnresolvedPermission;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Freaver
 * @date 4/30/2021 16:45
 */
public class FilterChain {

    private List<Filter> filters = new ArrayList<>();

    private int index = 0;

    public FilterChain addFilter(Filter filter) {
        this.filters.add(filter);
        return this;
    }

    public void doFilter(Request request, Response response) {
        if (index == filters.size()) {
            return;
        }

        Filter filter = filters.get(index);
        index++;
        filter.doFilter(request, response, this);
    }
}
