package by.it.akhmelev.project6.java.controller;

enum Action {

    INDEX {{
        cmd = new CmdIndex();
    }},
    RESET {{
        cmd = new CmdReset();
    }},
    LOGIN {{
        cmd = new CmdLogin();
    }},
    PROFILE {{
        cmd = new CmdProfile();
    }},
    CREATEAD {{
        cmd = new CmdCreateAd();
    }},
    SIGNUP {{
        cmd = new CmdSignup();
    }},
    ERROR {{
        cmd = new CmdError();
    }};

    public String getJsp() {
        return "/" + this.cmd.toString().toLowerCase() + ".jsp";
    }

    public Cmd cmd = new CmdError();

}
