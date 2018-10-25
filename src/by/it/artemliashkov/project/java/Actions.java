package by.it.artemliashkov.project.java;

public  enum Actions {

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
    };

    public String jsp = "/error.jsp";

}
