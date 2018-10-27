package by.it.korolchuk.project.java;

public enum Actions {

    INDEX {{
        this.JSP = "/index.jsp";
    }}, LOGIN {{
        this.JSP = "/login.jsp";
    }}, LOGOUT {{
        this.JSP = "/logout.jsp";
    }}, SIGNUP {{
        this.JSP = "/signup.jsp";
    }}, CREATEAD {{
        this.JSP = "/create-ad.jsp";
    }}, LISTAD {{
        this.JSP = "/list-ad.jsp";
    }};

    public String JSP = "/error.jsp";
}


