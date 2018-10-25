package by.it.voinilo.project.java;

public enum Actions {

    INDEX {{
        this.jsp = "/index.jsp";
    }},
    SIGNUP {{
        this.jsp = "/signup.jsp";
    }},
    LOGIN {{
        this.jsp = "/login.jsp";
    }},
    LOGOUT {{
        this.jsp = "/logout.jsp";
    }};

    public String jsp = "/error.jsp";
}
