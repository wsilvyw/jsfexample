package util;

import com.sun.faces.context.FacesFileNotFoundException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Dispatcher {

    private static Dispatcher instance = null;

    private Dispatcher() {}

    public static synchronized Dispatcher getInstance() {
        if (instance == null)
            instance = new Dispatcher();
        return instance;
    }

    public void dispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pagePath = null;
        String prefix = "/WEB-INF/jsf";
        String suffix = ".xhtml";
        String errorPage = "/WEB-INF/jsf/error.xhtml";

        String pageName = request.getRequestURI();
        pagePath = prefix + pageName + suffix;

        try {
            request.getServletContext()
                    .getRequestDispatcher(pagePath)
                    .forward(request, response);
        } catch (FacesFileNotFoundException ex) {
            request.getServletContext()
                    .getRequestDispatcher(errorPage)
                    .forward(request, response);
        }

    }
}
