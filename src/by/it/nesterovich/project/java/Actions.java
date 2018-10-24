package by.it.nesterovich.project.java;

public enum Actions {

    INDEX {
        {
            this.jsp = "/index.jsp";
        }
    },
    LOGIN {
        {
            this.jsp = "/login.jsp";
        }
    },
    SIGNUP {
        {
            this.jsp = "/signup.jsp";
        }
    },
    LOGOUT {
        {
            this.jsp = "/logout.jsp";
        }
    },
    CREATEFILM{
        {
            this.jsp = "/createfilm.jsp";
        }
    },
    LISTFILM{
        {
            this.jsp = "/listfilm.jsp";
        }
    }    ;

    public String jsp = "/error.jsp";

}
