package by.it.galushka.project.java;

enum Action {

    INDEX {{
        cmd = new CmdIndex();
    }},
    LOGIN {{
        cmd = new CmdLogin();
    }},
    SIGNUP {{
        cmd = new CmdSignUp();
    }},
//    LOGOUT {{
////        cmd = new CmdLogout();
//    }},
    ERROR {{
        cmd = new CmdError();
    }};

    public String getJsp() {
        return "/" + this.cmd.toString().toLowerCase() + ".jsp";
    }

    public Cmd cmd = new CmdError();
}
