package commons;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface RequestStrategy {
    public void execute(HttpServletRequest request, HttpServletResponse response);
}
