package by.it.galushka.project.java;

public enum Action {

    INDEX {{
        this.jsp = "/index.jsp";
        cmd = new CmdIndex();
    }},
    LOGIN {{
        this.jsp = "/login.jsp";
        cmd = new CmdLogin();
    }},
    SIGNUP {{
        this.jsp = "/logout.jsp";
        cmd = new CmdSignUp();
    }},
    LOGOUT {{
        this.jsp = "/signup.jsp";
//        cmd = new CmdLogin();
    }},
    ERROR {{
        this.jsp = "/error.jsp";
        cmd = new CmdError();
    }};

    public String jsp = "/error.jsp";
    public Cmd cmd = new CmdError();
}
